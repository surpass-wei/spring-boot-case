package com.surpass.demo.web;

import com.surpass.demo.domain.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful风格测试类
 * Created by surpass.wei@gmail.com on 2017/1/12.
 */
@RestController
public class RestfulDemoController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/author")
    public Author author() {
        Author author = new Author();
        author.setNickName("Tom");
        author.setRealName("Jack");
        return author;
    }

    @RequestMapping("/zeroException")
    public int zeroException() {
        return 100 / 0;
    }
}
