package com.ey.hc.security.realm;

import com.ey.hc.mapper.HcShiroUserRoleMapper;
import com.ey.hc.mapper.HcUserMapper;
import com.ey.hc.model.HcPermission;
import com.ey.hc.model.HcUser;
import com.ey.hc.security.jwt.JwtToken;
import com.ey.hc.security.util.JwtTokenUtil;
import com.google.common.base.Strings;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UmsRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UmsRealm.class);


    @Autowired
    private HcShiroUserRoleMapper hcShiroUserRoleMapper;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) { SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
       String username=jwtTokenUtil.getUserNameFromToken(principal.toString());
       if (username == null){
           logger.error("用户信息为空");
       }
       try {
           //获取用户角色
           String role=hcShiroUserRoleMapper.getRole(username);
           authorizationInfo.addRole(role);
           List<HcPermission>  list=hcShiroUserRoleMapper.getPermission(role);
           for (HcPermission hcPermission: list){
               if (hcPermission !=null){
                   authorizationInfo.addStringPermission(hcPermission.getName());
               }
           }
           return authorizationInfo;
       }catch (Exception e){
           e.printStackTrace();
           logger.error("授权失败，系统内部错误");
           return authorizationInfo;
       }

    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String token= (String) authenticationToken.getCredentials();
       String username=jwtTokenUtil.getUserNameFromToken(token);
       if (Strings.isNullOrEmpty(username)){
           throw  new AuthenticationException("token非法无效");
       }
        HcUser hcUser=hcShiroUserRoleMapper.selectUserOne(username);

       if (hcUser == null){
           throw  new AuthenticationException("用户不存在");
       }
       if (hcUser.getStatus() == 0){
           throw  new AuthenticationException("账户已禁用，请联系管理员");
       }



        return new SimpleAuthenticationInfo(hcUser, ByteSource.Util.bytes(hcUser.getSalt()),getName());
    }
}
