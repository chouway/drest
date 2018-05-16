package com.base.drest.service.mq.callback;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * MqConfirmService
 * @author zhouyw
 * @date 2018.05.16
 */
@Component
public class MqReturnCallback implements RabbitTemplate.ReturnCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 证实结果处理
     * 比如 发送一个未申明的直接队列， 服务端会响应如下
     *
     * returnedMessage-->replyCode=312,replyText=NO_ROUTE
     * returnedMessage-->exchange=,routingKey=aaaaaaaaa,message={"body":"rO0ABXNyAB9jb20uYmFzZS5kcmVzdC5kb21haW4uUGFyYW1JbmZvAAAAAAAAAAECAAZMAARjb2RldAASTGphdmEvbGFuZy9TdHJpbmc7TAACaWRxAH4AAUwABG5hbWVxAH4AAUwACHBhcmVudElkcQB+AAFMAAZyZW1hcmtxAH4AAUwABHR5cGVxAH4AAXhwdAAJdGVzdF9jb2RlcHBwcHA=","messageProperties":{"contentLength":0,"contentType":"application/x-java-serialized-object","deliveryTag":0,"finalRetryForMessageWithNoId":false,"headers":{"X-B3-SpanId":"387fd2f6aadb25d0","X-B3-Sampled":"0","X-B3-TraceId":"387fd2f6aadb25d0"},"priority":0,"receivedDeliveryMode":"PERSISTENT"}}
     *
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info("returnedMessage-->replyCode={},replyText={}", replyCode,replyText);
        logger.info("returnedMessage-->exchange={},routingKey={},message={}", exchange,routingKey,JSON.toJSONString(message));
    }
}
