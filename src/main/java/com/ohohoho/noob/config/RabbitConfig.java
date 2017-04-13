package com.ohohoho.noob.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:15
 */
@Configuration
@EnableRabbit
@ConditionalOnExpression("#{environment.getProperty('spring.profiles.active').contains('pre') || environment.getProperty('spring.profiles.active').contains('pro')}")
public class RabbitConfig {

    public static final String NOOB_RABBIT_QUEUE = "rabbitmq";

    @Bean
    public Queue rabbitmq() {
        return new Queue(NOOB_RABBIT_QUEUE);
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(System.getenv("rabbitmq.host"));
        connectionFactory.setPort(Integer.valueOf(System.getenv("rabbitmq.port")));
        connectionFactory.setUsername(System.getenv("rabbitmq.username"));
        connectionFactory.setPassword(System.getenv("rabbitmq.password"));
        return connectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMaxConcurrentConsumers(5);
        return factory;
    }

}
