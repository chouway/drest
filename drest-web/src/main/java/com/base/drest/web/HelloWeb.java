package com.base.drest.web;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.pub.IHelloPubInfoService;
import com.base.drest.service.common.IParamInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWeb
 * @author zhouyw
 * @date 2018.04.23
 */
@RestController
@RequestMapping("/hello")
public class HelloWeb {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IHelloPubInfoService helloPubInfoService;

    @RequestMapping("/{msg}")
    @ResponseBody
    public String helloMsg(@PathVariable("msg") String msg){
        logger.info("hello-->msg={}", msg);

        String type = "type";
        String code = "code_0";
        ParamInfo paramInfo = helloPubInfoService.getByTypeCode(type, code);
        logger.info("-->paramInfo={}", JSON.toJSONString(paramInfo));

        return  "hello:" + msg + "; ok";

    }
}
