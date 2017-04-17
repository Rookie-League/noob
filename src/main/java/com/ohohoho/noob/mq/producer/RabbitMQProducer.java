package com.ohohoho.noob.mq.producer;

import com.ohohoho.noob.mq.message.JSONMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_ROUTE_KEY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_ROUTE_KEY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:18
 */
@Component
public class RabbitMQProducer {

    @Resource(name = "delayRabbitTemplate")
    private AmqpTemplate delayRabbitTemplate;

    @Resource(name = "jsonRabbitTemplate")
    private AmqpTemplate jsonRabbitTemplate;

    public void sendDelayMessage(String message, Integer delay) {
        delayRabbitTemplate.convertAndSend(NOOB_RABBIT_DELAY_EXCHANGE, NOOB_RABBIT_DELAY_ROUTE_KEY, message, msg -> {
            msg.getMessageProperties().setDelay(delay);
            return msg;
        });
    }

    public void sendJSONMessage(JSONMessage message, Integer delay) {
        jsonRabbitTemplate.convertAndSend(NOOB_RABBIT_JSON_EXCHANGE, NOOB_RABBIT_JSON_ROUTE_KEY, message, msg -> {
            msg.getMessageProperties().setDelay(delay);
            return msg;
        });
    }

}
