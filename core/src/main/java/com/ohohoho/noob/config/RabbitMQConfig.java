package com.ohohoho.noob.config;

import com.earphone.common.utils.StringExtend;
import com.ohohoho.noob.config.RabbitMQConfig.RabbitMQEnableCondition;
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
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

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
@Conditional(RabbitMQEnableCondition.class)
public class RabbitMQConfig {
    static class RabbitMQEnableCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return StringExtend.isNoneBlank(context.getEnvironment().getProperty("noob.rabbitmq.host"));
        }
    }

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
        connectionFactory.setHost(System.getenv("noob.rabbitmq.host"));
        connectionFactory.setPort(Integer.valueOf(System.getenv("noob.rabbitmq.port")));
        connectionFactory.setUsername(System.getenv("noob.rabbitmq.username"));
        connectionFactory.setPassword(System.getenv("noob.rabbitmq.password"));
        connectionFactory.getRabbitConnectionFactory().setAutomaticRecoveryEnabled(false);
        return connectionFactory;
    }
}