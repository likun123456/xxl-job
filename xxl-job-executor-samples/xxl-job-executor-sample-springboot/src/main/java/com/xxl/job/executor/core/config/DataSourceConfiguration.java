package com.xxl.job.executor.core.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.Set;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/1 14:32
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfiguration {

    private final static String DATASOURCE_TAG = "db";

    @Resource
    private ApplicationContext applicationContext;

    @ApolloConfig
    private Config config;

    /**
     * 使用apollo的事件监听
     *
     * @param configChangeEvent
     */
    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent configChangeEvent) {
        // 1.通过监听事件拿到所有被修改的key的集合
        Set<String> changedKeys = configChangeEvent.changedKeys();
        // 3.通过spring创建一个动态数据源对象
        DynamicDataSource dynamicDataSource = applicationContext.getBean(DynamicDataSource.class);
        // 4.动态修改数据源配置
        dynamicDataSource.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, this.dataSource()));
        // 5.配置修改好后刷新
        dynamicDataSource.afterPropertiesSet();
    }

    @Bean("dataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, this.dataSource()));
        return dynamicDataSource;
    }

    /**
     * 获取apollo中配置的数据源信息
     *
     * @return DataSource
     */
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(config.getProperty("spring.datasource.url", ""));
        dataSource.setUsername(config.getProperty("spring.datasource.username", ""));
        dataSource.setPassword(config.getProperty("spring.datasource.password", ""));
        return dataSource;
    }

    /**
     * 定义动态数据源
     */
    class DynamicDataSource extends AbstractRoutingDataSource {
        /**
         * 设置key
         *
         * @return
         */
        @Override
        protected Object determineCurrentLookupKey() {
            return DATASOURCE_TAG;
        }
    }

}
