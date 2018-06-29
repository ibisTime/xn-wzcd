package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改贷款金额计算关联数据
 * @author: jiafr 
 * @since: 2018年6月28日 下午9:42:13 
 * @history:
 */
public class XN632234Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 贷款金额（修改的）
    @NotBlank
    private String loanAmount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

}
