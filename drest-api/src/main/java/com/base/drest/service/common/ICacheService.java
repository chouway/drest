package com.base.drest.service.common;

/**
 * ICacheService
 * @author zhouyw
 * @date 2018.05.19
 */
public interface ICacheService {

    /**
     * 缓存 字符串  内置超时时间
     * @param key
     * @param msg
     */
    void cache(String key, Object msg);

    /**
     * 缓存
     * @param key
     * @param msg
     * @param timeout 秒
     */
    void cache(String key,Object msg,long timeout);

    /**
     * 获取
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T get(String key,Class<T> clazz);

    /**
     * 获取所剩过时 时间 秒
     * @param key
     * @return
     */
    Long getExpire(String key);

    /**
     * 移除缓存key
     * @param key
     * @return
     */
    Boolean remove(String key);
}
