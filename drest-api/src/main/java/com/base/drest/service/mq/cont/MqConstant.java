package com.base.drest.service.mq.cont;

/**
 * MqConstant
 * @author zhouyw
 * @date 2018.05.14
 */
public interface MqConstant {
    /*DIRECT 模式STR*/
    String QUEUE_DIRECT_A = "direct.queue.a";

    String QUEUE_DIRECT_B = "direct.queue.b";
    /*DIRECT 模式END*/

    /*TOPIC 模式STR*/
    //路由关键字
    String ROUTING_TOPIC_KEY = "topic.queue.#";
    //topic的交易机
    String EXCHANGE_TOPIC = "topicExchange";

    String QUEUE_TOPIC = "topic.queue";

    //模拟其它应用也订阅了该主题
    String QUEUE_TOPIC_APP = "topic.queue.app";
    /*TOPIC 模式END*/

    /*FANOUT 模式STR*/

    //fanout A的交易机  广播

    String QUEUE_FANOUT = "fanout.queue";

    String QUEUE_FANOUT_APP = "fanout.queue.app";

    String EXCHANGE_FANOUT = "fanoutExchange";
    /*FANOUT 模式END*/
}
