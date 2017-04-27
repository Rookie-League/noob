package com.ohohoho.noob.mq.producer;

import com.ohohoho.noob.config.RabbitMQConfig;
import com.ohohoho.noob.mq.message.JSONMessage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description 自动注入需要启用EnableAutoConfiguration注解，但是因为yml文件配置了datasource，
 * 所以会默认启用数据源自动配置，但是本用例不需要数据源，因此自动配置选择忽略数据源自动配置。
 * ComponentScan注解用于扫描测试所需组件，ContextConfiguration注解配置对应配置类，
 * 使用SpringBootContextLoader是为了启用SpringBoot特性，如日志配置加载
 * @createDate 2017/4/13
 * @createTime 11:20
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.ohohoho.noob.mq"})
@ContextConfiguration(classes = {RabbitMQConfig.class}, loader = SpringBootContextLoader.class)
public class RabbitMQProducerTest extends AbstractTestNGSpringContextTests {

    @Resource
    private RabbitMQProducer rabbitMQProducer;

    @Test
    public void testSendDelayMessage() throws Exception {
        JSONMessage message = new JSONMessage();
        message.setKey("RabbitMQ");
        message.setValue("66666666666");
        rabbitMQProducer.sendDelayMessage(message, 10000);
    }

}