package com.surpass.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Thymeleaf测试
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/23.
 */
@Controller
public class TemplateController {

    @RequestMapping("/helloTMF")
    public String helloThymeleaf(Map<String, Object> map) {
        map.put("hello", "my name is helloThymeleaf");
        return "/helloThymeleaf";
    }

    @RequestMapping("/helloFTL")
    public String helloFreemarker(Map<String, Object> map) {
        map.put("hello", "my name is helloFreemarker");
        return "/helloFreemarker";
    }
}
