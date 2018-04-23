package com.base.drest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationWeb
 * @author zhouyw
 * @date 2018.04.23
 */
@SpringBootApplication(scanBasePackages = {"com.base.drest"})
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationWeb {
    private static Logger logger = LoggerFactory.getLogger(ApplicationWeb.class);

    public static void main(String[] args)throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationWeb.class)
                .web(WebApplicationType.SERVLET).run(args);
        logger.info("启动完成！");
        new CountDownLatch(1).await();
    }
}
