package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:48:07 
 * @history:
 */
public class CompProduct extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类别编号
    private String categoryCode;

    // 品名
    private String name;

    // 规格型号
    private String model;

    // 单位
    private String unit;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // **************db propertis**************

    // 类型
    private CompCategory compCategory;

    // 系统用户
    private SYSUser updateUser;

    public SYSUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SYSUser updateUser) {
        this.updateUser = updateUser;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
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

    public CompCategory getCompCategory() {
        return compCategory;
    }

    public void setCompCategory(CompCategory compCategory) {
        this.compCategory = compCategory;
    }

}
