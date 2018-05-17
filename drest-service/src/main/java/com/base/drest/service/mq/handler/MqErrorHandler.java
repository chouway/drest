package com.base.drest.service.mq.handler;

import com.alibaba.fastjson.JSON;
import com.base.framework.common.bo.ResultBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

/**
 * MqErrorHandler
 * @author zhouyw
 * @date 2018.05.17
 */
@Component
public class MqErrorHandler implements RabbitListenerErrorHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        logger.info("listen handle error-->amqpMessage={},message={}", JSON.toJSONString(amqpMessage),JSON.toJSONString(message));
        logger.error("excution fail-->exception={}", JSON.toJSONString(exception));
        /*ResultBO resultBO = new ResultBO();
        resultBO.setCode("listen_error");
        return resultBO;*/
        return null;
    }
}
