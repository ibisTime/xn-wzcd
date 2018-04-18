package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

public class Brand extends ABaseDO {

    // 编号
    private long code;

    // 字母序号
    private String letter;

    // logo
    private String logo;

    // 名称
    private String name;

    // 品牌介绍
    private String descript;

    // 状态
    private String status;

    // 最新修改人
    private String updater;

    // 最新修改时间
    private Date updaterDatetime;

    // 备注
    private String remark;

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdaterDatetime() {
        return updaterDatetime;
    }

    public void setUpdaterDatetime(Date updaterDatetime) {
        this.updaterDatetime = updaterDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
