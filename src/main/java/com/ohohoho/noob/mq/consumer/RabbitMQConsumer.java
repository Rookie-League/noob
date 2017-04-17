package com.ohohoho.noob.mq.consumer;

import com.ohohoho.noob.mq.message.JSONMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_QUEUE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_CONTAINER_FACTORY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_QUEUE;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:12
 */
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = NOOB_RABBIT_DELAY_QUEUE)
    public void receiveDelayMessage(@Payload String content) {
        System.out.println(content);
    }

    @RabbitListener(queues = NOOB_RABBIT_JSON_QUEUE, containerFactory = NOOB_RABBIT_JSON_CONTAINER_FACTORY)
    public void receiveJSONMessage(@Payload JSONMessage content) {
        System.out.println(content);
    }

}
