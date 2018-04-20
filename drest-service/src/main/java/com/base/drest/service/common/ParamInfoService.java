package com.base.drest.service.common;

import com.alibaba.fastjson.JSON;
import com.base.drest.dao.ParamInfoDao;
import com.base.drest.domain.ParamInfo;
import com.base.drest.service.common.dao.ParamInfoDaoExt;
import com.base.drest.service.common.vo.ParamInfoCond;
import com.base.framework.common.exception.BusinessException;
import com.base.framework.core.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ParamInfoService
 * @author zhouyw
 * @date 2018.04.18
 */
@Service
@Transactional
public class ParamInfoService implements IParamInfoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ParamInfoDao paramInfoDao;

    @Autowired
    private ParamInfoDaoExt paramInfoDaoExt;

    @Override
    public ParamInfo getByTypeCode(String type,String code) throws BusinessException {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException("字典类别为空");
        }
        if(StringUtils.isEmpty(code)){
            throw new BusinessException("字典码为空");
        }
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setType(type);
        paramInfo.setCode(code);
        return paramInfoDao.selectOne(paramInfo);
    }

    @Override
    public List<ParamInfo> getByType(String type) throws BusinessException {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException("字典类别为空");
        }
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setType(type);
        return paramInfoDao.select(paramInfo);
    }

    @Override
    public List<ParamInfo> getSubByTypeCode(String type, String code) throws BusinessException {
        ParamInfo paramInfo = this.getByTypeCode(type, code);
        if(paramInfo==null){
            return new ArrayList<ParamInfo>();
        }
        ParamInfo cond = new ParamInfo();
        cond.setParentId(paramInfo.getId());
        return paramInfoDao.select(cond);
    }

    @Override
    public List<ParamInfo> getTree(String type, String code) throws BusinessException {
        //需用到自定义循环 with ..
        return paramInfoDaoExt.getTree(type,code);
    }

    @Override
    public ParamInfo save(ParamInfo paramInfo) throws BusinessException {
        try{
           if(paramInfo == null){
               throw new BusinessException("字典为空");
           }
           boolean isAdd = StringUtils.isEmpty(paramInfo.getId());
           if(isAdd){
               paramInfo.setId(UUIDUtils.generate());
               paramInfoDao.insert(paramInfo);
           }else{
               paramInfoDao.updateByPrimaryKey(paramInfo);
           }
           return paramInfo;
        }catch (BusinessException e){
           logger.error("busi error:{}-->[paramInfo]={}",e.getMessage(), JSON.toJSONString(new Object[]{paramInfo}),e);
           throw e;
        }catch (Exception e){
           logger.error("error:{}-->[paramInfo]={}",e.getMessage(),JSON.toJSONString(new Object[]{paramInfo}),e);
           if(e instanceof DuplicateKeyException){
               throw new BusinessException("保存失败:重复!");
           }
           throw new BusinessException("系统错误");
        }
    }

    @Override
    public int remove(String id) throws BusinessException {
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setId(id);
        return paramInfoDao.deleteByPrimaryKey(paramInfo);
    }

    @Override
    public PagedListHolder<ParamInfo> getPage(ParamInfoCond cond,PagedListHolder page) throws BusinessException {
        if(page==null){
            page = new PagedListHolder();
        }
        int pageSize = paramInfoDaoExt.countList(cond);
        List<ParamInfo> list = paramInfoDaoExt.getList(cond, page);
        page.setSource(list);
        page.setPageSize(pageSize);
        return page;
    }
    /* -----private method spilt----- */
}
