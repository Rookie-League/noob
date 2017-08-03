package com.ohohoho.noob.module.constant.mapper;

import com.earphone.common.utils.JSONExtend;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.ohohoho.noob.config.DruidDBConfig;
import com.ohohoho.noob.config.TransactionConfig;
import com.ohohoho.noob.constant.ProjectConstant;
import com.ohohoho.noob.module.constant.domain.ConstantChild;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/3/17
 * @createTime 15:42
 */
//@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ohohoho.noob.module.constant.mapper"})
@ContextConfiguration(classes = {TransactionConfig.class, DruidDBConfig.class}, loader = SpringBootContextLoader.class)
public class FindConstantByParentIdMapperTest extends AbstractTestNGSpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindConstantByParentIdMapperTest.class);
    @Resource
    private FindConstantByParentIdMapper mapper;

    @Test
    public void test() {
        ISelect select = () -> mapper.select(new ConstantChild(ProjectConstant.TOP_ID));
        List<ConstantChild> list = PageHelper.startPage(1, 1).doSelectPage(select);
        LOGGER.info(JSONExtend.toJSON(list));
    }
}