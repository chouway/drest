package com.base.drest.pub;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.IParamInfoService;
import com.base.framework.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IParamInfoService paramInfoService;

    @Override
    public ParamInfo getByTypeCode(String type, String code) throws BusinessException {
        return paramInfoService.getByTypeCode(type, code);
    }
}
