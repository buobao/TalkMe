package com.king.turman.talkme.viewbeans;

import java.util.List;

/**
 * Created by diaoqf on 2018/10/22.
 */

public class TaskBean {

    public static final int STATUS_ACCEPT = 1; //已接收
    public static final int STATUS_CHECK = 2; //已确认
    public static final int STATUS_PROCESS = 3; //处理中
    public static final int STATUS_FEEDBACK = 4; //已反馈
    public static final int STATUS_FINISH = 5;  //已完成

    /**
     * 发送者账号
     */
    private String sender;
    /**
     * 接收者列表
     */
    private List<String> receivers;
    /**
     * 任务摘要
     */
    private String taskTitle;
    /**
     * 任务详情
     */
    private String remark;
    /**
     * 多媒体文件列表
     */
    private List<String> fileList;
    /**
     * 任务创建时间
     */
    private String createTime;
    /**
     * 任务接收时间
     */
    private String acceptTime;
    /**
     * 任务结束时间
     */
    private String deadLine;
    /**
     * 任务提示时间列表
     */
    private List<String> alertTimes;
    /**
     * 任务状态
     */
    private int status;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public List<String> getAlertTimes() {
        return alertTimes;
    }

    public void setAlertTimes(List<String> alertTimes) {
        this.alertTimes = alertTimes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}





















