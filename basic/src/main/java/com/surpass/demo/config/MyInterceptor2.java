package com.surpass.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器2
 * 实现自定义拦截器只需要3步：
 * 1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。
 * 2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。
 * 2、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。
 * PS：本文重点在如何在Spring-Boot中使用拦截器，关于拦截器的原理请大家查阅资料了解。
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
public class MyInterceptor2 implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(MyInterceptor2.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("拦截器：MyInterceptor2 >>>> 在请求处理之前进行调用（Controller方法调用之前）");
        return true;    // 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("拦截器：MyInterceptor2 >>>> 在请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("拦截器：MyInterceptor2 >>>> 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
