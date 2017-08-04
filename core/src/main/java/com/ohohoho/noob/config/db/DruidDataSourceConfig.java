package com.ohohoho.noob.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.PASSWORD;
import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.URL;
import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.USERNAME;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/3/7
 * @createTime 8:57
 */
@Configuration
@Conditional(DruidDataSourceConfigurationCondition.class)
public class DruidDataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    //在同样的DataSource中，首先使用被标注的DataSource
    @Primary
    @Bean(value = "dataSource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
//        datasource.setDriverClassName(driverClassName);
//        datasource.setUrl(dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//###############################################################
//        StringBuilder url = new StringBuilder("jdbc:mysql://");
//        url.append(System.getenv("noob.jdbc.host")).append(":");
//        url.append(System.getenv("noob.jdbc.port")).append("/");
//        url.append(System.getenv("noob.jdbc.db")).append("?");
//        url.append("useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round");
//        datasource.setUrl(url.toString());
        datasource.setUrl(URL.getValue());
        datasource.setUsername(USERNAME.getValue());
        datasource.setPassword(PASSWORD.getValue());
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setFilters(filters);
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }
}