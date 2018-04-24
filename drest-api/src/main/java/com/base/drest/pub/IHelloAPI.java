package com.base.drest.pub;

import com.base.drest.constant.PubConstant;
import com.base.drest.domain.ParamInfo;
import com.base.framework.common.exception.BusinessException;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IHelloPubInfoService
 * @author zhouyw
 * @date 2018.04.23
 */
@FeignClient(PubConstant.FEIGN_CLIENT_NAME)
public interface IHelloAPI{

    @RequestMapping(value = "/hello/getByTypeCode")//produces = MediaType.APPLICATION_XML_VALUE  页面接收的默认是xml数据；
    @ResponseBody
    ParamInfo getByTypeCode(@RequestParam("type") String type, @RequestParam("code") String code)throws BusinessException;
}
