package com.base.drest.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ApplicationOauth
 * @author zhouyw
 * @date 2018.05.20
 */
@SpringBootApplication
public class ApplicationOauth extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOauth.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }
}
