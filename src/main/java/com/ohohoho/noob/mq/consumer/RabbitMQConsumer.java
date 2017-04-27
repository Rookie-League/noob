package com.ohohoho.noob.mq.consumer;

import com.ohohoho.noob.mq.message.JSONMessage;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_QUEUE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_ROUTE_KEY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_CONTAINER_FACTORY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:12
 */
@Component
public class RabbitMQConsumer {

    @RabbitListener(containerFactory = NOOB_RABBIT_DEMO_CONTAINER_FACTORY,
            bindings = @QueueBinding(
                    value = @Queue(
                            value = NOOB_RABBIT_DEMO_QUEUE,
                            durable = "true"),
                    exchange = @Exchange(
                            value = NOOB_RABBIT_DEMO_EXCHANGE,
                            ignoreDeclarationExceptions = "true",
                            delayed = "true"),
                    key = NOOB_RABBIT_DEMO_ROUTE_KEY)
    )
    public void receiveDelayMessage(@Payload JSONMessage content) {
        System.out.println(content);
    }

}
