package com.base.drest.service.mq.config;

import com.base.drest.service.mq.cont.MqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * RabbitConfig
 * @author zhouyw
 * @date 2018.05.14
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue directQueueA() {
        return new Queue(MqConstant.DIRECT_QUEUE_A);
    }

    @Bean
    public Queue directQueueB() {
        return new Queue(MqConstant.DIRECT_QUEUE_B);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(MqConstant.TOPIC_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MqConstant.topicExchange);
    }

    //对列绑定并关联到ROUTINGKEY
    @Bean
    public Binding bindingExchangeMessage(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(MqConstant.TOPIC_QUEUE + ".*");
    }

}

