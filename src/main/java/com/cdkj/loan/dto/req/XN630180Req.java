package com.cdkj.loan.dto.req;

/**
 * 确认退客户垫资款
 * @author: jiafr 
 * @since: 2018年6月9日 下午10:01:22 
 * @history:
 */
public class XN630180Req {

    // 准入单编号
    private String code;

    // 退款金额
    private String back_advance_amount;

    // 收款账号
    private String back_advance_account;

    // 开户行
    private String back_advance_open_bank;

    // 开户支行
    private String back_advance_subbranch;

    // 水单
    private String back_advance_water_bill;

    // 更新人
    private String updater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBack_advance_amount() {
        return back_advance_amount;
    }

    public void setBack_advance_amount(String back_advance_amount) {
        this.back_advance_amount = back_advance_amount;
    }

    public String getBack_advance_account() {
        return back_advance_account;
    }

    public void setBack_advance_account(String back_advance_account) {
        this.back_advance_account = back_advance_account;
    }

    public String getBack_advance_open_bank() {
        return back_advance_open_bank;
    }

    public void setBack_advance_open_bank(String back_advance_open_bank) {
        this.back_advance_open_bank = back_advance_open_bank;
    }

    public String getBack_advance_subbranch() {
        return back_advance_subbranch;
    }

    public void setBack_advance_subbranch(String back_advance_subbranch) {
        this.back_advance_subbranch = back_advance_subbranch;
    }

    public String getBack_advance_water_bill() {
        return back_advance_water_bill;
    }

    public void setBack_advance_water_bill(String back_advance_water_bill) {
        this.back_advance_water_bill = back_advance_water_bill;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
