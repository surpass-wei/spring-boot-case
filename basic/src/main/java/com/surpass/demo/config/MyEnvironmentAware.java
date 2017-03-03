package com.surpass.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 只要是被spring管理的类，实现接口：EnvironmentAware就能获取到系统环境信息
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware {
    private Logger logger = LoggerFactory.getLogger(MyEnvironmentAware.class);

    @Value("${spring.datasource.username}")
    private String userName;

    /**
     * 注意重写的方法 setEnvironment 是在系统启动的时候被执行
     */
    @Override
    public void setEnvironment(Environment environment) {
        logger.info("属性读取：MyEnvironmentAware >>>> username=" + userName);
        logger.info("属性读取：MyEnvironmentAware >>>> JAVA_HOME=" + environment.getProperty("JAVA_HOME"));  //  读取系统环境变量
        logger.info("属性读取：MyEnvironmentAware >>>> spring.datasource.password=" + environment.getProperty("spring.datasource.password"));

        /*
         *  需要特别注意这里的前缀末尾是带了“.”的
         *  另外虽然配置文件中是driver-class-name，但是获取driverClassName一样是可以拿到的，这应该是经过spring boot自身处理
         **/
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        logger.info("属性读取：MyEnvironmentAware >>>> spring.datasource.url=" + relaxedPropertyResolver.getProperty("url"));
        logger.info("属性读取：MyEnvironmentAware >>>> spring.datasource.driverClassName=" + relaxedPropertyResolver.getProperty("driverClassName"));
    }
}
