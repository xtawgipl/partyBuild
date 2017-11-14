package com.tydic.traffic.entity;

/**
 * 组织部门实体bean
 *
 * @auther create by zhangjj
 * @create 2017/8/16-14:11
 */
public class OrganizationBean {

    /**
     * 数据ID
     */
    private Long id;
    /**
     * 部门编号
     */
    private String bmbh;
    /**
     * 部门名称
     */
    private String bmmc;
    /**
     * 上级部门
     */
    private String sjbm;
    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 负责人
     */
    private String fzr;
    /**
     * 所属级别

     */
    private String ssjb;
    /**
     * 组织类型
     */
    private String zzlx;
    /**
     * 类型编码
     */
    private String llbm;
    /**
     * 是否可用
     */
    private String sfky;

    private String bmbhs;

    private String sjbms;

    public String getBmbhs() {
        return bmbhs;
    }

    public void setBmbhs(String bmbhs) {
        this.bmbhs = bmbhs;
    }

    public String getSjbms() {
        return sjbms;
    }

    public void setSjbms(String sjbms) {
        this.sjbms = sjbms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBmbh() {
        return bmbh;
    }

    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getSjbm() {
        return sjbm;
    }

    public void setSjbm(String sjbm) {
        this.sjbm = sjbm;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getSsjb() {
        return ssjb;
    }

    public void setSsjb(String ssjb) {
        this.ssjb = ssjb;
    }

    public String getZzlx() {
        return zzlx;
    }

    public void setZzlx(String zzlx) {
        this.zzlx = zzlx;
    }

    public String getLlbm() {
        return llbm;
    }

    public void setLlbm(String llbm) {
        this.llbm = llbm;
    }

    public String getSfky() {
        return sfky;
    }

    public void setSfky(String sfky) {
        this.sfky = sfky;
    }
}
