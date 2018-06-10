package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 清欠催收部审核
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:34 
 * @history:
 */
public class XN630550Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 应扣除的履约保证金
    @NotBlank
    private String cutLyDeposit;

    // 最近修改人
    @NotBlank
    private String operator;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCutLyDeposit() {
        return cutLyDeposit;
    }

    public void setCutLyDeposit(String cutLyDeposit) {
        this.cutLyDeposit = cutLyDeposit;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
