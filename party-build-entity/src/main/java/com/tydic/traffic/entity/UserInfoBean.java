package com.tydic.traffic.entity;

/**
 * 用户信息bean
 *
 * @author zhangjj
 * @create 2017-08-21 17:22
 **/
public class UserInfoBean {

    private Long id;

    private Long policemanId;

    private PolicemanBean policemanBean;

    /** 部门层级 如 交警支队>宝安大队>一中队*/
    private String orgRank;

    /** 部门职务 ,大队长，中队长等*/
    private String departmentPositions;

    /**所属党支部 */
    private String partyBranch;

    /**党内职务 */
    private String partyDuty;

    /**入党时间 */
    private String partyTime;

    /** 角色, 1表示具有所在部门的管理员操作权限，2表示 无 */
    private int role;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public PolicemanBean getPolicemanBean() {
        return policemanBean;
    }

    public void setPolicemanBean(PolicemanBean policemanBean) {
        this.policemanBean = policemanBean;
    }

    public String getOrgRank() {
        return orgRank;
    }

    public void setOrgRank(String orgRank) {
        this.orgRank = orgRank;
    }

    public String getDepartmentPositions() {
        return departmentPositions;
    }

    public void setDepartmentPositions(String departmentPositions) {
        this.departmentPositions = departmentPositions;
    }

    public String getPartyBranch() {
        return partyBranch;
    }

    public void setPartyBranch(String partyBranch) {
        this.partyBranch = partyBranch;
    }

    public String getPartyDuty() {
        return partyDuty;
    }

    public void setPartyDuty(String partyDuty) {
        this.partyDuty = partyDuty;
    }

    public String getPartyTime() {
        return partyTime;
    }

    public void setPartyTime(String partyTime) {
        this.partyTime = partyTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
