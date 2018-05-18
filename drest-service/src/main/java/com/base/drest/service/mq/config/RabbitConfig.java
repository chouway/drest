package com.base.drest.service.mq.config;

import com.base.drest.service.mq.cont.MqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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

    @Bean
    public Queue directQueueRepeat() {
        return new Queue(MqConstant.QUEUE_DIRECT_REPEAT);
    }

    @Bean
    public Queue directQueueRepeatDead() {
        Map<String,Object> arguments = new HashMap<String, Object>();
        arguments.put("x-dead-letter-exchange", MqConstant.EXCHANGE_DERICT_REPEAT);
        arguments.put("x-dead-letter-routing-key", MqConstant.QUEUE_DIRECT_REPEAT);
        return new Queue(MqConstant.QUEUE_DIRECT_REPEAT_DEAD,true,false,false,arguments);
    }

    @Bean
    public DirectExchange directExchangeRepeat() {
        return new DirectExchange(MqConstant.EXCHANGE_DERICT_REPEAT);
    }

    @Bean
    public Binding binding_directQueueRepeat_directExchangeDelay(Queue directQueueRepeat, DirectExchange directExchangeRepeat) {
        return BindingBuilder.bind(directQueueRepeat).to(directExchangeRepeat).with(directQueueRepeat.getName());
    }
    @Bean
    public Binding binding_directQueueRepeatDead_directExchangeDelay(Queue directQueueRepeatDead, DirectExchange directExchangeRepeat) {
        return BindingBuilder.bind(directQueueRepeatDead).to(directExchangeRepeat).with(directQueueRepeatDead.getName());
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
    public Binding binding_topicQueue_topicExchange(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(MqConstant.ROUTING_TOPIC_KEY);
    }


    @Bean
    public Binding binding_topicQueueApp_topicExchange(Queue topicQueueApp, TopicExchange topicExchange) {
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
    public Binding binding_fanoutQueue_fanoutExchange(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding binding_fanoutQueueApp_fanoutExchange(Queue fanoutQueueApp, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueApp).to(fanoutExchange);
    }
    /*FANOUT 模式 END*/



}

