package com.surpass.demo.service.serviceImp;

import com.surpass.demo.bean.DemoInfo;
import com.surpass.demo.repository.DemoInfoRepository;
import com.surpass.demo.service.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DemoInfo服务实现类
 * <p>
 * Created by surpass.wei@gmail.com on 2017/3/3.
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService{
    @Resource
    private DemoInfoRepository repository;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Cacheable(value = "demoInfo")
    @Override
    public DemoInfo findById(Long id) {
        System.err.println("DemoInfoServiceImpl.findById() >>> 从数据库中进行获取的..id="+id);
        return repository.findOne(id);
    }

    @CacheEvict(value = "demoInfo")  //  缓存，这里没有指定key
    @Override
    public void deleteFromCache(Long id) {
        System.out.println("DemoInfoServiceImpl.delete() >>> 从缓存中删除.");
    }

    @Override
    public void test() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myKey4", "random1="+Math.random());
        System.out.println(valueOperations.get("myKey4"));
    }
}
