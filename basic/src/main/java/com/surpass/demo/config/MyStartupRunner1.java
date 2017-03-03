package com.surpass.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动处理类1
 * <p>
 * Spring Boot应用程序在启动后，会遍历CommandLineRunner或ApplicationRunner接口的实例并运行它们的run方法。
 * 也可以利用@Order注解（或者实现Order接口）来规定所有CommandLineRunner或ApplicationRunner实例的运行顺序。
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@Component
@Order(value = 2)
public class MyStartupRunner1 implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(MyStartupRunner1.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("启动执行：MyStartupRunner1");
    }
}
