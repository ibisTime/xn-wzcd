package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 返点明细表
* @author: jiafr 
* @since: 2018-06-16 14:16:05
* @history:
*/
public class RepointDetail extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型（1正常数据2发票不匹配产生的新数据）
    private String type;

    // 返点编号
    private String repointCode;

    // 业务公司编号
    private String companyCode;

    // 业务公司名称
    private String companyName;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String userName;

    // 身份证号
    private String idNo;

    // 汽车经销商编号
    private String carDealerCode;

    // 汽车经销商名称
    private String carDealerName;

    // 车辆型号
    private String carType;

    // 贷款金额
    private Long loanAmount;

    // 银行实际利率(预算单里的综合利率)
    private Double bankRate;

    // 基准利率
    private Double benchmarkRate;

    // 服务费
    private Long fee;

    // 用款用途（1应退按揭款2协议内返点3协议外返点）
    private String useMoneyPurpose;

    // 返点金额
    private Long repointAmount;

    // 收款账号编号（协议内返点）
    private String accountCode;

    // 收款账号(协议外返点手填)
    private String accountNo;

    // 收款开户行名称(协议外返点手填)
    private String openBankName;

    // 收款户名(协议外返点手填)
    private String accountName;

    // 节点(0待制单1已制单待打款2已打款)
    private String curNodeCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRepointCode() {
        return repointCode;
    }

    public void setRepointCode(String repointCode) {
        this.repointCode = repointCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getBankRate() {
        return bankRate;
    }

    public void setBankRate(Double bankRate) {
        this.bankRate = bankRate;
    }

    public Double getBenchmarkRate() {
        return benchmarkRate;
    }

    public void setBenchmarkRate(Double benchmarkRate) {
        this.benchmarkRate = benchmarkRate;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public Long getRepointAmount() {
        return repointAmount;
    }

    public void setRepointAmount(Long repointAmount) {
        this.repointAmount = repointAmount;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
