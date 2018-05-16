package com.base.drest.service.mq;

import com.base.drest.CommonTest;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * MqServiceTest
 * @author zhouyw
 * @date 2018.05.14
 */
public class SendMqServiceTest extends CommonTest{

    @Autowired
    private ISendMqService sendMqService;

    @Test
    public void sendDirect() throws InterruptedException {
//      mqService.sendDirect(MqConstant.QUEUE_DIRECT_A,"test_0");
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("test_code");
        sendMqService.sendDirect(MqConstant.QUEUE_DIRECT_B,paramInfo);
        logger.info("sleep-->start");
        Thread.sleep(10*1000l);
        logger.info("sleep-->end");
    }

    @Test
    public void sendTopic() throws InterruptedException {
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("test_code_0");
        sendMqService.sendTopic(MqConstant.EXCHANGE_TOPIC,MqConstant.QUEUE_TOPIC + ".a",paramInfo);
        logger.info("sleep-->start");
        Thread.sleep(10*1000l);
        logger.info("sleep-->end");
    }


    @Test
    public void sendFanout() throws InterruptedException {
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("test_code_fanout");
        sendMqService.sendTopic(MqConstant.EXCHANGE_FANOUT,null,paramInfo);
        logger.info("sleep-->start");
        Thread.sleep(10*1000l);
        logger.info("sleep-->end");
    }
}