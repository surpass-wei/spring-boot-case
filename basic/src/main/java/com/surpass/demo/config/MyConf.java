package com.surpass.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义配置
 *
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@Component  //  因为ConfigurationProperties取消了location属性，所以如果这里需要用@Component注册，用@EnableConfigurationProperties将导致无法自动注入属性值
@ConfigurationProperties(prefix = "surpass.info")
@PropertySource("classpath:/config/myConf.properties")
public class MyConf {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
