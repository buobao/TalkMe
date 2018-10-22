package com.king.turman.talkme.viewbeans;

/**
 * Created by diaoqf on 2018/10/22.
 */

public class TaskMessage {
    /**
     * 用于挂载task使用,组织规则：taskbean.sender + "_" +AppCurrentStatus.getInstance().getjPushAlias()
     */
    private String messageId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 接收时间
     */
    private String acceptTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }
}
