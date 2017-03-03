package com.surpass.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WEB 相关配置
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/23.
 */
@Configuration
@EnableWebMvc   //  在配置类中添加该注解后，WebMvcAutoConfiguration中配置就不会生效，需要自己来配置每一项。
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * 自定义资源映射目录
     * 使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        * 如果我们将/myRes/* 修改为 /* 与默认的相同时，则会覆盖系统的配置，可以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的。
        * 其中 addResourceLocations 的参数是动参，可以这样写 addResourceLocations(“classpath:/img1/”, “classpath:/img2/”, “classpath:/img3/”);
        * */
        registry.addResourceHandler("/myRes/**").addResourceLocations("classpath:/myRes/");
        //  可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上"file:"
        registry.addResourceHandler("/api_files/**").addResourceLocations("file:C:/Users/dell/Downloads/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置自定义的拦截器
     * 只有经过DispatcherServlet 的请求，才会走拦截器链，
     * 我们自定义的Servlet 请求是不会被拦截的，
     * 比如我们自定义的Servlet地址http://localhost:8080/myServlet1 是不会被拦截器拦截的。
     * 并且不管是属于哪个Servlet 只要符合过滤器的过滤规则，过滤器都会拦截。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        * 多个拦截器组成一个拦截器链(执行顺序为先进后出)
        * addPathPatterns 用于添加拦截规则
        * excludePathPatterns 用户排除拦截
        * */
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
