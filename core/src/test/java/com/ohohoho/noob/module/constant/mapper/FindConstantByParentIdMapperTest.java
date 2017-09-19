package com.ohohoho.noob.module.constant.mapper;

import com.earphone.common.utils.JSONExtend;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.ohohoho.noob.config.db.DruidDataSourceConfig;
import com.ohohoho.noob.config.db.TransactionConfig;
import com.ohohoho.noob.constant.ProjectConstant;
import com.ohohoho.noob.module.constant.domain.ConstantChild;
import lombok.extern.slf4j.Slf4j;
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
@ContextConfiguration(classes = {TransactionConfig.class, DruidDataSourceConfig.class}, loader = SpringBootContextLoader.class)
@Slf4j
public class FindConstantByParentIdMapperTest extends AbstractTestNGSpringContextTests {
    @Resource
    private FindConstantByParentIdMapper mapper;

    @Test
    public void test() {
        ISelect select = () -> mapper.select(new ConstantChild(ProjectConstant.TOP_ID));
        List<ConstantChild> list = PageHelper.startPage(1, 1).doSelectPage(select);
        log.info(JSONExtend.asPrettyJSON(list));
    }
}