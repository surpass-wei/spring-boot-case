package com.surpass.demo.config.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession监听器
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("监听器：Session >>>> 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("监听器：Session >>>> 销毁");
    }
}
