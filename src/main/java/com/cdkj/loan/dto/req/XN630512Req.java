package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630512Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String cutLyDeposit;// 扣除违约金额

    // 结清证明
    private String settleAttach;

    // 结清时间
    private String settleDatetime;

    // 是否有押金单
    @NotBlank
    private String isDepositReceipt;

    // 押金单
    private String depositReceipt;

    // 押金单遗失证明
    private String depositReceiptLostProof;

    @NotBlank
    private String refundBankSubbranch; // 退款开户行

    @NotBlank
    private String refundBankRealName; // 退款户名

    // 退款账号
    @NotBlank
    private String refundBankcard;

    // 第二年按公司指定续保
    private String secondCompanyInsurance;

    // 第三年按公司指定续保
    private String thirdCompanyInsurance;

    // 操作人
    @NotBlank
    private String operator;

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

    public String getSettleAttach() {
        return settleAttach;
    }

    public void setSettleAttach(String settleAttach) {
        this.settleAttach = settleAttach;
    }

    public String getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(String settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public String getDepositReceipt() {
        return depositReceipt;
    }

    public void setDepositReceipt(String depositReceipt) {
        this.depositReceipt = depositReceipt;
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

    public String getIsDepositReceipt() {
        return isDepositReceipt;
    }

    public void setIsDepositReceipt(String isDepositReceipt) {
        this.isDepositReceipt = isDepositReceipt;
    }

    public String getDepositReceiptLostProof() {
        return depositReceiptLostProof;
    }

    public void setDepositReceiptLostProof(String depositReceiptLostProof) {
        this.depositReceiptLostProof = depositReceiptLostProof;
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
