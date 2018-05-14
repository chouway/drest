package com.base.drest.service.mq;

/**
 * IMqService
 * @author zhouyw
 * @date 2018.05.14
 */
public interface IMqService {

    void send(String key,Object content);
}
