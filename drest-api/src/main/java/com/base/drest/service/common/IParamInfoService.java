package com.base.drest.service.common;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.vo.ParamInfoCond;
import com.base.framework.common.exception.BusinessException;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * IParamInfoService
 * @author zhouyw
 * @date 2018.04.18
 */
@FeignClient
public interface IParamInfoService {
    /**
     * 字典查询one
     * @param type 类别
     * @param code 字典码
     * @return
     * @throws BusinessException
     */
    ParamInfo getByTypeCode(String type, String code)throws BusinessException;

    /**
     * 字典查询list
     * @param type 类别
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getByType(String type)throws BusinessException;

    /**
     * 字典查询list
     * @param paramInfoVO
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getSubByTypeCode(String type, String code)throws BusinessException;

    /**
     * 查整个字典树
     * @param typeCode
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getTree(String type, String code)throws BusinessException;

    /**
     * 保存字典
     * @param paramInfo
     * @return
     * @throws BusinessException
     */
    ParamInfo save(ParamInfo paramInfo)throws BusinessException;

    /**
     * 移除字典
     * @param paramInfo
     * @return
     * @throws BusinessException
     */
    int remove(String id)throws BusinessException;

    /**
     * 分页查询
     * @param cond
     * @param page
     * @return
     * @throws BusinessException
     */
    PagedListHolder<ParamInfo> getPage(ParamInfoCond cond, PagedListHolder page)throws BusinessException;
}
