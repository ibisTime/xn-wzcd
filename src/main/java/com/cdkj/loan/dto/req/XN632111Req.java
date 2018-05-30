package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入征信结果
 * @author: jiafr 
 * @since: 2018年5月24日 下午8:57:22 
 * @history:
 */
public class XN632111Req {

    // 征信单编号
    @NotBlank
    private String creditCode;

    // 操作人
    @NotBlank
    private String operator;

    // 征信结果
    private List<XN632111ReqCreditUser> creditResult;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public List<XN632111ReqCreditUser> getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(List<XN632111ReqCreditUser> creditResult) {
        this.creditResult = creditResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
