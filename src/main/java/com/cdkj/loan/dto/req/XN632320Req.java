package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代偿申请
 * @author: jiafr 
 * @since: 2018年8月18日 下午7:12:20 
 * @history:
 */
public class XN632320Req {

    @NotBlank
    private String type;// 代偿性质（1月供2剩余贷款金额）

    @NotBlank
    private String amount;// 预算金额

    @NotBlank
    private String bizCode;// 业务编号(还款业务编号)

    @NotBlank
    private String isUrgent;// 是否加急

    @NotBlank
    private String applyUser;// 申请人

    private String applyNote;// 申请说明

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

}
