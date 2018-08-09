package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 重新申请执行
 * @author: CYL 
 * @since: 2018年7月30日 上午10:26:09 
 * @history:
 */
public class XN630561Req {
    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    @NotBlank
    private String operator;

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
