package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 执行结果录入
 * @author: silver 
 * @since: 2018年6月16日 下午3:36:13 
 * @history:
 */
public class XN630562Req {
    // 编号
    @NotBlank
    private String repayBizCode;

    // 执行结果
    @NotBlank
    private String exeResult;

    // 备注
    private String remark;

    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
