package com.surpass.demo.web;

import com.surpass.demo.config.MyConf;
import com.surpass.demo.config.datasourse.DataSourceProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试配置类的Controller
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@RestController
public class PropertiesController {

    @Resource
    private MyConf myConf;

    @Resource
    private DataSourceProperties dataSourceProperties;

    @RequestMapping("/myConf")
    public MyConf getMyConfProperties() {
        return myConf;
    }

    @RequestMapping("/DSInfo")
    public DataSourceProperties getDataSourceProperties() {
        return dataSourceProperties;
    }
}
