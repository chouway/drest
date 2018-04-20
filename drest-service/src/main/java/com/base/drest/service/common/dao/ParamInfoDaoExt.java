package com.base.drest.service.common.dao;

import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.vo.ParamInfoCond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;

/**
 * ParamInfoExtService
 * @author zhouyw
 * @date 2018.04.19
 */
@Mapper
public interface ParamInfoDaoExt {
    /**
     * 获取某个字典下所有的子字典
     * @param type
     * @param code
     * @return
     */
    List<ParamInfo> getTree(@Param("type") String type, @Param("code") String code);

    /**
     * 内置分页查询
     * @param params
     * @return
     */
    List<ParamInfo> getList(@Param("cond") ParamInfoCond cond, @Param("page") PagedListHolder page);

    /**
     * 统计
     * @param params
     * @return
     */
    int countList(@Param("cond") ParamInfoCond cond);

}
