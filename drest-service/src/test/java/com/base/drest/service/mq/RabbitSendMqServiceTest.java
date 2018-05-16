package com.base.drest.service.mq;

import com.base.drest.CommonTest;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * RabbitSendMqServiceTest
 * @author zhouyw
 * @date 2018.05.16
 */
public class RabbitSendMqServiceTest extends CommonTest {

    @Autowired
    private IRabbitSendMqService rabbitSendMqService;

    @Test
    public void sendDirect() throws InterruptedException {
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("test_code");
        rabbitSendMqService.sendDirect(MqConstant.QUEUE_DIRECT_B,paramInfo);
        logger.info("sleep-->start");
        Thread.sleep(10*1000l);
        logger.info("sleep-->end");
    }

    @Test
    public void sendTopic() {
    }

    @Test
    public void sendFanout() {
    }
}