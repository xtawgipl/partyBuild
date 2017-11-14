package com.tydic.traffic.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 警员实体bean
 *
 * @auther create by zhangjj
 * @create 2017/8/16-12:14
 */
public class PolicemanBean {

    /**
     * 数据ID
     */
    private Long id;
    /**
     * 警员号码
     */
    private String jyhm;
    /**
     * 姓名
     */
    private String xm;
    /**
     * 性别
     */
    private String xb;
    /**
     * 警衔
     */
    private String jx;
    /**
     * 民族
     */
    private String mz;
    /**
     * 出生日期
     */
    private Date csrq;
    /**
     * 政治面貌
     */
    private String zzmm;
    /**
     * 现任职务
     */
    private String xrzw;
    /**
     * 文化程度
     */
    private String whcd;
    /**
     * 对讲机呼号

     */
    private String djjhh;
    /**
     * 手机号码
     */
    private String sjhm;
    /**
     * 办公电话
     */
    private String bgdh;
    /**
     * 家庭电话
     */
    private String jtdh;
    /**
     * 电子邮件
     */
    private String dzyj;
    /**
     * 照片地址
     */
    private String zpdz;
    /**
     * 信息来源
     */
    private String xxly;
    /**
     * 是否有效
     */
    private String sfyx;
    /**
     * 所属部门
     */
    private Long ssbm;

    private OrganizationBean organizationBean;

    /**
     * 备用字段1
     */
    private String byzd1;
    /**
     * 备用字段2
     */
    private String byzd2;
    /**
     * 备用字段3
     */
    private String byzd3;


    /**
     * 部门名称[组织机构信息表字段,通过ssbm查询得到]
     */
    private String bmmc;
    /**
     * 部门编号
     */
    private String bmbh;

    private String sfxnjy;

    private String sjgadh;

    private String modifytime;

    private String x;

    private String y;

    public OrganizationBean getOrganizationBean() {
        return organizationBean;
    }

    public void setOrganizationBean(OrganizationBean organizationBean) {
        this.organizationBean = organizationBean;
    }

    public String getSfxnjy() {
        return sfxnjy;
    }

    public void setSfxnjy(String sfxnjy) {
        this.sfxnjy = sfxnjy;
    }

    public String getSjgadh() {
        return sjgadh;
    }

    public void setSjgadh(String sjgadh) {
        this.sjgadh = sjgadh;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJyhm() {
        return jyhm;
    }

    public void setJyhm(String jyhm) {
        this.jyhm = jyhm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getXrzw() {
        return xrzw;
    }

    public void setXrzw(String xrzw) {
        this.xrzw = xrzw;
    }

    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd;
    }

    public String getDjjhh() {
        return djjhh;
    }

    public void setDjjhh(String djjhh) {
        this.djjhh = djjhh;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getBgdh() {
        return bgdh;
    }

    public void setBgdh(String bgdh) {
        this.bgdh = bgdh;
    }

    public String getJtdh() {
        return jtdh;
    }

    public void setJtdh(String jtdh) {
        this.jtdh = jtdh;
    }

    public String getDzyj() {
        return dzyj;
    }

    public void setDzyj(String dzyj) {
        this.dzyj = dzyj;
    }

    public String getZpdz() {
        return zpdz;
    }

    public void setZpdz(String zpdz) {
        this.zpdz = zpdz;
    }

    public String getXxly() {
        return xxly;
    }

    public void setXxly(String xxly) {
        this.xxly = xxly;
    }

    public String getSfyx() {
        return sfyx;
    }

    public void setSfyx(String sfyx) {
        this.sfyx = sfyx;
    }

    public Long getSsbm() {
        return ssbm;
    }

    public void setSsbm(Long ssbm) {
        this.ssbm = ssbm;
    }

    public String getByzd1() {
        return byzd1;
    }

    public void setByzd1(String byzd1) {
        this.byzd1 = byzd1;
    }

    public String getByzd2() {
        return byzd2;
    }

    public void setByzd2(String byzd2) {
        this.byzd2 = byzd2;
    }

    public String getByzd3() {
        return byzd3;
    }

    public void setByzd3(String byzd3) {
        this.byzd3 = byzd3;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getBmbh() {
        return bmbh;
    }

    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
