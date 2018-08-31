package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款计划
* @author: haiqingzheng
* @since: 2018年05月01日 18:52:51
* @history:
*/
public class RepayPlan extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关联类型
    private String refType;

    // 关联业务编号
    private String repayBizCode;

    // 借款人编号
    private String userId;

    // 总期数
    private int periods;

    // 当前期数
    private int curPeriods;

    // 还款时间
    private Date repayDatetime;

    // 本期本金
    private Long repayCapital;

    // 本期利息
    private Long repayInterest;

    // 本期还款金额
    private Long repayAmount;

    // 已还金额
    private Long payedAmount;

    // 剩余欠款
    private Long overplusAmount;

    // 逾期金额
    private Long overdueAmount;

    // 节点
    private String curNodeCode;

    // 逾期处理人
    private String overdueHandler;

    // 逾期处理时间
    private Date overdueHandleDatetime;

    // 逾期处理说明
    private String overdueHandleNote;

    // 清收费用总额
    private Long totalFee;

    // 已缴纳清收费用总额
    private Long payedFee;

    // 再次逾期保证金(违约押金,记录)
    private Long overdueDeposit;

    // 再次逾期保证金收取方式(线下收款)
    private String overdueDepositWay;

    // 是否部分还款(1是0否)
    private String repayIsPart;

    // 已催款次数
    private int remindCount;

    // 实际代偿金额(代偿预算单填写多少，就是多少)
    private Long replaceRealRepayAmount;

    // 代偿是否缴纳
    private String replaceIsRepay;

    // 代偿时间
    private Date replaceRepayDatetime;

    // 代偿收回金额
    private Long replaceBackRepayAmount;

    // 代偿收回时间
    private Date replaceBackRepayDatetime;

    // ******************处理数据******************
    // 催收方式(作废)
    private String collectionWay;

    // 催收对象(作废)
    private String collectionTarget;

    // 催收过程(作废)
    private String collectionProcess;

    // 客户意愿(作废)
    private String collectionWish;

    // 催收结果(作废)
    private String collectionResult;

    // 是否提供押金(作废)
    private String depositIsProvide;

    // 催收情况说明(作废)
    private String collectionNote;

    // ******************处理数据******************

    // ******************收车数据******************
    // 是否典当行赎回
    private String pawnshopIsRedeem;

    // 典当行名称
    private String pawnshopName;

    // 典当行赎金小写
    private String ransom;

    // 收车申请费用
    private Long tsCarAmount;

    // 收车人姓名
    private String tsUserName;

    // 收车收款账号
    private String tsBankcardNumber;

    // 收车开户行
    private String tsBankCode;

    // 收车开户支行
    private String tsSubbranch;

    // 收车申请说明
    private String tcApplyNote;

    // ******************收车数据******************

    // 打款时间
    private Date remitDatetime;

    // 打款金额
    private Long remitAmount;

    // 打款银行
    private String remitBankCode;

    // 打款水单
    private String remitBillPdf;

    // 收车地点
    private String takeCarAddress;

    // 收车时间
    private Date takeDatetime;

    // 收车人员
    private String takeName;

    // 收车停放位置
    private String takeLocation;

    // 收车说明
    private String takeNote;

    // 处理结果
    private String dealResult;

    // 出售价格
    private Long sellPrice;

    // 保证金
    private Long deposit;

    // 费用说明
    private String feeNote;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ****** 辅助字段 ******
    // 还款计划开始时间
    private Date repayStartDatetime;

    // 还款计划结束时间
    private Date repayEndDatetime;

    // 用户信息
    private User user;

    // 用户姓名
    private String realName;

    // 收车开户行名称
    private String tsBankName;

    // 还款业务
    private RepayBiz repayBiz;

    // 费用清单
    private List<Cost> costList;

    // 催收记录
    private List<RemindLog> remindLogList;

    // 逾期处理记录
    private List<OverdueTreatment> overdueTreatmentList;

    // 状态list
    private List<String> curNodeCodeList;

    // 未结清贷款金额
    private Long unsettledLoan;

    // 还款卡号
    private String bankcardNumber;

    // 角色编号
    private String roleCode;

    // 还款开始时间
    private Date repayDatetimeStart;

    // 还款结束时间
    private Date repayDatetimeEnd;

    // 打款银行名称
    private String remitBankName;

    // 代偿申请单
    private ReplaceRepayApply replaceRepayApply;

    // 业务公司编号
    private String companyCode;

    // 未还清收成本
    private Long notPayedFee;

    public List<OverdueTreatment> getOverdueTreatmentList() {
        return overdueTreatmentList;
    }

    public void setOverdueTreatmentList(
            List<OverdueTreatment> overdueTreatmentList) {
        this.overdueTreatmentList = overdueTreatmentList;
    }

    public Long getNotPayedFee() {
        return notPayedFee;
    }

    public void setNotPayedFee(Long notPayedFee) {
        this.notPayedFee = notPayedFee;
    }

    public ReplaceRepayApply getReplaceRepayApply() {
        return replaceRepayApply;
    }

    public void setReplaceRepayApply(ReplaceRepayApply replaceRepayApply) {
        this.replaceRepayApply = replaceRepayApply;
    }

    public String getRemitBankName() {
        return remitBankName;
    }

    public void setRemitBankName(String remitBankName) {
        this.remitBankName = remitBankName;
    }

    public Date getRepayDatetimeEnd() {
        return repayDatetimeEnd;
    }

    public void setRepayDatetimeEnd(Date repayDatetimeEnd) {
        this.repayDatetimeEnd = repayDatetimeEnd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getCurPeriods() {
        return curPeriods;
    }

    public void setCurPeriods(int curPeriods) {
        this.curPeriods = curPeriods;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public Long getRepayCapital() {
        return repayCapital;
    }

    public void setRepayCapital(Long repayCapital) {
        this.repayCapital = repayCapital;
    }

    public Long getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(Long repayInterest) {
        this.repayInterest = repayInterest;
    }

    public Long getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Long payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Long getOverplusAmount() {
        return overplusAmount;
    }

    public void setOverplusAmount(Long overplusAmount) {
        this.overplusAmount = overplusAmount;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getOverdueHandler() {
        return overdueHandler;
    }

    public void setOverdueHandler(String overdueHandler) {
        this.overdueHandler = overdueHandler;
    }

    public Date getOverdueHandleDatetime() {
        return overdueHandleDatetime;
    }

    public void setOverdueHandleDatetime(Date overdueHandleDatetime) {
        this.overdueHandleDatetime = overdueHandleDatetime;
    }

    public String getOverdueHandleNote() {
        return overdueHandleNote;
    }

    public void setOverdueHandleNote(String overdueHandleNote) {
        this.overdueHandleNote = overdueHandleNote;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(Long payedFee) {
        this.payedFee = payedFee;
    }

    public Long getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(Long overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public String getOverdueDepositWay() {
        return overdueDepositWay;
    }

    public void setOverdueDepositWay(String overdueDepositWay) {
        this.overdueDepositWay = overdueDepositWay;
    }

    public String getRepayIsPart() {
        return repayIsPart;
    }

    public void setRepayIsPart(String repayIsPart) {
        this.repayIsPart = repayIsPart;
    }

    public int getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(int remindCount) {
        this.remindCount = remindCount;
    }

    public Long getReplaceRealRepayAmount() {
        return replaceRealRepayAmount;
    }

    public void setReplaceRealRepayAmount(Long replaceRealRepayAmount) {
        this.replaceRealRepayAmount = replaceRealRepayAmount;
    }

    public String getReplaceIsRepay() {
        return replaceIsRepay;
    }

    public void setReplaceIsRepay(String replaceIsRepay) {
        this.replaceIsRepay = replaceIsRepay;
    }

    public Date getReplaceRepayDatetime() {
        return replaceRepayDatetime;
    }

    public void setReplaceRepayDatetime(Date replaceRepayDatetime) {
        this.replaceRepayDatetime = replaceRepayDatetime;
    }

    public Long getReplaceBackRepayAmount() {
        return replaceBackRepayAmount;
    }

    public void setReplaceBackRepayAmount(Long replaceBackRepayAmount) {
        this.replaceBackRepayAmount = replaceBackRepayAmount;
    }

    public Date getReplaceBackRepayDatetime() {
        return replaceBackRepayDatetime;
    }

    public void setReplaceBackRepayDatetime(Date replaceBackRepayDatetime) {
        this.replaceBackRepayDatetime = replaceBackRepayDatetime;
    }

    public String getCollectionWay() {
        return collectionWay;
    }

    public void setCollectionWay(String collectionWay) {
        this.collectionWay = collectionWay;
    }

    public String getCollectionTarget() {
        return collectionTarget;
    }

    public void setCollectionTarget(String collectionTarget) {
        this.collectionTarget = collectionTarget;
    }

    public String getCollectionProcess() {
        return collectionProcess;
    }

    public void setCollectionProcess(String collectionProcess) {
        this.collectionProcess = collectionProcess;
    }

    public String getCollectionWish() {
        return collectionWish;
    }

    public void setCollectionWish(String collectionWish) {
        this.collectionWish = collectionWish;
    }

    public String getCollectionResult() {
        return collectionResult;
    }

    public void setCollectionResult(String collectionResult) {
        this.collectionResult = collectionResult;
    }

    public String getDepositIsProvide() {
        return depositIsProvide;
    }

    public void setDepositIsProvide(String depositIsProvide) {
        this.depositIsProvide = depositIsProvide;
    }

    public String getCollectionNote() {
        return collectionNote;
    }

    public void setCollectionNote(String collectionNote) {
        this.collectionNote = collectionNote;
    }

    public String getPawnshopIsRedeem() {
        return pawnshopIsRedeem;
    }

    public void setPawnshopIsRedeem(String pawnshopIsRedeem) {
        this.pawnshopIsRedeem = pawnshopIsRedeem;
    }

    public String getPawnshopName() {
        return pawnshopName;
    }

    public void setPawnshopName(String pawnshopName) {
        this.pawnshopName = pawnshopName;
    }

    public String getRansom() {
        return ransom;
    }

    public void setRansom(String ransom) {
        this.ransom = ransom;
    }

    public Long getTsCarAmount() {
        return tsCarAmount;
    }

    public void setTsCarAmount(Long tsCarAmount) {
        this.tsCarAmount = tsCarAmount;
    }

    public String getTsBankcardNumber() {
        return tsBankcardNumber;
    }

    public void setTsBankcardNumber(String tsBankcardNumber) {
        this.tsBankcardNumber = tsBankcardNumber;
    }

    public String getTsBankName() {
        return tsBankName;
    }

    public void setTsBankName(String tsBankName) {
        this.tsBankName = tsBankName;
    }

    public String getTsSubbranch() {
        return tsSubbranch;
    }

    public void setTsSubbranch(String tsSubbranch) {
        this.tsSubbranch = tsSubbranch;
    }

    public String getTcApplyNote() {
        return tcApplyNote;
    }

    public void setTcApplyNote(String tcApplyNote) {
        this.tcApplyNote = tcApplyNote;
    }

    public Date getRemitDatetime() {
        return remitDatetime;
    }

    public void setRemitDatetime(Date remitDatetime) {
        this.remitDatetime = remitDatetime;
    }

    public Long getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(Long remitAmount) {
        this.remitAmount = remitAmount;
    }

    public String getRemitBankCode() {
        return remitBankCode;
    }

    public void setRemitBankCode(String remitBankCode) {
        this.remitBankCode = remitBankCode;
    }

    public String getRemitBillPdf() {
        return remitBillPdf;
    }

    public void setRemitBillPdf(String remitBillPdf) {
        this.remitBillPdf = remitBillPdf;
    }

    public String getTakeCarAddress() {
        return takeCarAddress;
    }

    public void setTakeCarAddress(String takeCarAddress) {
        this.takeCarAddress = takeCarAddress;
    }

    public Date getTakeDatetime() {
        return takeDatetime;
    }

    public void setTakeDatetime(Date takeDatetime) {
        this.takeDatetime = takeDatetime;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    public String getTakeLocation() {
        return takeLocation;
    }

    public void setTakeLocation(String takeLocation) {
        this.takeLocation = takeLocation;
    }

    public String getTakeNote() {
        return takeNote;
    }

    public void setTakeNote(String takeNote) {
        this.takeNote = takeNote;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public Long getSellPrice() {
        return sellPrice;
    }

    public String getTsBankCode() {
        return tsBankCode;
    }

    public void setTsBankCode(String tsBankCode) {
        this.tsBankCode = tsBankCode;
    }

    public void setSellPrice(Long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getTsUserName() {
        return tsUserName;
    }

    public void setTsUserName(String tsUserName) {
        this.tsUserName = tsUserName;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public String getFeeNote() {
        return feeNote;
    }

    public void setFeeNote(String feeNote) {
        this.feeNote = feeNote;
    }

    public Date getRepayStartDatetime() {
        return repayStartDatetime;
    }

    public void setRepayStartDatetime(Date repayStartDatetime) {
        this.repayStartDatetime = repayStartDatetime;
    }

    public Date getRepayEndDatetime() {
        return repayEndDatetime;
    }

    public void setRepayEndDatetime(Date repayEndDatetime) {
        this.repayEndDatetime = repayEndDatetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RepayBiz getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBiz repayBiz) {
        this.repayBiz = repayBiz;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

    public List<RemindLog> getRemindLogList() {
        return remindLogList;
    }

    public void setRemindLogList(List<RemindLog> remindLogList) {
        this.remindLogList = remindLogList;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public Long getUnsettledLoan() {
        return unsettledLoan;
    }

    public void setUnsettledLoan(Long unsettledLoan) {
        this.unsettledLoan = unsettledLoan;
    }

    public Long getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(Long repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Date getRepayDatetimeStart() {
        return repayDatetimeStart;
    }

    public void setRepayDatetimeStart(Date repayDatetimeStart) {
        this.repayDatetimeStart = repayDatetimeStart;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
