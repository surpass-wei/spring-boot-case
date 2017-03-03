package com.surpass.demo.web;

import com.surpass.demo.domain.JpaDemo;
import com.surpass.demo.service.JpaDemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用JPA持久化数据的controller
 * Created by surpass.wei@gmail.com on 2017/2/21.
 */
@RestController
@RequestMapping("/jpaDemo")
public class JpaDemoController {

    @Resource
    private JpaDemoService jpaDemoService;

    @RequestMapping(value = "/save")
    public JpaDemo save() {
        JpaDemo jpaDemo = new JpaDemo();
        jpaDemo.setFirstName("Gang");
        jpaDemo.setLastName("Li");

        return jpaDemoService.save(jpaDemo);
    }

    @RequestMapping(value = "/get/{id}")
    public JpaDemo get(@PathVariable Long id) {
        return jpaDemoService.get(id);
    }
}
