package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 申请收车
 * @author: silver 
 * @since: 2018年6月16日 下午2:48:11 
 * @history:
 */
public class XN630550Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 是否典当行赎回 1 是 0 否
    @NotBlank
    private String pawnshopIsRedeem;

    // 典当行名称
    private String pawnshopName;

    // 典当行赎金小写
    private String ransom;

    // 收车申请费用
    @NotBlank
    private String tsCarAmount;

    // 收车人姓名
    @NotBlank
    private String tsUserName;

    // 收车收款账号
    private String tsBankcardNumber;

    // 收车开户行
    private String tsBankName;

    // 收车开户支行
    private String tsSubbranch;

    // 收车申请说明
    private String tcApplyNote;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPawnshopIsRedeem() {
        return pawnshopIsRedeem;
    }

    public void setPawnshopIsRedeem(String pawnshopIsRedeem) {
        this.pawnshopIsRedeem = pawnshopIsRedeem;
    }

    public String getPawnshopName() {
        return pawnshopName;
    }

    public void setPawnshopName(String pawnshopName) {
        this.pawnshopName = pawnshopName;
    }

    public String getRansom() {
        return ransom;
    }

    public void setRansom(String ransom) {
        this.ransom = ransom;
    }

    public String getTsCarAmount() {
        return tsCarAmount;
    }

    public void setTsCarAmount(String tsCarAmount) {
        this.tsCarAmount = tsCarAmount;
    }

    public String getTsBankcardNumber() {
        return tsBankcardNumber;
    }

    public void setTsBankcardNumber(String tsBankcardNumber) {
        this.tsBankcardNumber = tsBankcardNumber;
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

    public String getTcApplyNote() {
        return tcApplyNote;
    }

    public void setTcApplyNote(String tcApplyNote) {
        this.tcApplyNote = tcApplyNote;
    }

    public String getTsUserName() {
        return tsUserName;
    }

    public void setTsUserName(String tsUserName) {
        this.tsUserName = tsUserName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
