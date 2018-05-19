package com.base.drest.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * ConstantService
 * @author zhouyw
 * @date 2018.05.19
 */
@Service
public class ConstantService implements IConstantService {

    private Logger logger = LoggerFactory.getLogger(ConstantService.class);


    private Map<String,String> map = new HashMap<String, String>();

    private final String KEY = "#key";

    @Override
    @Cacheable(value = "content",key = KEY)
    public String get(String key) {
        String value = map.get(key);
        logger.info("get-->key={},value={}", key, value);
        return value;
    }

    @Override
    @CachePut(cacheNames = "content",key = KEY)
    public String add(String key, String value) {
        map.put(key,value);
        logger.info("add-->key={},value={}", key, value);
        return value;
    }

    @Override
    @CachePut(cacheNames = "content",key = KEY)
    public String edit(String key, String value) {
        if(map.containsKey(key)){
            logger.info("edit-->key={},value={}", key, value);
            map.put(key,value);
            return value;

        }
        return null;
    }

    @Override
    @CacheEvict(cacheNames = "content",key = KEY)
    public void remove(String key) {
        if(map.containsKey(key)){
            String value =  map.remove(key);
            logger.info("remove-->key={},value={}", key, value);
            return;

        }
    }
}
