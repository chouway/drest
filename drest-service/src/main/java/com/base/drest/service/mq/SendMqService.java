package com.base.drest.service.mq;

import com.alibaba.fastjson.JSON;
import com.base.drest.service.mq.cont.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MqService
 * @author zhouyw
 * @date 2018.05.14
 */
@Service
public class SendMqService implements ISendMqService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendDirect(String routingKey, Object message) {
        logger.info("sendDirect-->routingKey={},message={}", routingKey,JSON.toJSONString(message));
        amqpTemplate.convertAndSend(routingKey, message);
    }

    @Override
    public void sendTopic(String exchange, String routingKey, Object message) {
        logger.info("sendTopic-->exchange={},routingKey={},message={}",exchange, routingKey,JSON.toJSONString(message));
        amqpTemplate.convertAndSend(exchange,routingKey, message);
    }

    @Override
    public void sendFanout(String exchange, Object message) {
        logger.info("sendFanout-->exchange={},message={}",exchange,JSON.toJSONString(message));
        amqpTemplate.convertAndSend(exchange, message);
    }


}
