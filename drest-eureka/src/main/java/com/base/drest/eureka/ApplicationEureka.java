package com.base.drest.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * ApplicationEureka
 * @author zhouyw
 * @date 2018.04.20
 */
@SpringBootApplication
@EnableEurekaServer//   声明一个server：@EnableEurekaServer
public class ApplicationEureka
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApplicationEureka.class, args);
    }
}