package com.surpass.demo.service;

import com.surpass.demo.bean.DemoInfo;

/**
 * DemoInfo服务接口
 * <p>
 * Created by surpass.wei@gmail.com on 2017/3/3.
 */
public interface DemoInfoService {
    public DemoInfo findById(Long id);

    public void deleteFromCache(Long id);

    void test();
}
