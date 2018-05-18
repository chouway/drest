package com.base.drest.service.mq;

import com.alibaba.fastjson.JSON;
import com.base.drest.service.mq.callback.MqConfirmCallback;
import com.base.drest.service.mq.callback.MqReturnCallback;
import com.base.drest.service.mq.cont.MsgSetting;
import com.base.framework.core.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * RabbitSendMqService
 * @author zhouyw
 * @date 2018.05.16
 */
@Component
public class RabbitSendMqService implements IRabbitSendMqService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private RabbitTemplate rabbitTemplat;

    @Autowired
    private MqConfirmCallback mqConfirmCallback;

    @Autowired
    private MqReturnCallback mqReturnCallback;

    @PostConstruct
    private void init(){
        //发送确认模式-可靠消息发送      可处理成微服务接收待发送消息入库（持久化），准实时发送消息,确保消息被送达消息队列服务器；
        rabbitTemplat.setConfirmCallback(mqConfirmCallback);
        //处理确认模式-可靠消息处理
        rabbitTemplat.setReturnCallback(mqReturnCallback);
    }

    @Override
    public String sendDirect(String routingKey, Object message) {
        String msgId = UUIDUtils.generate();
        logger.info("rabbit sendDirect-->msgId={},routingKey={},message={}", msgId,routingKey, JSON.toJSONString(message));
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplat.convertAndSend(routingKey,message,correlationData);
        return msgId;
    }

    @Override
    public String sendTopic(String exchange, String routingKey, Object message) {
        String msgId = UUIDUtils.generate();
        logger.info("rabbit sendTopic-->msgId={},exchange={},routingKey={},message={}", msgId,exchange,routingKey,JSON.toJSONString(message));
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplat.convertAndSend(exchange,routingKey,message,correlationData);
        return msgId;
    }

    @Override
    public String sendFanout(String exchange, Object message) {
        String msgId = UUIDUtils.generate();
        logger.info("rabbit sendFanout-->msgId={},exchange={},message={}", msgId, exchange, JSON.toJSONString(message));
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplat.convertAndSend(exchange,message,correlationData);
        return msgId;
    }

    @Override
    public String sendMsg(String exchange, String routingKey, Object message, MsgSetting msgSetting) {
        String msgId = UUIDUtils.generate();
        logger.info("sendMsg-->msgId={},exchange={},routingKey={},message={},msgSetting={}", msgId,exchange,routingKey,JSON.toJSONString(message),JSON.toJSONString(msgSetting));
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplat.convertAndSend(exchange,message,correlationData);
        if(msgSetting == null){
            rabbitTemplat.convertAndSend(exchange,routingKey, message);
            return msgId;
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
        rabbitTemplat.convertAndSend(exchange,routingKey, message,processor);
        return msgId;
    }
}
