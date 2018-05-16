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
 * FanoutMqRecieverService
 * @author zhouyw
 * @date 2018.05.16
 */
@Component
public class FanoutMqRecieverService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = MqConstant.QUEUE_FANOUT)
    public void receive(@Payload ParamInfo paramInfo) {
        logger.info("{}-->paramInfo={}",MqConstant.QUEUE_FANOUT, JSON.toJSONString(paramInfo));
    }

    @RabbitHandler
    @RabbitListener(queues = MqConstant.QUEUE_FANOUT_APP)
    public void receiveApp(@Payload ParamInfo paramInfo) {
        logger.info("{}-->paramInfo={}",MqConstant.QUEUE_FANOUT_APP, JSON.toJSONString(paramInfo));
    }
}
