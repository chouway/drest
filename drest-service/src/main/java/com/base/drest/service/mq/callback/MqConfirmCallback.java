package com.base.drest.service.mq.callback;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * MqConfirmService
 * @author zhouyw
 * @date 2018.05.16
 */
@Component
public class MqConfirmCallback implements RabbitTemplate.ConfirmCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @param correlationData 消息关联id
     * @param ack  确认是否送达消息服务器
     * @param cause 原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("confirm-->correlationData={},ack={},cause={}", JSON.toJSONString(correlationData),ack,cause);
    }
}
