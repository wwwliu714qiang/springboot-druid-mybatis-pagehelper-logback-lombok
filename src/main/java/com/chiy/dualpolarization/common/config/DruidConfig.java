package com.chiy.dualpolarization.common.config;
/**
 * .::::.
 * .::::::::.
 * :::::::::::    佛主保佑、永无Bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liuqiang
 * @ClassName DruidConfig
 * @Description druid  数据库连接池配置类
 * @Date 2020/5/12 19:07
 * @Version 1.0
 */
@Configuration
public class DruidConfig {

    /**
     * 白名单
     */
    @Value("${druid.registration.servlet.allow}")
    private String allow;
    /**
     * 黑名单，与allow同时存在的话优先于allow
     */
    @Value("${druid.registration.servlet.deny}")
    private String deny;
    /**
     * 登录druid监控页面的用户名
     */
    @Value("${druid.registration.servlet.loginUsername}")
    private String loginUsername;
    /**
     * 登录druid监控页面的密码
     */
    @Value("${druid.registration.servlet.loginPassword}")
    private String loginPassword;
    /**
     * 是否可以重置数据源
     */
    @Value("${druid.registration.servlet.resetEnable}")
    private String resetEnable;
    /**
     * 所有请求进行监控处理
     */
    @Value("${druid.registration.filter.urlPatterns}")
    private String urlPatterns;
    /**
     * 排除
     */
    @Value("${druid.registration.filter.exclusions}")
    private String exclusions;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 主要实现web监控的配置处理
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        // 表示进行druid监控的配置处理操作
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 白名单
        servletRegistrationBean.addInitParameter("allow", allow);
        // 黑名单，与allow同时存在的话优先于allow
        servletRegistrationBean.addInitParameter("deny", deny);
        // 用户名
        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
        // 密码
        servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
        // 是否可以重置数据源
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    /**
     * 监控
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        filterRegistrationBean.addUrlPatterns(urlPatterns);
        // 排除
        filterRegistrationBean.addInitParameter("exclusions", exclusions);
        return filterRegistrationBean;
    }
}
