package com.base.drest.service.mq;

import com.alibaba.fastjson.JSON;
import com.base.drest.service.mq.cont.MqConstant;
import com.base.drest.service.mq.cont.MsgSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
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

    @Override
    public void sendMsg(String exchangeName,String routingKey, Object message,final MsgSetting msgSetting) {
        logger.info("sendMsg-->exchangeName={},routingKey={},message={},msgSetting={}", exchangeName,routingKey,JSON.toJSONString(message),JSON.toJSONString(msgSetting));
        if(msgSetting == null){
            amqpTemplate.convertAndSend(exchangeName,routingKey, message);
            return;
        }

        MessagePostProcessor processor = new MessagePostProcessor(){
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                if(msgSetting!=null){
                    MessageProperties messageProperties = message.getMessageProperties();
                    messageProperties.setExpiration(msgSetting.getExpiration() + "");
                }
                return message;
            }
        };
        amqpTemplate.convertAndSend(exchangeName,routingKey, message,processor);
    }

}
