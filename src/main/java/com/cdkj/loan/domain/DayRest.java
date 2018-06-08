package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 休息日记录
* @author: silver 
* @since: 2018-06-08 14:42:33
* @history:
*/
public class DayRest extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private String id;

    // 日期
    private Date date;

    // 是否休息
    private String isRest;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 公告编号
    private String companyCode;

    // 开始时间
    private Date startDatetime;

    // 结束时间
    private Date endDatetime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIsRest(String isRest) {
        this.isRest = isRest;
    }

    public String getIsRest() {
        return isRest;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

}
