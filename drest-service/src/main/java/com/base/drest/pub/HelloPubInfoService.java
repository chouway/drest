package com.base.drest.pub;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.IParamInfoService;
import com.base.framework.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloPubInfoService
 * @author zhouyw
 * @date 2018.04.23
 */
@RestController
public class HelloPubInfoService implements IHelloPubInfoService {

    private static Logger logger = LoggerFactory.getLogger(HelloPubInfoService.class);


    @Autowired
    private IParamInfoService paramInfoService;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public ParamInfo getByTypeCode(String type, String code) throws BusinessException {
        logger.info("-->serverPort={}", serverPort);
        return paramInfoService.getByTypeCode(type, code);
    }
}
