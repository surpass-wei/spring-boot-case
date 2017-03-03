package com.surpass.demo.config.datasourse;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * 数据库配置类
 * Created by surpass.wei@gmail.com on 2017/2/23.
 */
@Configuration

public class DatabaseConfig {
    private Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Resource
    private DataSourceProperties dataSourceProperties;

    /*配置一个DruidDataSource,然后Druid会监控这个数据源*/
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        druidDataSource.setInitialSize(dataSourceProperties.getInitialSize());
        druidDataSource.setMinIdle(dataSourceProperties.getMinIdle());
        druidDataSource.setMaxActive(dataSourceProperties.getMaxActive());
        druidDataSource.setMaxWait(dataSourceProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(dataSourceProperties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(dataSourceProperties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            druidDataSource.setFilters(dataSourceProperties.getFilters());
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        druidDataSource.setConnectionProperties(dataSourceProperties.getConnectionProperties());
        return druidDataSource;
    }
}
