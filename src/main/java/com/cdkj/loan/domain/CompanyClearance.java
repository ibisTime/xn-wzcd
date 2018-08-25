package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 公司结清记录
* @author: CYunlai 
* @since: 2018-08-24 17:18:34
* @history:
*/
public class CompanyClearance extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private int id;

    // 业务编号
    private String repaybizCode;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*----------辅助字段-------------*/

    // 更新人名称
    private String updaterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public void setRepaybizCode(String repaybizCode) {
        this.repaybizCode = repaybizCode;
    }

    public String getRepaybizCode() {
        return repaybizCode;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
