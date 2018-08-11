package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 银行返佣
* @author: jiafr 
* @since: 2018-08-10 14:19:23
* @history:
*/
public class BankRepoint extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 客户姓名
    private String customerName;

    // 汽车经销商编号
    private String carDealerCode;

    // 贷款银行编号
    private String loanBankCode;

    // 业务公司编号
    private String companyCode;

    // 结算费率
    private Double settleRate;

    // 结算金额
    private Long settleAmount;

    // 推荐服务费
    private Long recommendFee;

    // 风险代理费
    private Long riskAgentFee;

    // 应交税费
    private Long tax;

    // 到账日期
    private Date settleDatetime;

    // 我司留存利率
    private Double companySaveRate;

    // 我司留存返佣
    private Long companySaveRepoint;

    // 代收代付返佣
    private Long agentRepoint;

    // 退回金额
    private Long sendBackAmount;

    // 银行回单（退回）
    private String billPdf;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 节点
    private String curNodeCode;

    /**************db properties*************/

    // 银行放款时间
    private Date bankFkDatetime;

    // 汽车经销商名称
    private String carDealerName;

    // 业务员姓名
    private String saleUserName;

    // 购车途径
    private String shopWay;

    // 贷款金额
    private Long loanAmount;

    // 服务费
    private Long fee;

    // 贷款银行名称
    private String loanBankName;

    // 利率类型
    private String rateType;

    // 银行利率
    private Double bankRate;

    // 贷款周期
    private Integer loanPeriods;

    // 公司名称
    private String companyName;

    // 银行基准利率(基准利率随着贷款周期取)
    private Double bankBenchmarkRate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Double getSettleRate() {
        return settleRate;
    }

    public void setSettleRate(Double settleRate) {
        this.settleRate = settleRate;
    }

    public Long getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Long settleAmount) {
        this.settleAmount = settleAmount;
    }

    public Long getRecommendFee() {
        return recommendFee;
    }

    public void setRecommendFee(Long recommendFee) {
        this.recommendFee = recommendFee;
    }

    public Long getRiskAgentFee() {
        return riskAgentFee;
    }

    public void setRiskAgentFee(Long riskAgentFee) {
        this.riskAgentFee = riskAgentFee;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Date getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(Date settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public Double getCompanySaveRate() {
        return companySaveRate;
    }

    public void setCompanySaveRate(Double companySaveRate) {
        this.companySaveRate = companySaveRate;
    }

    public Long getCompanySaveRepoint() {
        return companySaveRepoint;
    }

    public void setCompanySaveRepoint(Long companySaveRepoint) {
        this.companySaveRepoint = companySaveRepoint;
    }

    public Long getAgentRepoint() {
        return agentRepoint;
    }

    public void setAgentRepoint(Long agentRepoint) {
        this.agentRepoint = agentRepoint;
    }

    public Long getSendBackAmount() {
        return sendBackAmount;
    }

    public void setSendBackAmount(Long sendBackAmount) {
        this.sendBackAmount = sendBackAmount;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public String getShopWay() {
        return shopWay;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Double getBankRate() {
        return bankRate;
    }

    public void setBankRate(Double bankRate) {
        this.bankRate = bankRate;
    }

    public Integer getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(Integer loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getBankBenchmarkRate() {
        return bankBenchmarkRate;
    }

    public void setBankBenchmarkRate(Double bankBenchmarkRate) {
        this.bankBenchmarkRate = bankBenchmarkRate;
    }

}
