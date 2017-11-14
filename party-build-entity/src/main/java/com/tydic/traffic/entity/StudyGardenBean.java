package com.tydic.traffic.entity;

/**
 * 学习园地bean
 *
 * @author zhangjj
 * @create 2017-08-21 12:07
 **/
public class StudyGardenBean {

    private Long id;

    private String title;

    private String content;

    /**内容链接 */
    private String link;

    /**发布时间 */
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
