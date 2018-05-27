package com.cdkj.loan.dto.req;

/**
 * 列表查询银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午5:45:35 
 * @history:
 */
public class XN632037Req {
    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 状态
    private String status;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
