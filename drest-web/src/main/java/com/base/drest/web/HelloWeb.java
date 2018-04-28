package com.base.drest.web;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.pub.IHelloAPI;
import com.base.framework.common.bo.ResultBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private IHelloAPI helloAPI;

    @RequestMapping("/msg/{msg}")
    @ResponseBody
    public String helloMsg(@PathVariable("msg") String msg){
        logger.info("hello-->msg={}", msg);

        String type = "type";
        String code = "code_0";
        ParamInfo paramInfo = helloAPI.getByTypeCode(type, code);
        logger.info("-->paramInfo={}", JSON.toJSONString(paramInfo));

        return  "hello:" + msg + "; ok";

    }

    @RequestMapping("/msg2/{msg}")
    @ResponseBody
    public String helloMsg2(@PathVariable("msg") String msg){
        logger.info("hello2-->msg={}", msg);
        ParamInfo paramInfo = helloAPI.getByTypeCodeTestFB();
        logger.info("-->paramInfo={}", JSON.toJSONString(paramInfo));
        return  "hello2:" + msg + "; ok";

    }

    /**
     * nginx 当某个请求可能出现大并发的请求 ，导致服务繁忙异常。 加上服务繁忙验证码处理 规避机器刷屏
     * @param msg
     * @param isErr
     * @return
     */
    @RequestMapping("/msg3/{msg}")
    @ResponseBody
    public ResultBO helloMsg3(@PathVariable("msg") String msg,boolean isErr){
        logger.info("hello2-->msg={}", msg);
        ResultBO resultBO = helloAPI.getByTypeCodeDef(isErr);
        logger.info("-->resultBO={}", JSON.toJSONString(resultBO));
        return  resultBO;
    }
}
