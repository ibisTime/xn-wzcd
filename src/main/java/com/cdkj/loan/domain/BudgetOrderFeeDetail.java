package com.cdkj.loan.domain;

import java.util.Date;

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

    // 交款项目
    private String remitProject;

    // 金额
    private Long amount;

    // 平台账户
    private String platBankcard;

    // 汇款人
    private String remitUser;

    // 到账时间
    private Date reachDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 手续费编号
    private String feeCode;

    private CollectBankcard collectBankcard;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemitType() {
        return remitType;
    }

    public void setRemitType(String remitType) {
        this.remitType = remitType;
    }

    public String getRemitProject() {
        return remitProject;
    }

    public void setRemitProject(String remitProject) {
        this.remitProject = remitProject;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPlatBankcard() {
        return platBankcard;
    }

    public void setPlatBankcard(String platBankcard) {
        this.platBankcard = platBankcard;
    }

    public String getRemitUser() {
        return remitUser;
    }

    public void setRemitUser(String remitUser) {
        this.remitUser = remitUser;
    }

    public Date getReachDatetime() {
        return reachDatetime;
    }

    public void setReachDatetime(Date reachDatetime) {
        this.reachDatetime = reachDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public CollectBankcard getCollectBankcard() {
        return collectBankcard;
    }

    public void setCollectBankcard(CollectBankcard collectBankcard) {
        this.collectBankcard = collectBankcard;
    }

}
