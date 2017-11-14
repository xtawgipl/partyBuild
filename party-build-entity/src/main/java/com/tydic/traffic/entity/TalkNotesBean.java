package com.tydic.traffic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 谈话记录bean
 *
 * @author zhangjj
 * @create 2017-08-19 9:39
 **/
public class TalkNotesBean {

    private Long id;

    private Long leaderId;

    /** 谈话领导*/
    private PolicemanBean leader;

    private Long conversationId;

    /**谈话对象 */
    private PolicemanBean conversation;

    private String time;

    /** 分*/
    private Float duration;


    private String content;


    private String photo;

    /**0 正常谈话 1异常谈话 */
    private int flag;

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PolicemanBean getLeader() {
        return leader;
    }

    public void setLeader(PolicemanBean leader) {
        this.leader = leader;
    }

    public PolicemanBean getConversation() {
        return conversation;
    }

    public void setConversation(PolicemanBean conversation) {
        this.conversation = conversation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
