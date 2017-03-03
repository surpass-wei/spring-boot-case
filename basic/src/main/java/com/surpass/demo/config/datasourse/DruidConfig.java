package com.surpass.demo.config.datasourse;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Druid配置
 * 编写druid servlet和filter提供监控页面访问
 *
 * Created by surpass.wei@gmail.com on 2017/2/23.
 */
@Configuration
public class DruidConfig {

    /*注册一个Servlet*/
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean();
        servlet.addUrlMappings("/druid/*");
        servlet.setServlet(new StatViewServlet());
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("allow", "127.0.0.1,192.168.11.242");    // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("deny", "192.168.11.241");   // IP黑名单 (存在共同时，deny优先于allow)
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能
        servlet.setInitParameters(initParameters);
        return servlet;
    }

    /*注册一个Filter*/
    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");    //  添加过滤规则
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");   //  添加不需要忽略的格式信息.
        return filterRegistrationBean;
    }
}
