package com.surpass.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这个类是通过application-bean.xml配置进入IOC容器的
 * <p>
 * Created by surpass.wei@gmail.com on 2017/3/1.
 */
public class HelloService {

    public HelloService() {
        Logger logger = LoggerFactory.getLogger(HelloService.class);
        logger.info("我是通过XML文件注入的：" + HelloService.class.toString());
    }
}
