package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN630532Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotBlank
    private String collectionResult;// 催收结果

    @NotBlank
    private String depositIsProvide;// 是否提供押金

    private String overdueDeposit;// 再次逾期保证金

    private String realRepayAmount;// 实际还款金额(部分还款)

    private String collectionResultNote;// 催收结果说明

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

    public String getCollectionResultNote() {
        return collectionResultNote;
    }

    public void setCollectionResultNote(String collectionResultNote) {
        this.collectionResultNote = collectionResultNote;
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

    public List<XN630535Req> getCostList() {
        return costList;
    }

    public void setCostList(List<XN630535Req> costList) {
        this.costList = costList;
    }
}
