package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 征信人员
 * @author: jiafr 
 * @since: 2018年5月24日 下午9:32:23 
 * @history:
 */
public class CreditUser extends ABaseDO {

    // 编号
    private String code;

    // 征信单编号
    private String creditCode;

    // 姓名
    private String userName;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 身份证号
    private String idNo;

    // 手机号
    private Integer mobile;

    // 身份证正面
    private String idNoFront;

    // 身份证反面
    private String idNoReverse;

    // 征信查询授权书
    private String authPdf;

    // 面签照片
    private String interviewPic;

    // 贷款抵押笔数
    private Integer dkdyCount;

    // 贷款抵押贷款余额
    private Long dkdyAmount;

    // 贷款抵押近两年逾期次数
    private Integer dkdy2YearOverTimes;

    // 贷款抵押最高逾期金额
    private Long dkdyMaxOverAmount;

    // 贷款抵押当前逾期金额
    private Long dkdyCurrentOverAmount;

    // 贷款抵押近6个月平均月还
    private Long dkdy6monthAvgAmount;

    // 贷款信用未结清贷款笔数
    private Integer hkxyUnsettleCount;

    // 贷款信用未结清贷款余额
    private Long hkxyUnsettleAmount;

    // 贷款信用近两年逾期次数
    private Integer hkxy2YearOverTimes;

    // 贷款信用单月最高逾期金额
    private Long hkxyMonthMaxOverAmount;

    // 贷款信用当前逾期金额
    private Long hkxyCurrentOverAmount;

    // 贷款信用近6个月平均月还
    private Long hkxy6MonthAvgAmount;

    // 信用卡张数
    private Integer xykCount;

    // 信用卡授信总额
    private Long xykCreditAmount;

    // 信用卡近6个月使用额
    private Long xyk6MonthUseAmount;

    // 信用卡近两年逾期次数
    private Integer xyk2YearOverTimes;

    // 信用卡单月最高逾期金额
    private Long xykMonthMaxOverAmount;

    // 信用卡当前逾期金额
    private Long xykCurrentOverAmount;

    // 对外担保笔数
    private Integer outGuaranteesCount;

    // 对外担保余额
    private Long outGuaranteesAmount;

    // 对外担保备注
    private String outGuaranteesRemark;

    // 月收入
    private String monthIncome;

    // 结息
    private String settleInterest;

    // 余额
    private String balance;

    // 流水是否体现月收入
    private String jourShowIncome;

    // ***********db properties****************

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLoanRole() {
        return loanRole;
    }

    public void setLoanRole(String loanRole) {
        this.loanRole = loanRole;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getIdNoFront() {
        return idNoFront;
    }

    public void setIdNoFront(String idNoFront) {
        this.idNoFront = idNoFront;
    }

    public String getIdNoReverse() {
        return idNoReverse;
    }

    public void setIdNoReverse(String idNoReverse) {
        this.idNoReverse = idNoReverse;
    }

    public String getAuthPdf() {
        return authPdf;
    }

    public void setAuthPdf(String authPdf) {
        this.authPdf = authPdf;
    }

    public String getInterviewPic() {
        return interviewPic;
    }

    public void setInterviewPic(String interviewPic) {
        this.interviewPic = interviewPic;
    }

    public Integer getDkdyCount() {
        return dkdyCount;
    }

    public void setDkdyCount(Integer dkdyCount) {
        this.dkdyCount = dkdyCount;
    }

    public Long getDkdyAmount() {
        return dkdyAmount;
    }

    public void setDkdyAmount(Long dkdyAmount) {
        this.dkdyAmount = dkdyAmount;
    }

    public Integer getDkdy2YearOverTimes() {
        return dkdy2YearOverTimes;
    }

    public void setDkdy2YearOverTimes(Integer dkdy2YearOverTimes) {
        this.dkdy2YearOverTimes = dkdy2YearOverTimes;
    }

    public Long getDkdyMaxOverAmount() {
        return dkdyMaxOverAmount;
    }

    public void setDkdyMaxOverAmount(Long dkdyMaxOverAmount) {
        this.dkdyMaxOverAmount = dkdyMaxOverAmount;
    }

    public Long getDkdyCurrentOverAmount() {
        return dkdyCurrentOverAmount;
    }

    public void setDkdyCurrentOverAmount(Long dkdyCurrentOverAmount) {
        this.dkdyCurrentOverAmount = dkdyCurrentOverAmount;
    }

    public Long getDkdy6monthAvgAmount() {
        return dkdy6monthAvgAmount;
    }

    public void setDkdy6monthAvgAmount(Long dkdy6monthAvgAmount) {
        this.dkdy6monthAvgAmount = dkdy6monthAvgAmount;
    }

    public Integer getHkxyUnsettleCount() {
        return hkxyUnsettleCount;
    }

    public void setHkxyUnsettleCount(Integer hkxyUnsettleCount) {
        this.hkxyUnsettleCount = hkxyUnsettleCount;
    }

    public Long getHkxyUnsettleAmount() {
        return hkxyUnsettleAmount;
    }

    public void setHkxyUnsettleAmount(Long hkxyUnsettleAmount) {
        this.hkxyUnsettleAmount = hkxyUnsettleAmount;
    }

    public Integer getHkxy2YearOverTimes() {
        return hkxy2YearOverTimes;
    }

    public void setHkxy2YearOverTimes(Integer hkxy2YearOverTimes) {
        this.hkxy2YearOverTimes = hkxy2YearOverTimes;
    }

    public Long getHkxyMonthMaxOverAmount() {
        return hkxyMonthMaxOverAmount;
    }

    public void setHkxyMonthMaxOverAmount(Long hkxyMonthMaxOverAmount) {
        this.hkxyMonthMaxOverAmount = hkxyMonthMaxOverAmount;
    }

    public Long getHkxyCurrentOverAmount() {
        return hkxyCurrentOverAmount;
    }

    public void setHkxyCurrentOverAmount(Long hkxyCurrentOverAmount) {
        this.hkxyCurrentOverAmount = hkxyCurrentOverAmount;
    }

    public Long getHkxy6MonthAvgAmount() {
        return hkxy6MonthAvgAmount;
    }

    public void setHkxy6MonthAvgAmount(Long hkxy6MonthAvgAmount) {
        this.hkxy6MonthAvgAmount = hkxy6MonthAvgAmount;
    }

    public Integer getXykCount() {
        return xykCount;
    }

    public void setXykCount(Integer xykCount) {
        this.xykCount = xykCount;
    }

    public Long getXykCreditAmount() {
        return xykCreditAmount;
    }

    public void setXykCreditAmount(Long xykCreditAmount) {
        this.xykCreditAmount = xykCreditAmount;
    }

    public Long getXyk6MonthUseAmount() {
        return xyk6MonthUseAmount;
    }

    public void setXyk6MonthUseAmount(Long xyk6MonthUseAmount) {
        this.xyk6MonthUseAmount = xyk6MonthUseAmount;
    }

    public Integer getXyk2YearOverTimes() {
        return xyk2YearOverTimes;
    }

    public void setXyk2YearOverTimes(Integer xyk2YearOverTimes) {
        this.xyk2YearOverTimes = xyk2YearOverTimes;
    }

    public Long getXykMonthMaxOverAmount() {
        return xykMonthMaxOverAmount;
    }

    public void setXykMonthMaxOverAmount(Long xykMonthMaxOverAmount) {
        this.xykMonthMaxOverAmount = xykMonthMaxOverAmount;
    }

    public Long getXykCurrentOverAmount() {
        return xykCurrentOverAmount;
    }

    public void setXykCurrentOverAmount(Long xykCurrentOverAmount) {
        this.xykCurrentOverAmount = xykCurrentOverAmount;
    }

    public Integer getOutGuaranteesCount() {
        return outGuaranteesCount;
    }

    public void setOutGuaranteesCount(Integer outGuaranteesCount) {
        this.outGuaranteesCount = outGuaranteesCount;
    }

    public Long getOutGuaranteesAmount() {
        return outGuaranteesAmount;
    }

    public void setOutGuaranteesAmount(Long outGuaranteesAmount) {
        this.outGuaranteesAmount = outGuaranteesAmount;
    }

    public String getOutGuaranteesRemark() {
        return outGuaranteesRemark;
    }

    public void setOutGuaranteesRemark(String outGuaranteesRemark) {
        this.outGuaranteesRemark = outGuaranteesRemark;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getSettleInterest() {
        return settleInterest;
    }

    public void setSettleInterest(String settleInterest) {
        this.settleInterest = settleInterest;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getJourShowIncome() {
        return jourShowIncome;
    }

    public void setJourShowIncome(String jourShowIncome) {
        this.jourShowIncome = jourShowIncome;
    }

}
