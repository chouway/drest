package com.base.drest.service;

import com.alibaba.fastjson.JSON;
import com.base.drest.CommonTest;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.ICacheService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * CacheServiceTest
 * @author zhouyw
 * @date 2018.05.19
 */
public class CacheServiceTest extends CommonTest{

    @Autowired
    private ICacheService cacheService;

    @Test
    public void cache() throws Exception {
        String key = "aaaa";
        String value = "bbbb";
        cacheService.cache(key,value);
    }


    @Test
    public void cacheObj() throws Exception {
        String key = "aaaa";
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setId("key中");
        cacheService.cache(key,paramInfo);
    }


    @Test
    public void get() throws Exception {
        String key = "aaaa";
        String value = cacheService.get(key, String.class);
        logger.info("-->value={}", value);
    }

    @Test
    public void getExpire() throws Exception {
        String key = "aaaa";
        long expire = cacheService.getExpire(key);
        logger.info("-->expire={}", expire);
    }

    @Test
    public void remove() throws Exception {
        String key = "aaaa";
        ParamInfo value = cacheService.get(key,ParamInfo.class);
        logger.info("-->value={}", JSON.toJSONString(value));

        Boolean remove = cacheService.remove(key);
        logger.info("-->remove={}", remove);

        value = cacheService.get(key,ParamInfo.class);
        logger.info("-->value={}", value);
    }

    @Test
    public void list() throws Exception {
        String key = "list";
        List<ParamInfo> list  = new ArrayList<ParamInfo>();
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setId("key中");
        list.add(paramInfo);
        cacheService.cache(key,list);

        List<ParamInfo> listGet = cacheService.get(key, List.class);
        logger.info("-->listGet={}", JSON.toJSONString(listGet));

        Boolean remove = cacheService.remove(key);
        logger.info("-->remove={}", remove);

    }
}