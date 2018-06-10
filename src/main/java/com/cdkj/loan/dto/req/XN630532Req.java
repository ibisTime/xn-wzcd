package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN630532Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotBlank
    private String dealResult; // 1=交保证金进绿名单 2=申请拖车进红名单 3=代偿进黄名单

    private String overdueDeposit;// 再次逾期保证金

    @NotBlank
    private String overdueDepositWay;// 再次逾期保证金收取方式

    private String remark;// 备注

    private List<XN630535Req> costList; // 费用清单列表

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(String overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public String getOverdueDepositWay() {
        return overdueDepositWay;
    }

    public void setOverdueDepositWay(String overdueDepositWay) {
        this.overdueDepositWay = overdueDepositWay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<XN630535Req> getCostList() {
        return costList;
    }

    public void setCostList(List<XN630535Req> costList) {
        this.costList = costList;
    }

}
