package com.surpass.demo.controller;

import com.surpass.demo.bean.DemoInfo;
import com.surpass.demo.service.DemoInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by surpass.wei@gmail.com on 2017/3/3.
 */
@Controller
public class DemoInfoController {
    @Resource
    private DemoInfoService demoInfoService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        DemoInfo loaded = demoInfoService.findById(1L);
        System.out.println("loaded="+loaded);
        DemoInfo cached = demoInfoService.findById(1L);
        System.out.println("cached="+cached);
        loaded = demoInfoService.findById(2L);
        System.out.println("loaded2="+loaded);
        return"ok";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id){
        demoInfoService.deleteFromCache(id);
        return"ok";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return"ok";
    }
}
