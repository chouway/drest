package com.base.drest.service.common;

import com.base.drest.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * ConstantServiceTest
 * @author zhouyw
 * @date 2018.05.19
 */
public class ConstantServiceTest extends CommonTest{

    @Autowired
    private IConstantService constantService;

    private String key = "abc";

    @Test
    public void get() throws Exception {
        String value = constantService.get(key);
        logger.info("-->value={}", value);

        String value2 = constantService.get(key);
        logger.info("-->value2={}", value2);
    }

    @Test
    public void add() throws Exception {
        String value = constantService.add(key, "666");
        logger.info("-->value={}", value);

        this.get();
    }

    @Test
    public void edit() throws Exception {
        String value = constantService.edit(key, "777");
        logger.info("-->value={}", value);
    }

    @Test
    public void remove() throws Exception {
        constantService.remove(key);
    }

}