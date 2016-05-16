package com.wechat.po;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class TextMessage extends BaseMessage{

    private String Content;
    @XStreamAlias("MsgId")
    private Long MsgId;

    //fieldreamAlias("Content")
   // private String content;


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        this.MsgId = msgId;
    }
}
