package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 司法审判表
* @author: silver 
* @since: 2018-06-16 15:25:21
* @history:
*/
public class Judge extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 还款业务编号
    private String repayBizCode;

    // 案号
    private String caseNumber;

    // 原告
    private String plaintiff;

    // 被告
    private String defendant;

    // 诉讼标的
    private String caseSubject;

    // 涉案车辆
    private String caseCar;

    // 诉讼费
    private Long caseFee;

    // 起诉日期
    private Date caseStartDatetime;

    // 起诉状态
    private String caseStatus;

    // 起诉附件
    private String casePdf;

    // 打款证明
    private String payAmountProve;

    // 受理时间
    private Date acceptanceTime;

    // 开庭日期
    private Date courtDatetime;

    // 开庭地点
    private String courtAddress;

    // 经办法官
    private String handleJudge;

    // 审理案号
    private String hearCaseNumber;

    // 判决日期
    private Date judgeDatetime;

    // 判决结果
    private String judgeResult;

    // 判决附件
    private String judgePdf;

    // 判决书送达时间
    private Date judgePdfDeliveryTime;

    // 生效时间
    private Date effectiveTime;

    // 执行案号
    private String exeCaseNumber;

    // 执行申请人
    private String exeApplyUser;

    // 执行标的额
    private Long executeMarkAmount;

    // 执行日期
    private Date exeDatetime;

    // 执行结果
    private String exeResult;

    // 拍卖日期
    private Date saleDatetime;

    // 执行裁定书
    private String exePdf;

    // 状态 0 待处理 1 结束
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    /******************db properties******************/
    // 更新人
    private String updaterName;

    // 执行申请人
    private String exeApplyUserName;

    public String getExeApplyUserName() {
        return exeApplyUserName;
    }

    public void setExeApplyUserName(String exeApplyUserName) {
        this.exeApplyUserName = exeApplyUserName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Long getExecuteMarkAmount() {
        return executeMarkAmount;
    }

    public void setExecuteMarkAmount(Long executeMarkAmount) {
        this.executeMarkAmount = executeMarkAmount;
    }

    public String getPayAmountProve() {
        return payAmountProve;
    }

    public void setPayAmountProve(String payAmountProve) {
        this.payAmountProve = payAmountProve;
    }

    public Date getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(Date acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }

    public String getHandleJudge() {
        return handleJudge;
    }

    public void setHandleJudge(String handleJudge) {
        this.handleJudge = handleJudge;
    }

    public String getHearCaseNumber() {
        return hearCaseNumber;
    }

    public void setHearCaseNumber(String hearCaseNumber) {
        this.hearCaseNumber = hearCaseNumber;
    }

    public String getJudgeResult() {
        return judgeResult;
    }

    public void setJudgeResult(String judgeResult) {
        this.judgeResult = judgeResult;
    }

    public Date getJudgePdfDeliveryTime() {
        return judgePdfDeliveryTime;
    }

    public void setJudgePdfDeliveryTime(Date judgePdfDeliveryTime) {
        this.judgePdfDeliveryTime = judgePdfDeliveryTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    public void setPlaintiff(String plaintiff) {
        this.plaintiff = plaintiff;
    }

    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public String getCaseSubject() {
        return caseSubject;
    }

    public void setCaseSubject(String caseSubject) {
        this.caseSubject = caseSubject;
    }

    public String getCaseCar() {
        return caseCar;
    }

    public void setCaseCar(String caseCar) {
        this.caseCar = caseCar;
    }

    public Long getCaseFee() {
        return caseFee;
    }

    public void setCaseFee(Long caseFee) {
        this.caseFee = caseFee;
    }

    public Date getCaseStartDatetime() {
        return caseStartDatetime;
    }

    public void setCaseStartDatetime(Date caseStartDatetime) {
        this.caseStartDatetime = caseStartDatetime;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCasePdf() {
        return casePdf;
    }

    public void setCasePdf(String casePdf) {
        this.casePdf = casePdf;
    }

    public Date getCourtDatetime() {
        return courtDatetime;
    }

    public void setCourtDatetime(Date courtDatetime) {
        this.courtDatetime = courtDatetime;
    }

    public Date getJudgeDatetime() {
        return judgeDatetime;
    }

    public void setJudgeDatetime(Date judgeDatetime) {
        this.judgeDatetime = judgeDatetime;
    }

    public String getJudgePdf() {
        return judgePdf;
    }

    public void setJudgePdf(String judgePdf) {
        this.judgePdf = judgePdf;
    }

    public String getExeCaseNumber() {
        return exeCaseNumber;
    }

    public void setExeCaseNumber(String exeCaseNumber) {
        this.exeCaseNumber = exeCaseNumber;
    }

    public String getExeApplyUser() {
        return exeApplyUser;
    }

    public void setExeApplyUser(String exeApplyUser) {
        this.exeApplyUser = exeApplyUser;
    }

    public Date getExeDatetime() {
        return exeDatetime;
    }

    public void setExeDatetime(Date exeDatetime) {
        this.exeDatetime = exeDatetime;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    public Date getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(Date saleDatetime) {
        this.saleDatetime = saleDatetime;
    }

    public String getExePdf() {
        return exePdf;
    }

    public void setExePdf(String exePdf) {
        this.exePdf = exePdf;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
