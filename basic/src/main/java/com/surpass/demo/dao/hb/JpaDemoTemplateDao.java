package com.surpass.demo.dao.hb;

import com.surpass.demo.domain.JpaDemo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 使用JdbcTemplate
 *
 * Created by surpass.wei@gmail.com on 2017/2/21.
 */
@Repository
public class JpaDemoTemplateDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过id获取demo对象.
     *
     * @param id
     * @return
     */
    public JpaDemo getById(long id) {
        String sql = "SELECT * FROM jpa_demo WHERE id=?";
        RowMapper<JpaDemo> rowMapper = new BeanPropertyRowMapper<JpaDemo>(JpaDemo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
