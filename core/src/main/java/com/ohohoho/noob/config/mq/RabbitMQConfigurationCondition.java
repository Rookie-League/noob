package com.ohohoho.noob.config.mq;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.HOST;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.PASSWORD;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.PORT;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.USERNAME;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/4
 * @createTime 8:56
 */
class RabbitMQConfigurationCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return isNotBlank(HOST.getValue()) && isNotBlank(PORT.getValue()) && isNotBlank(USERNAME.getValue()) && isNotBlank(PASSWORD.getValue());
    }
}