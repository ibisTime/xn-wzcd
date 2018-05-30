package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 准入单手续费明细
* @author: xieyj 
* @since: 2018-05-30 19:05:43
* @history:
*/
public class BudgetOrderFeeDetail extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 交款类型
    private String remitType;

    // 交款业务公司编号
    private String remitCompanyCode;

    // 交款项目
    private String remitProject;

    // 金额
    private String amount;

    // 平台账户
    private String platBankcard;

    // 汇款人
    private String remitUser;

    // 到账时间
    private String reachDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private String updateDatetime;

    // 备注
    private String remark;

    // 手续费编号
    private String feeCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRemitType(String remitType) {
        this.remitType = remitType;
    }

    public String getRemitType() {
        return remitType;
    }

    public void setRemitCompanyCode(String remitCompanyCode) {
        this.remitCompanyCode = remitCompanyCode;
    }

    public String getRemitCompanyCode() {
        return remitCompanyCode;
    }

    public void setRemitProject(String remitProject) {
        this.remitProject = remitProject;
    }

    public String getRemitProject() {
        return remitProject;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setPlatBankcard(String platBankcard) {
        this.platBankcard = platBankcard;
    }

    public String getPlatBankcard() {
        return platBankcard;
    }

    public void setRemitUser(String remitUser) {
        this.remitUser = remitUser;
    }

    public String getRemitUser() {
        return remitUser;
    }

    public void setReachDatetime(String reachDatetime) {
        this.reachDatetime = reachDatetime;
    }

    public String getReachDatetime() {
        return reachDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
