package com.ohohoho.noob.config.mq;

import lombok.Getter;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/4
 * @createTime 9:03
 */
public enum RabbitMQEnvironment {
    HOST("noob.rabbitmq.host"),
    PORT("noob.rabbitmq.port"),
    USERNAME("noob.rabbitmq.username"),
    PASSWORD("noob.rabbitmq.password");
    @Getter
    private String value;

    RabbitMQEnvironment(String key) {
        this.value = System.getenv(key);
    }
}
