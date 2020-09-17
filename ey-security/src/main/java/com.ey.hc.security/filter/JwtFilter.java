package com.ey.hc.security.filter;

import cn.hutool.json.JSON;
import com.ey.hc.security.jwt.JwtToken;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * 自定义拦截器
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    private static final String AUTHZ_HEADER = "token";
    private static final String CHARSET = "UTF-8";

    /**
     * 处理未经验证的请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean loggedIn = false;
        if (this.isLoginAttempt(request, response)) {
            loggedIn = this.executeLogin(request, response);
        }

        if (!loggedIn) {
            this.sendChallenge(request, response);
        }

        return loggedIn;
    }

    /**
     *
     *判断用户是否想要登入。
     *检测 header 里面是否包含 token 字段
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        String authzHeader = WebUtils.toHttp(request).getHeader(AUTHZ_HEADER);
        return authzHeader != null;
    }

    /**
     * 执行登录操作
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        String token = WebUtils.toHttp(request).getHeader(AUTHZ_HEADER);
        if (null == token) {
            String msg = "executeLogin method token must not be null";
            throw new IllegalStateException(msg);
        }
        //交给realm判断是否有权限,没权限返回false交给onAccessDenied
        JwtToken jwtToken = new JwtToken(token);
        try {
            this.getSubject(request, response).login(jwtToken);
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
    }

    /**
     * 执行登录操作
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
        @Override
        protected boolean isAccessAllowed (ServletRequest request, ServletResponse response, Object mappedValue){
            //判断请求的请求头是否带上 "token"
            if (isLoginAttempt(request, response)) {
                //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
                try {
                    executeLogin(request, response);
                    return true;
                } catch (Exception e) {
                    //token 错误
                    responseError(response, e.getMessage());
                }
            }
            //如果请求头不存在 token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
            return true;
        }


    /**
     * 提供跨域支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse
                    .setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
            httpServletResponse.setHeader("Access-Control-Allow-Headers",
                    httpServletRequest.getHeader("Access-Control-Request-Headers"));
            // 跨域时,option请求直接返回正常状态
            if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
                httpServletResponse.setStatus(HttpStatus.OK.value());
                return false;
            }
            return super.preHandle(request, response);
        }


    /**
     * 将非法请求跳转到 /unauthorized/**
     * @param response
     * @param message
     */

    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
    }

