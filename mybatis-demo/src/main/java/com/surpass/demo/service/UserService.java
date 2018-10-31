package com.surpass.demo.service;

import com.surpass.demo.bean.User;
import com.surpass.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by surpass.wei@gmail.com on 2017/4/10.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> likeName(String name){
        return userMapper.likeName(name);
    }

    public List<User> getAll() {
        return userMapper.getAll();
    }

    public int add(String name, Integer age) {
        return userMapper.insertOne(name, age);
    }
}
