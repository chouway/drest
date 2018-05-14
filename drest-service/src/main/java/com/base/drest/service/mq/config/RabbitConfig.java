package com.base.drest.service.mq.config;

import com.base.drest.service.mq.cont.MqConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitConfig
 * @author zhouyw
 * @date 2018.05.14
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue MQ_TEST_0() {
        return new Queue(MqConstant.MQ_TEST_0);
    }

    @Bean
    public Queue MQ_TEST_1() {
        return new Queue(MqConstant.MQ_TEST_1);
    }
}

