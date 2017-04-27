package com.ohohoho.noob.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.CacheMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_CONTAINER_FACTORY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:15
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    //This component is declaration for producer
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        //Message formatter
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    //This component is declaration for consumer
    @Bean(name = NOOB_RABBIT_DEMO_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //Message parser
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setCacheMode(CacheMode.CONNECTION);
        connectionFactory.setHost(System.getenv("noob.rabbitmq.host"));
        connectionFactory.setPort(Integer.valueOf(System.getenv("noob.rabbitmq.port")));
        connectionFactory.setUsername(System.getenv("noob.rabbitmq.username"));
        connectionFactory.setPassword(System.getenv("noob.rabbitmq.password"));
        connectionFactory.getRabbitConnectionFactory().setAutomaticRecoveryEnabled(false);
        return connectionFactory;
    }

}
