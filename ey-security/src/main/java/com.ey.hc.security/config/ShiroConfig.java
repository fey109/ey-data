package com.ey.hc.security.config;

import com.ey.hc.security.realm.UmsRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //这里设置了登录接口  如果访问了某个接口没有登录  就会调用这个接口（如果不是前后端分离就返回页面）
        shiroFilterFactoryBean.setLoginUrl("/ums/login");

        //如果是前后端分离则不需要这个
        //shiroFilterFactoryBean.setSuccessUrl("/");

        //这个是用户登录了  但没有权限 就会调用这个接口
        shiroFilterFactoryBean.setUnauthorizedUrl("/ums/permiss");

        /**
         *拦截器路径 坑1：部分路径无法拦截，拦截效果时有时无，因为使用了hashMap 是无序的应该使用linkedHashMap
         *原因在于过滤链执行顺序是顺序执行所以需要使用有序的linkedHashMap
         **/
        Map<String,String> filterMap=new LinkedHashMap<>();

        //匿名访问  游客访问路径
        filterMap.put("/ums/**","anon");

        //退出过滤器
        filterMap.put("/ums/logout","logout");

        //登录用户才能访问
        filterMap.put("/author/**","author");

        //只有管理员才能访问
        filterMap.put("/admin/**","roles[admin]");

        //坑2：过滤链是顺序执行的，从上而下，一般来讲/** 是放到最下面的

        //authc : url 必须通过认证才能访问
        //anon : url可以匿名访问
        filterMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return  shiroFilterFactoryBean;

    }

    @Bean
    public  SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(umsRealm());

        /*
         * 关闭shiro自带的session
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return  securityManager;
    }

    //自定义realm注入
    @Bean
    public UmsRealm umsRealm(){
        UmsRealm umsRealm=new UmsRealm();
        //密码加密方式，也可以自定义
        umsRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return umsRealm;
    }




    //加密方式
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置散列算法 ：这里设置的MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置多重加密算法 ：这里设置的是2次加密(mad5(md5(xxx)))
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    /**
     * 管理shiro一些bean的生命周期 即bean初始化 与销毁
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /**
     * 加入注解的使用，不加入这个AOP注解不生效(shiro的注解 例如 @RequiresGuest)
     * 用来扫描上下文寻找所有的Advistor(通知器),
     * 将符合条件的Advisor应用到切入点的Bean中，
     * 需要在LifecycleBeanPostProcessor创建后才可以创建
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

}
