package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630583Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 有关公告时间
    @NotBlank
    private String noticeDatetime;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getNoticeDatetime() {
        return noticeDatetime;
    }

    public void setNoticeDatetime(String noticeDatetime) {
        this.noticeDatetime = noticeDatetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
