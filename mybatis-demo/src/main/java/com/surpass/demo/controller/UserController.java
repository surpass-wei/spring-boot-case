package com.surpass.demo.controller;

import com.github.pagehelper.PageHelper;
import com.surpass.demo.bean.User;
import com.surpass.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by surpass.wei@gmail.com on 2017/4/10.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/likeName")
    public List<User> likeName(String name) {
        PageHelper.startPage(1, 2);
        return userService.likeName(name);
    }

    @RequestMapping("/getAll")
    public List<User> getAll() {
        PageHelper.startPage(1, 2);
        return userService.getAll();
    }

    @RequestMapping("/add")
    public String add(String name, Integer age) {
        int count = userService.add(name, age);

        return "插入成功数：" + count;
    }
}
