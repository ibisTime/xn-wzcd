package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 结算单申请
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630570Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 扣除履约保证金
    @NotBlank
    private String cutLyDeposit;

    // 退款开户行
    @NotBlank
    private String refundBankSubbranch;

    // 退款户名
    @NotBlank
    private String refundBankRealName;

    // 退款账号
    @NotBlank
    private String refundBankcard;

    // 第二年按公司指定续保
    private String secondCompanyInsurance;

    // 第三年按公司指定续保
    private String thirdCompanyInsurance;

    // 结清证明
    private String settleAttach;

    // 结清时间
    @NotBlank
    private String settleDatetime;

    // 押金单
    private String depositReceipt;

    // 备注
    private String remark;

    @NotBlank
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

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

    public String getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(String settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public String getRefundBankSubbranch() {
        return refundBankSubbranch;
    }

    public void setRefundBankSubbranch(String refundBankSubbranch) {
        this.refundBankSubbranch = refundBankSubbranch;
    }

    public String getRefundBankRealName() {
        return refundBankRealName;
    }

    public void setRefundBankRealName(String refundBankRealName) {
        this.refundBankRealName = refundBankRealName;
    }

    public String getRefundBankcard() {
        return refundBankcard;
    }

    public void setRefundBankcard(String refundBankcard) {
        this.refundBankcard = refundBankcard;
    }

    public String getSecondCompanyInsurance() {
        return secondCompanyInsurance;
    }

    public void setSecondCompanyInsurance(String secondCompanyInsurance) {
        this.secondCompanyInsurance = secondCompanyInsurance;
    }

    public String getThirdCompanyInsurance() {
        return thirdCompanyInsurance;
    }

    public void setThirdCompanyInsurance(String thirdCompanyInsurance) {
        this.thirdCompanyInsurance = thirdCompanyInsurance;
    }

    public String getSettleAttach() {
        return settleAttach;
    }

    public void setSettleAttach(String settleAttach) {
        this.settleAttach = settleAttach;
    }

    public String getDepositReceipt() {
        return depositReceipt;
    }

    public void setDepositReceipt(String depositReceipt) {
        this.depositReceipt = depositReceipt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
