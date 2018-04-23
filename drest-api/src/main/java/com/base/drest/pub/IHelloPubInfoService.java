package com.base.drest.pub;

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
@FeignClient("drest-service")
public interface IHelloPubInfoService {

    @RequestMapping(value = "/getByTypeCode", method = RequestMethod.GET)
    @ResponseBody
    ParamInfo getByTypeCode(@RequestParam("type") String type, @RequestParam("code") String code)throws BusinessException;
}
