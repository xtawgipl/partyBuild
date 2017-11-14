package com.tydic.traffic.entity;

/**
 * 党员先锋模范bean
 *
 * @author zhangjj
 * @create 2017-08-21 14:22
 **/
public class PartyModelBean {

    private Long id;

    private Long policemanId;

    private PolicemanBean policemanBean;

    private String photo;

    /** 警星 1为有，2为无*/
    private int star;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

}
