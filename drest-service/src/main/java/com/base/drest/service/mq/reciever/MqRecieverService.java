package com.base.drest.service.mq.reciever;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * MqRecieverService
 * @author zhouyw
 * @date 2018.05.14
 */
@Component
public class MqRecieverService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = MqConstant.MQ_TEST_0)
    public void process0(String mqMsg) {
        logger.info("MQ_TEST_0-->mqMsg={}", mqMsg);

    }


    @RabbitHandler
    @RabbitListener(queues = MqConstant.MQ_TEST_1)
    public void process1(@Payload ParamInfo paramInfo) {
        logger.info("MQ_TEST_1-->paramInfo={}", JSON.toJSONString(paramInfo));

    }
}
