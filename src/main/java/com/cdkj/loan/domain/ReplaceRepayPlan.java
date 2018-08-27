package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 代偿还款计划单
* @author: silver 
* @since: 2018-06-15 17:24:28
* @history:
*/
public class ReplaceRepayPlan extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1月供,2剩余贷款金额)
    private String type;

    // 与我司过往是否有纠纷
    private String isPlatIssue;

    // 代偿后采取的方式
    private String takeWay;

    // 暂缓天数
    private Integer deferDays;

    // 代偿申请原因
    private String applyReason;

    // 代偿申请原因说明
    private String applyReasonNote;

    // 风控经理意见
    private String riskNote;

    // 代偿利率
    private double repayRate;

    // 付款日期
    private Date repayDate;

    // 付款账号编号
    private String repayBankcard;

    // 付款人
    private String repayUser;

    // 付款凭证
    private String repayBill;

    // 付款说明
    private String repayNote;

    // 业务编号(还款计划)
    private String bizCode;

    // 代偿申请编号
    private String replaceApplyCode;

    // 客户用户编号
    private String customerUserId;

    // 当前节点
    private String curNodeCode;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // **********db properties**************

    private String customerUserName;

    private String updaterName;

    private String roleCode;

    // 还款计划
    private RepayPlan repayPlan;

    // 证件号
    private String idNo;

    // 代偿申请单
    private ReplaceRepayApply replaceRepayApply;

    public ReplaceRepayApply getReplaceRepayApply() {
        return replaceRepayApply;
    }

    public void setReplaceRepayApply(ReplaceRepayApply replaceRepayApply) {
        this.replaceRepayApply = replaceRepayApply;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public RepayPlan getRepayPlan() {
        return repayPlan;
    }

    public void setRepayPlan(RepayPlan repayPlan) {
        this.repayPlan = repayPlan;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setIsPlatIssue(String isPlatIssue) {
        this.isPlatIssue = isPlatIssue;
    }

    public String getIsPlatIssue() {
        return isPlatIssue;
    }

    public void setTakeWay(String takeWay) {
        this.takeWay = takeWay;
    }

    public String getTakeWay() {
        return takeWay;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReasonNote(String applyReasonNote) {
        this.applyReasonNote = applyReasonNote;
    }

    public String getApplyReasonNote() {
        return applyReasonNote;
    }

    public void setRiskNote(String riskNote) {
        this.riskNote = riskNote;
    }

    public String getRiskNote() {
        return riskNote;
    }

    public void setRepayBankcard(String repayBankcard) {
        this.repayBankcard = repayBankcard;
    }

    public String getRepayBankcard() {
        return repayBankcard;
    }

    public void setRepayUser(String repayUser) {
        this.repayUser = repayUser;
    }

    public String getRepayUser() {
        return repayUser;
    }

    public void setRepayBill(String repayBill) {
        this.repayBill = repayBill;
    }

    public String getRepayBill() {
        return repayBill;
    }

    public void setRepayNote(String repayNote) {
        this.repayNote = repayNote;
    }

    public String getRepayNote() {
        return repayNote;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setReplaceApplyCode(String replaceApplyCode) {
        this.replaceApplyCode = replaceApplyCode;
    }

    public String getReplaceApplyCode() {
        return replaceApplyCode;
    }

    public void setCustomerUserId(String customerUserId) {
        this.customerUserId = customerUserId;
    }

    public String getCustomerUserId() {
        return customerUserId;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Integer getDeferDays() {
        return deferDays;
    }

    public void setDeferDays(Integer deferDays) {
        this.deferDays = deferDays;
    }

    public double getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(double repayRate) {
        this.repayRate = repayRate;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
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
