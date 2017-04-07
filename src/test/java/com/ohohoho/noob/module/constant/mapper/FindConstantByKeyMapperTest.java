package com.ohohoho.noob.module.constant.mapper;

import com.earphone.common.utils.JSONUtils;
import com.ohohoho.noob.config.DruidDBConfig;
import com.ohohoho.noob.config.TransactionConfig;
import com.ohohoho.noob.module.constant.domain.FindConstantByKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@ComponentScan
@ContextConfiguration(classes = {TransactionConfig.class, DruidDBConfig.class}, loader = SpringBootContextLoader.class)
public class FindConstantByKeyMapperTest extends AbstractTestNGSpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindConstantByKeyMapperTest.class);
    @Resource
    private FindConstantByKeyMapper mapper;

    @Test
    public void test() {
        LOGGER.info(JSONUtils.toJSON(mapper.selectOne(new FindConstantByKey("666"))));
    }
}