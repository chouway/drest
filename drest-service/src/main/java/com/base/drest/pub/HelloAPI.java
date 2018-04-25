package com.base.drest.pub;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.IParamInfoService;
import com.base.framework.common.exception.BusinessException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloAPI
 * @author zhouyw
 * @date 2018.04.23
 */
@RestController
public class HelloAPI implements IHelloAPI {

    private static Logger logger = LoggerFactory.getLogger(HelloAPI.class);


    @Autowired
    private IParamInfoService paramInfoService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${app.param.test.isTestFallBack}")
    private boolean isTestFB;

    @Override
    @HystrixCommand(fallbackMethod = "getByTypeCodeFallback")
    public ParamInfo getByTypeCode(String type, String code) throws BusinessException {
        logger.info("-->serverPort={}", serverPort);
        if(isTestFB){
            String msg = "暂时失败下，测试fallback";
            logger.error("error:-->msg={}", msg);
            throw new BusinessException(msg);
        }
        return paramInfoService.getByTypeCode(type, code);
    }

    public ParamInfo getByTypeCodeFallback(String type, String code){
        logger.info("-->getByTypeCodeFallback:type={},code={}",type,code);
        return new ParamInfo();
    }
}
