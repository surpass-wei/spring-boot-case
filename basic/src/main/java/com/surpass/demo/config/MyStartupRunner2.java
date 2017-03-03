package com.surpass.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动处理类2
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@Component
@Order(value = 1)
public class MyStartupRunner2 implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(MyStartupRunner2.class);

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("启动执行：MyStartupRunner2");
    }
}
