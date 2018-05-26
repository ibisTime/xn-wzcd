package com.cdkj.loan.dto.req;

/**
 * 录入银行征信结果
 * @author: jiafr 
 * @since: 2018年5月25日 下午5:19:23 
 * @history:
 */
public class XN632111ReqChild {

    // 征信人员编号
    private String code;

    // 贷款抵押笔数
    private String dkdyCount;

    // 贷款抵押贷款余额
    private String dkdyAmount;

    // 贷款抵押近两年逾期次数
    private String dkdy2yearOverTimes;

    // 贷款抵押最高逾期金额
    private String dkdyMaxOverAmount;

    // 贷款抵押当前逾期金额
    private String dkdyCurrentOverAmount;

    // 贷款抵押近6个月平均月还
    private String dkdy6monthAvgAmount;

    // 贷款信用未结清贷款笔数
    private String hkxyUnsettleCount;

    // 贷款信用未结清贷款余额
    private String hkxyUnsettleAmount;

    // 贷款信用近两年逾期次数
    private String hkxy2yearOverTimes;

    // 贷款信用单月最高逾期金额
    private String hkxyMonthMaxOverAmount;

    // 贷款信用当前逾期金额
    private String hkxy6monthAvgAmount;

    // 贷款信用近6个月平均月还
    private String hkxyCurrentOverAmount;

    // 信用卡张数
    private String xykCount;

    // 信用卡授信总额
    private String xykCreditAmount;

    // 信用卡近6个月使用额
    private String xyk6monthUseAmount;

    // 信用卡近两年逾期次数
    private String xyk2yearOverTimes;

    // 信用卡单月最高逾期金额
    private String xykMonthMaxOverAmount;

    // 信用卡当前逾期金额
    private String xykCurrentOverAmount;

    // 对外担保笔数
    private String outGuaranteesCount;

    // 对外担保余额
    private String outGuaranteesAmount;

    // 对外担保备注
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

    public String getDkdy2yearOverTimes() {
        return dkdy2yearOverTimes;
    }

    public void setDkdy2yearOverTimes(String dkdy2yearOverTimes) {
        this.dkdy2yearOverTimes = dkdy2yearOverTimes;
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

    public String getDkdy6monthAvgAmount() {
        return dkdy6monthAvgAmount;
    }

    public void setDkdy6monthAvgAmount(String dkdy6monthAvgAmount) {
        this.dkdy6monthAvgAmount = dkdy6monthAvgAmount;
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

    public String getHkxy2yearOverTimes() {
        return hkxy2yearOverTimes;
    }

    public void setHkxy2yearOverTimes(String hkxy2yearOverTimes) {
        this.hkxy2yearOverTimes = hkxy2yearOverTimes;
    }

    public String getHkxyMonthMaxOverAmount() {
        return hkxyMonthMaxOverAmount;
    }

    public void setHkxyMonthMaxOverAmount(String hkxyMonthMaxOverAmount) {
        this.hkxyMonthMaxOverAmount = hkxyMonthMaxOverAmount;
    }

    public String getHkxy6monthAvgAmount() {
        return hkxy6monthAvgAmount;
    }

    public void setHkxy6monthAvgAmount(String hkxy6monthAvgAmount) {
        this.hkxy6monthAvgAmount = hkxy6monthAvgAmount;
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

    public String getXyk6monthUseAmount() {
        return xyk6monthUseAmount;
    }

    public void setXyk6monthUseAmount(String xyk6monthUseAmount) {
        this.xyk6monthUseAmount = xyk6monthUseAmount;
    }

    public String getXyk2yearOverTimes() {
        return xyk2yearOverTimes;
    }

    public void setXyk2yearOverTimes(String xyk2yearOverTimes) {
        this.xyk2yearOverTimes = xyk2yearOverTimes;
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
