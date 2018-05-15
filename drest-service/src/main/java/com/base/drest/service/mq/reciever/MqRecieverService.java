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
    @RabbitListener(queues = MqConstant.DIRECT_QUEUE_A)
    public void process0(String mqMsg) {
        logger.info("DIRECT_QUEUE_0-->mqMsg={}", mqMsg);

    }


    @RabbitHandler
    @RabbitListener(queues = MqConstant.DIRECT_QUEUE_B)
    public void process1(ParamInfo paramInfo) {
        /*if(true){//消费端出错，消息队列会重新推送，这导致10秒内一直重复。
            throw new RuntimeException("测试处理失败");
        }*/
        logger.info("DIRECT_QUEUE_1-->paramInfo={}", JSON.toJSONString(paramInfo));
    }
}