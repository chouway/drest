package com.base.drest.service.mq;

/**
 * IRabbitSendMqService
 * @author zhouyw
 * @date 2018.05.14
 */
public interface IRabbitSendMqService {

    String sendDirect(String routingKey, Object message);

    String sendTopic(String exchange, String routingKey, Object message);

    String sendFanout(String exchange, Object message);
}
