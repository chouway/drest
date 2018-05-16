package com.base.drest.service.mq.config;

import com.base.drest.service.mq.cont.MqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitConfig
 * @author zhouyw
 * @date 2018.05.14
 */
@Configuration
public class RabbitConfig {
    /*DIRECT 模式 STR*/
    @Bean
    public Queue directQueueA() {
        return new Queue(MqConstant.QUEUE_DIRECT_A);
    }

    @Bean
    public Queue directQueueB() {
        return new Queue(MqConstant.QUEUE_DIRECT_B);
    }
    /*DIRECT 模式 END*/

    /*TOPIC 模式 STR*/
    @Bean
    public Queue topicQueue() {
        return new Queue(MqConstant.QUEUE_TOPIC);
    }

    @Bean
    public Queue topicQueueApp() {
        return new Queue(MqConstant.QUEUE_TOPIC_APP);
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MqConstant.EXCHANGE_TOPIC);
    }

    @Bean
    public Binding bindingTopicExchangeMessage(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(MqConstant.ROUTING_TOPIC_KEY);
    }


    @Bean
    public Binding bindingTopicExchangeMessage2(Queue topicQueueApp, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueApp).to(topicExchange).with(MqConstant.ROUTING_TOPIC_KEY);
    }
    /*TOPIC 模式 END*/

    /*FANOUT 模式 STR*/
    @Bean
    public Queue fanoutQueue() {
        return new Queue(MqConstant.QUEUE_FANOUT);
    }
    @Bean
    public Queue fanoutQueueApp() {
        return new Queue(MqConstant.QUEUE_FANOUT_APP);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(MqConstant.EXCHANGE_FANOUT);
    }

    @Bean
    public Binding bindingFanoutExchangeMessage(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchangeMessage2(Queue fanoutQueueApp, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueApp).to(fanoutExchange);
    }
    /*FANOUT 模式 END*/



}

