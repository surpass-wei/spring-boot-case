package com.surpass.demo.service;

import com.surpass.demo.dao.hb.JpaDemoCrudDao;
import com.surpass.demo.dao.hb.JpaDemoTemplateDao;
import com.surpass.demo.domain.JpaDemo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by surpass.wei@gmail.com on 2017/2/21.
 */
@Service
public class JpaDemoService {
    @Resource
    private JpaDemoCrudDao jpaDemoDao;

    @Resource
    private JpaDemoTemplateDao jpaDemoTemplateDao;

    @Transactional
    public JpaDemo save(JpaDemo jpaDemo) {
        return jpaDemoDao.save(jpaDemo);
    }

    public JpaDemo get(Long id) {
        return jpaDemoTemplateDao.getById(id);
    }
}
