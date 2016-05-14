package com.wechat.po;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class TextMessage extends BaseMessage{

    private String content;
    private Long msgId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
