package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 逾期处理
* @author: CYunlai 
* @since: 2018-08-03 11:24:35
* @history:
*/
public class OverdueTreatment extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 还款计划编号
    private String repayPlanCode;

    // 催收方式
    private String collectionWay;

    // 催收对象
    private String collectionTarget;

    // 催收过程
    private String collectionProcess;

    // 客户意愿
    private String collectionWish;

    // 催收过程说明
    private String collectionProcessNote;

    // 催收结果
    private String collectionResult;

    // 是否提供押金
    private String depositIsProvide;

    // 违约押金
    private Long overdueDeposit;

    // 实际还款金额
    private Long realRepayAmount;

    // 催收结果说明
    private String collectionResultNote;

    // 催收类型(0过程，1结果)
    private String collectionType;

    // 操作人
    private String operator;

    // 操作时间
    private String updateDatetime;

    /*------------辅助字段--------------*/

    // 操作人名称
    private String operatorName;

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRepayPlanCode(String repayPlanCode) {
        this.repayPlanCode = repayPlanCode;
    }

    public String getRepayPlanCode() {
        return repayPlanCode;
    }

    public void setCollectionWay(String collectionWay) {
        this.collectionWay = collectionWay;
    }

    public String getCollectionWay() {
        return collectionWay;
    }

    public void setCollectionTarget(String collectionTarget) {
        this.collectionTarget = collectionTarget;
    }

    public String getCollectionTarget() {
        return collectionTarget;
    }

    public void setCollectionProcess(String collectionProcess) {
        this.collectionProcess = collectionProcess;
    }

    public String getCollectionProcess() {
        return collectionProcess;
    }

    public void setCollectionWish(String collectionWish) {
        this.collectionWish = collectionWish;
    }

    public String getCollectionWish() {
        return collectionWish;
    }

    public void setCollectionProcessNote(String collectionProcessNote) {
        this.collectionProcessNote = collectionProcessNote;
    }

    public String getCollectionProcessNote() {
        return collectionProcessNote;
    }

    public void setCollectionResult(String collectionResult) {
        this.collectionResult = collectionResult;
    }

    public String getCollectionResult() {
        return collectionResult;
    }

    public void setDepositIsProvide(String depositIsProvide) {
        this.depositIsProvide = depositIsProvide;
    }

    public String getDepositIsProvide() {
        return depositIsProvide;
    }

    public Long getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(Long overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public Long getRealRepayAmount() {
        return realRepayAmount;
    }

    public void setRealRepayAmount(Long realRepayAmount) {
        this.realRepayAmount = realRepayAmount;
    }

    public void setCollectionResultNote(String collectionResultNote) {
        this.collectionResultNote = collectionResultNote;
    }

    public String getCollectionResultNote() {
        return collectionResultNote;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

}
