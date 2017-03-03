package com.surpass.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 普通类调用Spring bean对象：
 * <p>
 * 说明：
 * 1、此类需要放到Application.java同包或者子包下且有@Component注解才能被扫描，否则失效。
 * 2、如果不满足第1点条件，那么，也可以通过使用@Bean注解，在Application.java类中将SpringUtil注解进来达到目的
 * 3、除了方式2，还可以在Application.java中使用@Import进行导入。
 * <p>
 * 那么这样子在普通类既可以使用:
 * SpringUtil.getBean() 获取到Spring IOC容器中的bean。
 * <p>
 * 当然也可以在Spring管理的类中：
 * 使用 @Resource 或者 @Autowired 进行注入使用
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/23.
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
