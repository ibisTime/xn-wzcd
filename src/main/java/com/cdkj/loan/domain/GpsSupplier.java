package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* gps供应商
* @author: CYunlai 
* @since: 2018-08-20 14:30:56
* @history:
*/
public class GpsSupplier extends ABaseDO {

    private static final long serialVersionUID = -5260683999830541063L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 联系人
    private String contacts;

    // 联系人手机号
    private String contactsMobile;

    // 地址
    private String address;

    // 最新修改人
    private String updater;

    // 最新修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*-------辅助字段---------*/

    // 最新修改人名称
    private String updaterName;

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContactsMobile(String contactsMobile) {
        this.contactsMobile = contactsMobile;
    }

    public String getContactsMobile() {
        return contactsMobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
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
