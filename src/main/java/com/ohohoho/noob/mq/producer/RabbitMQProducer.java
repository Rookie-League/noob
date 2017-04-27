package com.ohohoho.noob.mq.producer;

import com.ohohoho.noob.mq.message.JSONMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_ROUTE_KEY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:18
 */
@Component
public class RabbitMQProducer {

    @Resource(name = "rabbitTemplate")
    private AmqpTemplate rabbitTemplate;

    public void sendDelayMessage(JSONMessage message, Integer delay) {
        rabbitTemplate.convertAndSend(NOOB_RABBIT_DEMO_EXCHANGE, NOOB_RABBIT_DEMO_ROUTE_KEY, message, msg -> {
            msg.getMessageProperties().setDelay(delay);
            return msg;
        });
    }

}
