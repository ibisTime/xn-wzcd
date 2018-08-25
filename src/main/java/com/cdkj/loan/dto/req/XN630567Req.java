package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630567Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 开庭日期
    @NotBlank
    private String courtDatetime;

    // 开庭地点
    @NotBlank
    private String courtAddress;

    // 经办法官
    @NotBlank
    private String handleJudge;

    // 传票等送达日期
    private String summonsDeliveryTime;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getSummonsDeliveryTime() {
        return summonsDeliveryTime;
    }

    public void setSummonsDeliveryTime(String summonsDeliveryTime) {
        this.summonsDeliveryTime = summonsDeliveryTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCourtDatetime() {
        return courtDatetime;
    }

    public void setCourtDatetime(String courtDatetime) {
        this.courtDatetime = courtDatetime;
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

}
