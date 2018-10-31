package com.surpass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by surpass.wei@gmail.com on 2017/4/10.
 */
@SpringBootApplication
@MapperScan("com.surpass.*.mapper")
public class MybatisDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApp.class, args);
    }
}
