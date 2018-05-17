package com.base.drest.service.mq.cont;

import java.io.Serializable;

/**
 * MessageSetting 消息设置
 * @author zhouyw
 * @date 2018.05.17
 */
public class MsgSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息过期时长 （毫秒）    放置消息中间件后距离过期的时间
     */
    private long expiration;

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
