package com.base.drest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationService
 * @author zhouyw
 * @date 2018.04.18
 */
@SpringBootApplication(scanBasePackages = {"com.base.drest"})
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    public static void main(String[] args)throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationService.class)
                .web(WebApplicationType.SERVLET).run(args);
        logger.info("启动完成！");
        new CountDownLatch(1).await();
    }
}
