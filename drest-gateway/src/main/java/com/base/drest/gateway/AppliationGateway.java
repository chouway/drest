package com.base.drest.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * AppliationGateway
 * @author zhouyw
 * @date 2018.05.02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppliationGateway {

    public static void main(String[] args) {
        SpringApplication.run(AppliationGateway.class, args);
    }

}
