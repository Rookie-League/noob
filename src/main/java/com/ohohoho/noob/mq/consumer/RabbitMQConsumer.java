package com.ohohoho.noob.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.ohohoho.noob.config.RabbitMQConfig.NOOB_RABBIT_QUEUE;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:12
 */
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = NOOB_RABBIT_QUEUE, containerFactory = "rabbitFactory")
    public void test(@Payload String content) {
        System.out.println(content);
    }

}
