package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 征信单
 * @author: jiafr 
 * @since: 2018年5月24日 下午9:26:48 
 * @history:
 */
public class Credit extends ABaseDO {

    // 编号
    private String code;

    // 预算单编号
    private String budgetCode;

    // 业务公司编号
    private String companyCode;

    // 业务员编号
    private String salesmanCode;

    // 申请时间
    private Date applyDatetime;

    // 贷款银行
    private String loanBank;

    // 购车途径
    private String shopWay;

    // 贷款金额
    private String loanAmount;

    // 行驶证正面
    private String xszFront;

    // 行驶证反面
    private String xszReverse;

    // 节点编号
    private String curNodeCode;

    // ****************db properties*******************

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getShopWay() {
        return shopWay;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getXszFront() {
        return xszFront;
    }

    public void setXszFront(String xszFront) {
        this.xszFront = xszFront;
    }

    public String getXszReverse() {
        return xszReverse;
    }

    public void setXszReverse(String xszReverse) {
        this.xszReverse = xszReverse;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

}
