package com.example;

import com.surpass.BasicApp;
import com.surpass.demo.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Junit4测试类
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持
@SpringBootTest(classes = BasicApp.class)    // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration    //  由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class TestServiceTest {

    @Resource
    private TestService testService;

    @Test
    public void testGetName() {
        Assert.assertEquals("Test", testService.getName());
    }
    @Test
    public void test2() {
        String a = "-------------sdf  sdf";
        System.out.println(a.replaceAll(" ",""));
    }
}
