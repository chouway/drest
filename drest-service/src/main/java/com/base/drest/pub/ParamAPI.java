package com.base.drest.pub;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.IParamInfoService;
import com.base.framework.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ParamAPI
 * @author zhouyw
 * @date 2018.04.24
 */
@RestController
public class ParamAPI implements IParamAPI {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private IParamInfoService paramInfoService;

    @Override
    public List<ParamInfo> getByType(String type) throws BusinessException {
        logger.info("-->getByType={}", type);
            return paramInfoService.getByType(type);
    }
}
