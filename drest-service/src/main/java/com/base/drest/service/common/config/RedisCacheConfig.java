package com.base.drest.service.common.config;

import org.aspectj.weaver.ast.Var;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * RedisCacheConfig
 * @author zhouyw
 * @date 2018.05.19
 */
@Configuration
@EnableAutoConfiguration
@EnableCaching //加上这个注解是的支持缓存注解
public class RedisCacheConfig extends CachingConfigurerSupport{

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory);
        return redisCacheManager;
    }


}
