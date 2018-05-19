package com.base.drest.service.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * CacheService
 * @author zhouyw
 * @date 2018.05.19
 */
@Service
public class CacheService implements ICacheService {

    private Logger logger = LoggerFactory.getLogger(CacheService.class);


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${app.param.redis.timeout}")
    private long timeout;

    @Override
    public void cache(String key, Object msg) {
        this.cache(key,msg,timeout);
    }

    @Override
    public void cache(String key, Object msg, long timeout) {
        if(msg == null){
            return;
        }
        logger.info("cache-->key={},msg={}", key, JSON.toJSONString(msg));
        if(msg instanceof String){
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(key,(String)msg,timeout, TimeUnit.SECONDS);
        }else{
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,msg,timeout, TimeUnit.SECONDS);
        }
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if(clazz == String.class){
            return (T)stringRedisTemplate.opsForValue().get(key);
        }else{
            return (T)redisTemplate.opsForValue().get(key);
        }
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public Boolean remove(String key) {
        return redisTemplate.delete(key);
    }


}
