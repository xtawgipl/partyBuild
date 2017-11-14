package com.tydic.traffic.entity;

/**
 * 专项学习bean
 *
 * @author zhangjj
 * @create 2017-08-22 14:21
 **/
public class SpecialLearningBean {

    private Long id;

    private Long policemanId;

    private PolicemanBean policemanBean;

    /** 课程名*/
    private String course;

    /**正确率 */
    private String correctRate;

    /**完成率 */
    private String completionRate;

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(String correctRate) {
        this.correctRate = correctRate;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }
}
