package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入银行征信结果
 * @author: jiafr 
 * @since: 2018年5月25日 下午5:19:23 
 * @history:
 */
public class XN632111ReqChild {

    // 征信人员编号
    @NotBlank
    private String code;

    // 贷款抵押笔数
    @NotBlank
    private String dkdyCount;

    // 贷款抵押贷款余额
    @NotBlank
    private String dkdyAmount;

    // 贷款抵押近两年逾期次数
    @NotBlank
    private String dkdy2YearOverTimes;

    // 贷款抵押最高逾期金额
    @NotBlank
    private String dkdyMaxOverAmount;

    // 贷款抵押当前逾期金额
    @NotBlank
    private String dkdyCurrentOverAmount;

    // 贷款抵押近6个月平均月还
    @NotBlank
    private String dkdy6MonthAvgAmount;

    // 贷款信用未结清贷款笔数
    @NotBlank
    private String hkxyUnsettleCount;

    // 贷款信用未结清贷款余额
    @NotBlank
    private String hkxyUnsettleAmount;

    // 贷款信用近两年逾期次数
    @NotBlank
    private String hkxy2YearOverTimes;

    // 贷款信用单月最高逾期金额
    @NotBlank
    private String hkxyMonthMaxOverAmount;

    // 贷款信用当前逾期金额
    @NotBlank
    private String hkxy6MonthAvgAmount;

    // 贷款信用近6个月平均月还
    @NotBlank
    private String hkxyCurrentOverAmount;

    // 信用卡张数
    @NotBlank
    private String xykCount;

    // 信用卡授信总额
    @NotBlank
    private String xykCreditAmount;

    // 信用卡近6个月使用额
    @NotBlank
    private String xyk6MonthUseAmount;

    // 信用卡近两年逾期次数
    @NotBlank
    private String xyk2YearOverTimes;

    // 信用卡单月最高逾期金额
    @NotBlank
    private String xykMonthMaxOverAmount;

    // 信用卡当前逾期金额
    @NotBlank
    private String xykCurrentOverAmount;

    // 对外担保笔数
    @NotBlank
    private String outGuaranteesCount;

    // 对外担保余额
    @NotBlank
    private String outGuaranteesAmount;

    // 对外担保备注
    @NotBlank
    private String outGuaranteesRemark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDkdyCount() {
        return dkdyCount;
    }

    public void setDkdyCount(String dkdyCount) {
        this.dkdyCount = dkdyCount;
    }

    public String getDkdyAmount() {
        return dkdyAmount;
    }

    public void setDkdyAmount(String dkdyAmount) {
        this.dkdyAmount = dkdyAmount;
    }

    public String getDkdy2YearOverTimes() {
        return dkdy2YearOverTimes;
    }

    public void setDkdy2YearOverTimes(String dkdy2YearOverTimes) {
        this.dkdy2YearOverTimes = dkdy2YearOverTimes;
    }

    public String getDkdyMaxOverAmount() {
        return dkdyMaxOverAmount;
    }

    public void setDkdyMaxOverAmount(String dkdyMaxOverAmount) {
        this.dkdyMaxOverAmount = dkdyMaxOverAmount;
    }

    public String getDkdyCurrentOverAmount() {
        return dkdyCurrentOverAmount;
    }

    public void setDkdyCurrentOverAmount(String dkdyCurrentOverAmount) {
        this.dkdyCurrentOverAmount = dkdyCurrentOverAmount;
    }

    public String getDkdy6MonthAvgAmount() {
        return dkdy6MonthAvgAmount;
    }

    public void setDkdy6MonthAvgAmount(String dkdy6MonthAvgAmount) {
        this.dkdy6MonthAvgAmount = dkdy6MonthAvgAmount;
    }

    public String getHkxyUnsettleCount() {
        return hkxyUnsettleCount;
    }

    public void setHkxyUnsettleCount(String hkxyUnsettleCount) {
        this.hkxyUnsettleCount = hkxyUnsettleCount;
    }

    public String getHkxyUnsettleAmount() {
        return hkxyUnsettleAmount;
    }

    public void setHkxyUnsettleAmount(String hkxyUnsettleAmount) {
        this.hkxyUnsettleAmount = hkxyUnsettleAmount;
    }

    public String getHkxy2YearOverTimes() {
        return hkxy2YearOverTimes;
    }

    public void setHkxy2YearOverTimes(String hkxy2YearOverTimes) {
        this.hkxy2YearOverTimes = hkxy2YearOverTimes;
    }

    public String getHkxyMonthMaxOverAmount() {
        return hkxyMonthMaxOverAmount;
    }

    public void setHkxyMonthMaxOverAmount(String hkxyMonthMaxOverAmount) {
        this.hkxyMonthMaxOverAmount = hkxyMonthMaxOverAmount;
    }

    public String getHkxy6MonthAvgAmount() {
        return hkxy6MonthAvgAmount;
    }

    public void setHkxy6MonthAvgAmount(String hkxy6MonthAvgAmount) {
        this.hkxy6MonthAvgAmount = hkxy6MonthAvgAmount;
    }

    public String getHkxyCurrentOverAmount() {
        return hkxyCurrentOverAmount;
    }

    public void setHkxyCurrentOverAmount(String hkxyCurrentOverAmount) {
        this.hkxyCurrentOverAmount = hkxyCurrentOverAmount;
    }

    public String getXykCount() {
        return xykCount;
    }

    public void setXykCount(String xykCount) {
        this.xykCount = xykCount;
    }

    public String getXykCreditAmount() {
        return xykCreditAmount;
    }

    public void setXykCreditAmount(String xykCreditAmount) {
        this.xykCreditAmount = xykCreditAmount;
    }

    public String getXyk6MonthUseAmount() {
        return xyk6MonthUseAmount;
    }

    public void setXyk6MonthUseAmount(String xyk6MonthUseAmount) {
        this.xyk6MonthUseAmount = xyk6MonthUseAmount;
    }

    public String getXyk2YearOverTimes() {
        return xyk2YearOverTimes;
    }

    public void setXyk2YearOverTimes(String xyk2YearOverTimes) {
        this.xyk2YearOverTimes = xyk2YearOverTimes;
    }

    public String getXykMonthMaxOverAmount() {
        return xykMonthMaxOverAmount;
    }

    public void setXykMonthMaxOverAmount(String xykMonthMaxOverAmount) {
        this.xykMonthMaxOverAmount = xykMonthMaxOverAmount;
    }

    public String getXykCurrentOverAmount() {
        return xykCurrentOverAmount;
    }

    public void setXykCurrentOverAmount(String xykCurrentOverAmount) {
        this.xykCurrentOverAmount = xykCurrentOverAmount;
    }

    public String getOutGuaranteesCount() {
        return outGuaranteesCount;
    }

    public void setOutGuaranteesCount(String outGuaranteesCount) {
        this.outGuaranteesCount = outGuaranteesCount;
    }

    public String getOutGuaranteesAmount() {
        return outGuaranteesAmount;
    }

    public void setOutGuaranteesAmount(String outGuaranteesAmount) {
        this.outGuaranteesAmount = outGuaranteesAmount;
    }

    public String getOutGuaranteesRemark() {
        return outGuaranteesRemark;
    }

    public void setOutGuaranteesRemark(String outGuaranteesRemark) {
        this.outGuaranteesRemark = outGuaranteesRemark;
    }

}
