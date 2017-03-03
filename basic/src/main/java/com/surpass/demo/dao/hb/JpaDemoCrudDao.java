package com.surpass.demo.dao.hb;

import com.surpass.demo.domain.JpaDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository自带有常用的增删查改方法，这样及一个基本的dao就完成了
 *
 * Created by surpass.wei@gmail.com on 2017/2/21.
 */
@Repository
public interface JpaDemoCrudDao extends CrudRepository<JpaDemo, Long> {
}
