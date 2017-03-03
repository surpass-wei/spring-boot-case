package com.surpass.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Bean配置管理
 * Created by surpass.wei@gmail.com on 2017/2/21.
 */
@Configuration
//  @EnableScheduling   //  告诉Spring创建一个task executor，如果我们没有这个标注，所有@Scheduled标注都不会执行
@ImportResource(locations = {"classpath:application-bean.xml"}) //  加载XML配置文件(spring boot不建议使用xml配置，同时需要@Configuration)
public class MyBeanConfig {

    /*注入Bean : HttpMessageConverters，以支持fastJson*/
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConvert);
    }

}
