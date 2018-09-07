package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 征信银行卡变更记录
* @author: CYunlai 
* @since: 2018-09-07 19:36:43
* @history:
*/
public class CreditChangeRecord extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private int id;

    // 现征信编号
    private String nowCreditCode;

    // 原征信编号
    private String rawCreditCode;

    // 现贷款银行编号
    private String nowLoanBankCode;

    // 原贷款银行编号
    private String rawLoanBankCode;

    // 更新人
    private String operator;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*----------辅助字段-----------*/
    // 现贷款银行名称
    private String nowLoanBankName;

    // 原贷款银行名称
    private String rawLoanBankName;

    public String getNowLoanBankName() {
        return nowLoanBankName;
    }

    public void setNowLoanBankName(String nowLoanBankName) {
        this.nowLoanBankName = nowLoanBankName;
    }

    public String getRawLoanBankName() {
        return rawLoanBankName;
    }

    public void setRawLoanBankName(String rawLoanBankName) {
        this.rawLoanBankName = rawLoanBankName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNowCreditCode(String nowCreditCode) {
        this.nowCreditCode = nowCreditCode;
    }

    public String getNowCreditCode() {
        return nowCreditCode;
    }

    public void setRawCreditCode(String rawCreditCode) {
        this.rawCreditCode = rawCreditCode;
    }

    public String getRawCreditCode() {
        return rawCreditCode;
    }

    public void setNowLoanBankCode(String nowLoanBankCode) {
        this.nowLoanBankCode = nowLoanBankCode;
    }

    public String getNowLoanBankCode() {
        return nowLoanBankCode;
    }

    public void setRawLoanBankCode(String rawLoanBankCode) {
        this.rawLoanBankCode = rawLoanBankCode;
    }

    public String getRawLoanBankCode() {
        return rawLoanBankCode;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
