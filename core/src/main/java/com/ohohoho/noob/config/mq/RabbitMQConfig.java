package com.ohohoho.noob.config.mq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.CacheMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.HOST;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.PASSWORD;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.PORT;
import static com.ohohoho.noob.config.mq.RabbitMQEnvironment.USERNAME;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_CONTAINER_FACTORY;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_EXCHANGE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_QUEUE;
import static com.ohohoho.noob.constant.PublicConstant.NOOB_RABBIT_DEMO_ROUTE_KEY;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:15
 */
@Configuration
@EnableRabbit
@Conditional(RabbitMQConfigurationCondition.class)
public class RabbitMQConfig {
    @Bean
    public AmqpAdmin amqpAdmin() {
        AmqpAdmin amqpAdmin = new RabbitAdmin(rabbitConnectionFactory());
        amqpAdmin.declareQueue(rabbitDemoQueue());
        amqpAdmin.declareExchange(rabbitDemoExchange());
        amqpAdmin.declareBinding(rabbitDemoBinding());
        return amqpAdmin;
    }

    @Bean
    public Queue rabbitDemoQueue() {
        return new Queue(NOOB_RABBIT_DEMO_QUEUE);
    }

    @Bean
    public DirectExchange rabbitDemoExchange() {
        DirectExchange exchange = new DirectExchange(NOOB_RABBIT_DEMO_EXCHANGE);
        exchange.setDelayed(true);
        return exchange;
    }

    @Bean
    public Binding rabbitDemoBinding() {
        return BindingBuilder.bind(rabbitDemoQueue()).to(rabbitDemoExchange()).with(NOOB_RABBIT_DEMO_ROUTE_KEY);
    }

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
        connectionFactory.setHost(HOST.getValue());
        connectionFactory.setPort(Integer.parseInt(PORT.getValue()));
        connectionFactory.setUsername(USERNAME.getValue());
        connectionFactory.setPassword(PASSWORD.getValue());
        connectionFactory.getRabbitConnectionFactory().setAutomaticRecoveryEnabled(false);
        return connectionFactory;
    }
}
