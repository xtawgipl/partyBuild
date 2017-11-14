package com.tydic.traffic.entity;

/**
 * 党费缴纳bean
 *
 * @author zhangjj
 * @create 2017-08-22 13:23
 **/
public class PartyFeeBean {

    private Long id;

    private Long policemanId;

    private PolicemanBean policemanBean;

    /** yyyy-MM-dd*/
    private String dateTime;

    private String photo;

    private String desc;

    public Long getPolicemanId() {
        return policemanId;
    }

    public void setPolicemanId(Long policemanId) {
        this.policemanId = policemanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PolicemanBean getPolicemanBean() {
        return policemanBean;
    }

    public void setPolicemanBean(PolicemanBean policemanBean) {
        this.policemanBean = policemanBean;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
