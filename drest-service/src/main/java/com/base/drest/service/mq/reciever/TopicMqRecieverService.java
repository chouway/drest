package com.base.drest.service.mq.reciever;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
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
//  @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = MqConstant.TOPIC_MQ_TEST_0), exchange = @Exchange(value = "test.topic",type = ExchangeTypes.TOPIC),key = MqConstant.TOPIC_MQ_TEST_0)})
    @RabbitListener(queues = MqConstant.TOPIC_QUEUE)
    public void process0(@Payload ParamInfo paramInfo) {
        logger.info("topic.queue:0-->paramInfo={}", JSON.toJSONString(paramInfo));

    }
}
