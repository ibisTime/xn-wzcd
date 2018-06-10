package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 清欠催收部申请拖车
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:34 
 * @history:
 */
public class XN630555Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 拖车申请金额
    @NotBlank
    private String tsCarAmount;

    // 拖车收款账号
    @NotBlank
    private String tsBankcardNumber;

    // 拖车开户行
    @NotBlank
    private String tsBankName;

    // 拖车开户支行
    @NotBlank
    private String tsSubbranch;

    // 拖车申请说明
    @NotBlank
    private String tcApplyNote;

    // 最近修改人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTsCarAmount() {
        return tsCarAmount;
    }

    public void setTsCarAmount(String tsCarAmount) {
        this.tsCarAmount = tsCarAmount;
    }

    public String getTsBankName() {
        return tsBankName;
    }

    public void setTsBankName(String tsBankName) {
        this.tsBankName = tsBankName;
    }

    public String getTsSubbranch() {
        return tsSubbranch;
    }

    public void setTsSubbranch(String tsSubbranch) {
        this.tsSubbranch = tsSubbranch;
    }

    public String getTsBankcardNumber() {
        return tsBankcardNumber;
    }

    public void setTsBankcardNumber(String tsBankcardNumber) {
        this.tsBankcardNumber = tsBankcardNumber;
    }

    public String getTcApplyNote() {
        return tcApplyNote;
    }

    public void setTcApplyNote(String tcApplyNote) {
        this.tcApplyNote = tcApplyNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
