package com.ohohoho.noob.module.constant.service;

import com.earphone.common.utils.JSONUtils;
import com.ohohoho.noob.config.DruidDBConfig;
import com.ohohoho.noob.config.TransactionConfig;
import com.ohohoho.noob.constant.BasicDataCode;
import com.ohohoho.noob.module.constant.domain.InsertNewConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;


/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/7
 * @createTime 13:12
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration(classes = {TransactionConfig.class, DruidDBConfig.class}, loader = SpringBootContextLoader.class)
public class ConstantServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ConstantService constantService;

    private final String key = "ahahaha";

    @Test
    public void testInsert() throws Exception {
        InsertNewConstant constant = new InsertNewConstant();
        constant.setKey(key);
        constant.setValue("yoyoyo");
        constant.setParentId(BasicDataCode.TOP_ID);
        constant.setOperUser("test");
        Assert.assertEquals(constantService.insert(constant), 1);
    }

    @Test(dependsOnMethods = "testInsert")
    public void testFindByKey() throws Exception {
        logger.info(JSONUtils.toJSON(constantService.findByKey(key)));
    }

    @Test(dependsOnMethods = "testInsert")
    public void testFindChildrenByParentId() throws Exception {
        logger.info(JSONUtils.toJSON(constantService.findChildrenByParentId(BasicDataCode.TOP_ID)));
    }

}