package com.ohohoho.noob.module.constant.mapper;

import com.earphone.common.utils.JSONExtend;
import com.ohohoho.noob.config.db.DruidDataSourceConfig;
import com.ohohoho.noob.config.db.TransactionConfig;
import com.ohohoho.noob.constant.ProjectConstant;
import com.ohohoho.noob.module.constant.domain.InsertNewConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
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
public class InserNewConstantMapperTest extends AbstractTransactionalTestNGSpringContextTests {
    @Resource
    private InsertNewConstantMapper mapper;

    @Test
    public void test() {
        InsertNewConstant constant = new InsertNewConstant();
        constant.setKey("ahahaha");
        constant.setValue("yoyoyo");
        constant.setParentId(ProjectConstant.TOP_ID);
        constant.setOperUser("test");
        log.info(JSONExtend.asJSON(mapper.insertSelective(constant)));
    }
}