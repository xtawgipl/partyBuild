package com.tydic.traffic.entity;

/**
 * 党组织生活bean
 *
 * @author zhangjj
 * @create 2017-08-22 11:54
 **/
public class PartyCultureBean {

    private Long id;

    private String title;

    private String content;

    private String dateTime;

    private String photo;

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
        System.out.println("title --> " + title);
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
