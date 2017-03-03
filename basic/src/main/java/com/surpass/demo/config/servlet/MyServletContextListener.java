package com.surpass.demo.config.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContext监听器
 * <p>
 * 使用@WebListener注解，实现ServletContextListener接口
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("监听器：ServletContext >>>> 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("监听器：ServletContext >>>> 销毁");
    }
}
