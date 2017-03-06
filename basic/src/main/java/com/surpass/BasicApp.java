package com.surpass;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.surpass.demo.config.datasourse.DataSourceProperties;
import com.surpass.demo.config.servlet.MyServlet1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Spring Boot主应用程序
 *
 * 大家也许会看到有些demo使用了3个注解： @Configuration；@EnableAutoConfiguration；@ComponentScan
 * 其实：@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 * 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
 *
 * Created by surpass.wei@gmail.com on 2017/1/12.
 */
@SpringBootApplication  //  申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@ServletComponentScan   //  让spring boot自动管理servlet，不开启的话注解方式注册的servlet不起作用
//  @ComponentScan(basePackages = {"com.surpass"})  //  @ComponentScan注解进行指定要扫描的包以及要扫描的类
@EnableConfigurationProperties({DataSourceProperties.class})  //  将配置文件映射到响应的配置类中（spring boot貌似不推荐这么做）
public class BasicApp extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        //  初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        //  初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //  将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConvert);
    }

    @Bean
    public ServletRegistrationBean myServlet1() {
        return new ServletRegistrationBean(new MyServlet1(),"/myServlet1/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApp.class, args);
    }
}
