package com.tydic.traffic.entity;

/**
 * 党员绩效考核指标数据bean
 *
 * @author zhangjj
 * @create 2017-08-23 16:31
 **/
public class PartyKPIBean {

    private Long id;

    private Long policemanId;

    private Float workingTime;

    private Float mileage;

    private Integer lawAmount;

    private Integer alarmAmount;

    private String date;

    private Integer stationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPolicemanId() {
        return policemanId;
    }

    public void setPolicemanId(Long policemanId) {
        this.policemanId = policemanId;
    }

    public Float getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Float workingTime) {
        this.workingTime = workingTime;
    }

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    public Integer getLawAmount() {
        return lawAmount;
    }

    public void setLawAmount(Integer lawAmount) {
        this.lawAmount = lawAmount;
    }

    public Integer getAlarmAmount() {
        return alarmAmount;
    }

    public void setAlarmAmount(Integer alarmAmount) {
        this.alarmAmount = alarmAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStationType() {
        return stationType;
    }

    public void setStationType(Integer stationType) {
        this.stationType = stationType;
    }
}
