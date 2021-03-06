package com.base.drest.service.mq.reciever;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * MqRecieverService
 * @author zhouyw
 * @date 2018.05.14
 */
@Component
public class TopicMqRecieverService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = MqConstant.QUEUE_TOPIC)
    public void receive(@Payload ParamInfo paramInfo) {
        logger.info("{}-->paramInfo={}",MqConstant.QUEUE_TOPIC, JSON.toJSONString(paramInfo));

    }

    @RabbitHandler
    @RabbitListener(queues = MqConstant.QUEUE_TOPIC_APP)
    public void receiveApp(@Payload ParamInfo paramInfo) {
        logger.info("{}-->paramInfo={}",MqConstant.QUEUE_TOPIC_APP, JSON.toJSONString(paramInfo));

    }
}
