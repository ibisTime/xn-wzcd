package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630580Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 执行申请人
    @NotBlank
    private String exeApplyUser;

    // 被执行人
    @NotBlank
    private String beExeUser;

    // 申请标的额(申请执行节点时必填)
    private String executeMarkAmount;

    // 恢复时间(恢复执行节点时必填)
    private String recoveryDatetime;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getRecoveryDatetime() {
        return recoveryDatetime;
    }

    public void setRecoveryDatetime(String recoveryDatetime) {
        this.recoveryDatetime = recoveryDatetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getExeApplyUser() {
        return exeApplyUser;
    }

    public void setExeApplyUser(String exeApplyUser) {
        this.exeApplyUser = exeApplyUser;
    }

    public String getBeExeUser() {
        return beExeUser;
    }

    public void setBeExeUser(String beExeUser) {
        this.beExeUser = beExeUser;
    }

    public String getExecuteMarkAmount() {
        return executeMarkAmount;
    }

    public void setExecuteMarkAmount(String executeMarkAmount) {
        this.executeMarkAmount = executeMarkAmount;
    }

}
