package com.ey.hc.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置监控服务器
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //第一种写法
        Map<String, String> map = new HashMap<>();
        //控制台管理用户
        map.put("loginUsername", "druid");
        map.put("loginPassword", "123456");
        //IP白名单
        map.put("allow", "127.0.0.1");
        //IP黑名单
        map.put("deny", "192.168.1.201");
        //是否能够充值数据
        map.put("resetEnable", "flase");
        bean.setInitParameters(map);
        //第二种写法
        //bean.addInitParameter("","");
        return  bean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterBean=new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterBean.addUrlPatterns("/*");
        //忽略过滤格式
        filterBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterBean;
    }


}
