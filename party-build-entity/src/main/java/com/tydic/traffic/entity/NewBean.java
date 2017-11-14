package com.tydic.traffic.entity;

/**
 * 时政要闻bean
 *
 * @author zhangjj
 * @create 2017-08-21 11:32
 **/
public class NewBean {

    private Long id;

    private String title;

    private String content;

    private String photo;

    /** 新闻发生时间*/
    private String newTime;

    /** 数据录入时间*/
    private String dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
