package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632211Req {

    // 准入单编号
    @NotBlank
    private String code;

    // 信用卡号
    @NotBlank
    private String bankCardNumber;

    // 制卡备注
    private String makeCardRemark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getMakeCardRemark() {
        return makeCardRemark;
    }

    public void setMakeCardRemark(String makeCardRemark) {
        this.makeCardRemark = makeCardRemark;
    }

}
