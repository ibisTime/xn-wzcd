package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN632301Req {

    @NotBlank
    private String code;// 逾期名单编号

    private String repayBizCode;// 还款业务编号

    private List<XN632301Res> repayBizList;// 还款业务编号

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<XN632301Res> getRepayBizList() {
        return repayBizList;
    }

    public void setRepayBizList(List<XN632301Res> repayBizList) {
        this.repayBizList = repayBizList;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
