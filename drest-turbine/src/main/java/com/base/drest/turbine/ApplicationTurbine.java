package com.base.drest.turbine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationTurbine
 * @author zhouyw
 * @date 2018.04.28
 */
@SpringBootApplication
@EnableTurbine
public class ApplicationTurbine {

    private static Logger logger = LoggerFactory.getLogger(ApplicationTurbine.class);

    public static void main(String[] args)throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationTurbine.class)
                .web(WebApplicationType.SERVLET).run(args);
        logger.info("启动完成！");
        new CountDownLatch(1).await();
    }
}
