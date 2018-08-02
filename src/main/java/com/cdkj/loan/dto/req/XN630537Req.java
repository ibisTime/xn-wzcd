package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN630537Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotBlank
    private String collectionWay;// 催收方式

    @NotBlank
    private String collectionTarget;// 催收对象列表

    @NotBlank
    private String collectionProcess;// 催收过程

    @NotBlank
    private String collectionWish;// 客户意愿

    @NotBlank
    private String collectionResult;// 催收结果

    private String depositIsProvide;// 是否提供押金

    private String overdueDeposit;// 再次逾期保证金

    private String realRepayAmount;// 实际还款金额(部分)

    @NotBlank
    private String collectionNote;// 备注

    private List<XN630535Req> costList; // 费用清单列表

    @NotBlank
    private String operator;// 操作人

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCollectionWay() {
        return collectionWay;
    }

    public void setCollectionWay(String collectionWay) {
        this.collectionWay = collectionWay;
    }

    public String getCollectionTarget() {
        return collectionTarget;
    }

    public void setCollectionTarget(String collectionTarget) {
        this.collectionTarget = collectionTarget;
    }

    public String getCollectionProcess() {
        return collectionProcess;
    }

    public void setCollectionProcess(String collectionProcess) {
        this.collectionProcess = collectionProcess;
    }

    public String getCollectionWish() {
        return collectionWish;
    }

    public void setCollectionWish(String collectionWish) {
        this.collectionWish = collectionWish;
    }

    public String getCollectionResult() {
        return collectionResult;
    }

    public void setCollectionResult(String collectionResult) {
        this.collectionResult = collectionResult;
    }

    public String getDepositIsProvide() {
        return depositIsProvide;
    }

    public void setDepositIsProvide(String depositIsProvide) {
        this.depositIsProvide = depositIsProvide;
    }

    public String getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(String overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public String getRealRepayAmount() {
        return realRepayAmount;
    }

    public void setRealRepayAmount(String realRepayAmount) {
        this.realRepayAmount = realRepayAmount;
    }

    public String getCollectionNote() {
        return collectionNote;
    }

    public void setCollectionNote(String collectionNote) {
        this.collectionNote = collectionNote;
    }

    public List<XN630535Req> getCostList() {
        return costList;
    }

    public void setCostList(List<XN630535Req> costList) {
        this.costList = costList;
    }
}
