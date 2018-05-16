package com.base.drest.service.mq;

/**
 * IMqService
 * @author zhouyw
 * @date 2018.05.14
 */
public interface ISendMqService {

    void sendDirect(String routingKey, Object message);

    void sendTopic(String exchange, String routingKey, Object message);

    void sendFanout(String exchange, Object message);
}
