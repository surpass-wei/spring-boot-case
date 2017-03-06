package com.surpass.demo.repository;

import com.surpass.demo.bean.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * DemoInfo持久类
 *
 * Created by surpass.wei@gmail.com on 2017/3/3.
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {

}
