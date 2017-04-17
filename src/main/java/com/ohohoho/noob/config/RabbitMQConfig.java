package com.ohohoho.noob.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_QUEUE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DELAY_ROUTE_KEY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_CONTAINER_FACTORY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_QUEUE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_JSON_ROUTE_KEY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:15
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public Queue rabbitDelayQueue() {
        return new Queue(NOOB_RABBIT_DELAY_QUEUE);
    }

    @Bean
    public DirectExchange rabbitDelayExchange() {
        DirectExchange exchange = new DirectExchange(NOOB_RABBIT_DELAY_EXCHANGE);
        exchange.setDelayed(true);
        return exchange;
    }

    @Bean
    public Binding delayRabbitBinding() {
        return BindingBuilder.bind(rabbitDelayQueue()).to(rabbitDelayExchange()).with(NOOB_RABBIT_DELAY_ROUTE_KEY);
    }

    @Bean
    public RabbitTemplate delayRabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue rabbitJSONQueue() {
        return new Queue(NOOB_RABBIT_JSON_QUEUE);
    }

    @Bean
    public DirectExchange rabbitJSONExchange() {
        DirectExchange exchange = new DirectExchange(NOOB_RABBIT_JSON_EXCHANGE);
        exchange.setDelayed(true);
        return exchange;
    }

    @Bean
    public Binding jsonRabbitBinding() {
        return BindingBuilder.bind(rabbitJSONQueue()).to(rabbitJSONExchange()).with(NOOB_RABBIT_JSON_ROUTE_KEY);
    }

    @Bean
    public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean(name = NOOB_RABBIT_JSON_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(System.getenv("noob.rabbitmq.host"));
        connectionFactory.setPort(Integer.valueOf(System.getenv("noob.rabbitmq.port")));
        connectionFactory.setUsername(System.getenv("noob.rabbitmq.username"));
        connectionFactory.setPassword(System.getenv("noob.rabbitmq.password"));
        return connectionFactory;
    }

}
