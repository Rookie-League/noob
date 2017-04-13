package com.ohohoho.noob.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:18
 */
@Component
public class RabbitMQProducer {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sendMessage() {
        rabbitTemplate.convertAndSend("rabbitmq", "RabbitMQ");
    }

}
