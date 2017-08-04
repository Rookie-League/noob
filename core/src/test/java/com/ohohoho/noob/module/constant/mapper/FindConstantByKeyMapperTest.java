package com.ohohoho.noob.module.constant.mapper;

import com.earphone.common.utils.JSONExtend;
import com.ohohoho.noob.config.db.DruidDataSourceConfig;
import com.ohohoho.noob.config.db.TransactionConfig;
import com.ohohoho.noob.module.constant.domain.FindConstantByKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/3/17
 * @createTime 15:42
 */
//@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ohohoho.noob.module.constant.mapper"})
@ContextConfiguration(classes = {TransactionConfig.class, DruidDataSourceConfig.class}, loader = SpringBootContextLoader.class)
@Slf4j
public class FindConstantByKeyMapperTest extends AbstractTestNGSpringContextTests {
    @Resource
    private FindConstantByKeyMapper mapper;

    @Test
    public void test() {
        log.info(JSONExtend.asPrettyJSON(mapper.selectOne(new FindConstantByKey("666"))));
    }
}