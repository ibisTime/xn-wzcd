package com.cdkj.loan.dto.req;

public class XN632112ReqChild {

    // 征信人员编号
    private String code;

    // 姓名
    private String userName;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 身份证号
    private String idNo;

    // 手机号
    private String mobile;

    // 户籍地
    private String birthAddress;

    // 身份证正面
    private String idNoFront;

    // 身份证反面
    private String idNoReverse;

    // 征信查询授权书
    private String authPdf;

    // 面签照片
    private String interviewPic;

    // 贷款抵押笔数
    private String dkdyCount;

    // 贷款抵押贷款余额
    private String dkdyAmount;

    // 贷款抵押近两年逾期次数
    private String dkdy2YearOverTimes;

    // 贷款抵押最高逾期金额
    private String dkdyMaxOverAmount;

    // 贷款抵押当前逾期金额
    private String dkdyCurrentOverAmount;

    // 贷款抵押近6个月平均月还
    private String dkdy6MonthAvgAmount;

    // 贷款信用未结清贷款笔数
    private String hkxyUnsettleCount;

    // 贷款信用未结清贷款余额
    private String hkxyUnsettleAmount;

    // 贷款信用近两年逾期次数
    private String hkxy2YearOverTimes;

    // 贷款信用单月最高逾期金额
    private String hkxyMonthMaxOverAmount;

    // 贷款信用当前逾期金额
    private String hkxy6MonthAvgAmount;

    // 贷款信用近6个月平均月还
    private String hkxyCurrentOverAmount;

    // 信用卡张数
    private String xykCount;

    // 信用卡授信总额
    private String xykCreditAmount;

    // 信用卡近6个月使用额
    private String xyk6MonthUseAmount;

    // 信用卡近两年逾期次数
    private String xyk2YearOverTimes;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDkdyCount() {
        return dkdyCount;
    }

    public void setDkdyCount(String dkdyCount) {
        this.dkdyCount = dkdyCount;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
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

}
