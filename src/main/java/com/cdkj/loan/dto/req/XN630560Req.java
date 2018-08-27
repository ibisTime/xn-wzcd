package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 司法诉讼
 * @author: silver 
 * @since: 2018年6月16日 下午2:48:11 
 * @history:
 */
public class XN630560Req {
    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 原告
    @NotBlank
    private String plaintiff;

    // 被告
    @NotBlank
    private String defendant;

    // 案款
    @NotBlank
    private String caseFee;

    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
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

    public String getCaseFee() {
        return caseFee;
    }

    public void setCaseFee(String caseFee) {
        this.caseFee = caseFee;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
