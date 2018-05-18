package com.base.drest.service.mq.cont;

import java.io.Serializable;

/**
 * MsgInfo
 * @author zhouyw
 * @date 2018.05.18
 */
public class MsgInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息
     */
    private T message;

    /**
     * 下一个信道
     */
    private String nextExchange;

    /**
     * 下一次路由关键字
     */
    private String nextRoutingKey;

    /**
     * 下一次的消息设置
     */
    private MsgSetting nextMsgSetting;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getNextExchange() {
        return nextExchange;
    }

    public void setNextExchange(String nextExchange) {
        this.nextExchange = nextExchange;
    }

    public String getNextRoutingKey() {
        return nextRoutingKey;
    }

    public void setNextRoutingKey(String nextRoutingKey) {
        this.nextRoutingKey = nextRoutingKey;
    }

    public MsgSetting getNextMsgSetting() {
        return nextMsgSetting;
    }

    public void setNextMsgSetting(MsgSetting nextMsgSetting) {
        this.nextMsgSetting = nextMsgSetting;
    }
}
