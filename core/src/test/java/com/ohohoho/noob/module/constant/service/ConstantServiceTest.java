package com.ohohoho.noob.module.constant.service;

import com.earphone.common.utils.JSONExtend;
import com.ohohoho.noob.config.db.DruidDataSourceConfig;
import com.ohohoho.noob.config.db.TransactionConfig;
import com.ohohoho.noob.module.constant.domain.InsertNewConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static com.ohohoho.noob.constant.ProjectConstant.TOP_ID;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/7
 * @createTime 13:12
 */
//直接使用该注解测试也是可以的，就是默认会加载较多非必要组件
//@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ohohoho.noob.module.constant.service"})
@ContextConfiguration(classes = {TransactionConfig.class, DruidDataSourceConfig.class}, loader = SpringBootContextLoader.class)
@Slf4j
public class ConstantServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private final String key = "ahahaha";
    @Resource
    private ConstantService constantService;

    @Test
    public void testInsert() throws Exception {
        InsertNewConstant constant = new InsertNewConstant();
        constant.setKey(key);
        constant.setValue("yoyoyo");
        constant.setParentId(TOP_ID);
        constant.setOperUser("test");
        Assert.assertEquals(constantService.insert(constant), 1);
    }

    @Test(dependsOnMethods = "testInsert")
    public void testFindByKey() throws Exception {
        log.info(JSONExtend.asPrettyJSON(constantService.findByKey(key)));
    }

    @Test(dependsOnMethods = "testInsert")
    public void testFindChildrenByParentId() throws Exception {
        log.info(JSONExtend.asPrettyJSON(constantService.findChildrenByParentId(TOP_ID)));
    }
}