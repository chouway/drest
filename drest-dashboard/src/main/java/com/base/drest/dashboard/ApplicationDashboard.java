package com.base.drest.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationDashboard
 * @author zhouyw
 * @date 2018.04.28
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ApplicationDashboard {

    private static Logger logger = LoggerFactory.getLogger(ApplicationDashboard.class);

    public static void main(String[] args)throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationDashboard.class)
                .web(WebApplicationType.SERVLET).run(args);
        logger.info("启动完成！");
        new CountDownLatch(1).await();
    }
}
