package com.base.drest.pub;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.IParamInfoService;
import com.base.framework.common.bo.ResultBO;
import com.base.framework.common.exception.BusinessException;
import com.base.framework.service.common.BaseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * HelloAPI
 * @author zhouyw
 * @date 2018.04.23
 */
@RestController
public class HelloAPI extends BaseService implements IHelloAPI {

    @Autowired
    private IParamInfoService paramInfoService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${app.param.test.isTestFallBack}")
    private boolean isTestFB;

    @Override
    @HystrixCommand(defaultFallback = defaultFallback)
    public ParamInfo getByTypeCode(String type, String code) throws BusinessException {
        logger.info("-->serverPort={}", serverPort);
        if(isTestFB){//在这模拟 调用其它服务失败； 当失败异常过多后，降级处理
            String msg = "暂时失败下，测试fallback";
            logger.error("error:-->msg={}", msg);
            throw new BusinessException(msg);
        }
        return paramInfoService.getByTypeCode(type, code);
    }

    public ParamInfo getByTypeCodeFallback(String type, String code){
        logger.info("-->getByTypeCodeFallback:type={},code={}",type,code);
        throw new BusinessException("服务繁忙，请稍候再试");
    }

    public ParamInfo getByTypeCodeFallbackDef(){
        throw new BusinessException("服务繁忙，请稍候再试");
    }

    @Override
    @HystrixCommand(ignoreExceptions = BusinessException.class)
    public ParamInfo getByTypeCodeTestFB() {
        logger.info("-->getByTypeCodeTestFB");
        if(isTestFB){
            String msg = "getByTypeCodeTestFB暂时失败下，测试fallback";
            logger.error("error:-->msg={}", msg);
            throw new RuntimeException(msg);
        }
        return null;
    }

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    @HystrixCommand(defaultFallback = defaultFallback)
    public ResultBO getByTypeCodeDef(boolean isErr)throws BusinessException{
        ResultBO resultBO = new ResultBO();
        logger.info("-->getByTypeCodeDef");
        if(isErr){
            atomicInteger.getAndAdd(1);
            String msg = "getByTypeCodeDef暂时失败下，测试fallback";
            logger.error("count={},error:-->msg={}",atomicInteger.get(), msg);
            throw new BusinessException(msg);
        }
        resultBO.setSuccess(true);
        return resultBO;
    }

}
