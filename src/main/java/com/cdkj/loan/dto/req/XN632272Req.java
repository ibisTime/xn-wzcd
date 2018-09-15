package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632272Req {

    // 编号
    @NotBlank
    private String code;

    // 作废收款账号编号
    @NotBlank
    private String zfSkBankcardCode;

    // 作废收款金额
    @NotBlank
    private String zfSkAmount;

    // 作废收款时间
    @NotBlank
    private String zfSkReceiptDatetime;

    // 备注
    private String zfFinanceRemark;

    // 操作人
    @NotBlank
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getZfFinanceRemark() {
        return zfFinanceRemark;
    }

    public void setZfFinanceRemark(String zfFinanceRemark) {
        this.zfFinanceRemark = zfFinanceRemark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZfSkBankcardCode() {
        return zfSkBankcardCode;
    }

    public void setZfSkBankcardCode(String zfSkBankcardCode) {
        this.zfSkBankcardCode = zfSkBankcardCode;
    }

    public String getZfSkAmount() {
        return zfSkAmount;
    }

    public void setZfSkAmount(String zfSkAmount) {
        this.zfSkAmount = zfSkAmount;
    }

    public String getZfSkReceiptDatetime() {
        return zfSkReceiptDatetime;
    }

    public void setZfSkReceiptDatetime(String zfSkReceiptDatetime) {
        this.zfSkReceiptDatetime = zfSkReceiptDatetime;
    }

}
