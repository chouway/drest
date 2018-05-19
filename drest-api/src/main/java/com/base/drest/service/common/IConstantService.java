package com.base.drest.service.common;

import java.util.Map;

/**
 * IConstantService 常量服务
 * @author zhouyw
 * @date 2018.05.19
 */
public interface IConstantService {
    /**
     * 查询
     * @param key
     * @return
     */
    String get(String key);

    String add(String key,String value);

    String edit(String key,String value);

    void remove(String key);
}
