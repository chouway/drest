package com.base.drest.web;

import com.alibaba.fastjson.JSON;
import com.base.drest.domain.ParamInfo;
import com.base.drest.pub.IHelloAPI;
import com.base.drest.pub.IParamAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HelloWeb
 * @author zhouyw
 * @date 2018.04.23
 */
@RestController
@RequestMapping("/param")
public class ParamWeb {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IParamAPI paramAPI;

    @RequestMapping("/getByType")
    @ResponseBody//web默认就是application:json;     而feign 集成后 默认是application:xml;    按需求更改。 这个不影响
    public List<ParamInfo> getByType(String type){
        logger.info("getByType-->type={}", type);
        List<ParamInfo> paramInfos = paramAPI.getByType(type);
        logger.info("-->paramInfos={}", JSON.toJSONString(paramInfos));
        return  paramInfos;

    }


}
