package com.ohohoho.noob.module.common.service;

import com.ohohoho.noob.mq.producer.RabbitMQProducer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:20
 */
@SpringBootTest
public class RabbitMQProducerTest extends AbstractTransactionalTestNGSpringContextTests {

    @Resource
    private RabbitMQProducer rabbitMQProducer;

    @Test
    public void testSendMessage() throws Exception {
        rabbitMQProducer.sendMessage();
    }

}