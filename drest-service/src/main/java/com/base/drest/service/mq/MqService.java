package com.base.drest.service.mq;

import com.alibaba.fastjson.JSON;
import com.base.drest.service.mq.IMqService;
import com.base.drest.service.mq.cont.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MqService
 * @author zhouyw
 * @date 2018.05.14
 */
@Service
public class MqService implements IMqService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void send(String key, Object content) {
        logger.info("send-->key={},content={}", key,JSON.toJSONString(content));
        amqpTemplate.convertAndSend(key, content);
    }

    @Override
    public void sendTopic(String key, Object content) {
        logger.info("sendTopic-->key={},content={}", key,JSON.toJSONString(content));
        amqpTemplate.convertAndSend(MqConstant.topicExchange,key, content);
    }


}
