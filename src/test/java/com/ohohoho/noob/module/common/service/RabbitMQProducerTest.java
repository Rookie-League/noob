package com.ohohoho.noob.module.common.service;

import com.ohohoho.noob.config.DruidDBConfig;
import com.ohohoho.noob.config.TransactionConfig;
import com.ohohoho.noob.mq.producer.RabbitMQProducer;
import org.springframework.boot.SpringBootConfiguration;
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
 * @createDate 2017/4/13
 * @createTime 11:20
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration(classes = {TransactionConfig.class, DruidDBConfig.class}, loader = SpringBootContextLoader.class)
public class RabbitMQProducerTest extends AbstractTransactionalTestNGSpringContextTests {

    @Resource
    private RabbitMQProducer rabbitMQProducer;

    @Test
    public void testSendMessage() throws Exception {
        rabbitMQProducer.sendMessage();
    }

}