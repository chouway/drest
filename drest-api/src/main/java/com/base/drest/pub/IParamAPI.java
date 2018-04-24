package com.base.drest.pub;

import com.base.drest.constant.PubConstant;
import com.base.drest.domain.ParamInfo;
import com.base.framework.common.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * IParamAPI
 * @author zhouyw
 * @date 2018.04.24
 */
@FeignClient(PubConstant.FEIGN_CLIENT_NAME)
public interface IParamAPI {
    /**
     * 字典查询list
     * @param type 类别
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/param/getByType",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<ParamInfo> getByType(@RequestParam("type")String type)throws BusinessException;
}
