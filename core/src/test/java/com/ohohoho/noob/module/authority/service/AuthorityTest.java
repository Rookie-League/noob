package com.ohohoho.noob.module.authority.service;

import com.ohohoho.noob.config.db.DruidDataSourceConfig;
import com.ohohoho.noob.config.db.TransactionConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author majunjie
 * @description
 * @date 2017/3/24 11:14
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ohohoho.noob.module.authority.service"})
@ContextConfiguration(classes = {TransactionConfig.class, DruidDataSourceConfig.class}, loader = SpringBootContextLoader.class)
@Slf4j
public class AuthorityTest extends AbstractTestNGSpringContextTests {
    @Test
    public void test() {
    }
}
