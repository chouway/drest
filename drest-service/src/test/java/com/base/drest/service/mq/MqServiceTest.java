package com.base.drest.service.mq;

import com.base.drest.CommonTest;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.mq.cont.MqConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * MqServiceTest
 * @author zhouyw
 * @date 2018.05.14
 */
public class MqServiceTest extends CommonTest{

    @Autowired
    private IMqService mqService;

    @Test
    public void send() throws InterruptedException {
//        mqService.send(MqConstant.MQ_TEST_0,"test_0");
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("test_code");
        mqService.send(MqConstant.MQ_TEST_1,paramInfo);
        logger.info("sleep-->start");
        Thread.sleep(10*1000l);
        logger.info("sleep-->end");
    }
}