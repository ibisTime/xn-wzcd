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

    // 已还金额
    private Long payedAmount;

    // 剩余欠款
    private long overplusAmount;

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

    // 再次逾期保证金
    private Long overdueDeposit;

    // 再次逾期保证金收取方式
    private String overdueDepositWay;

    // 是否部分还款
    private String repayIsPart;

    // 实际还款金额
    private Long realRepayAmount;

    // 已催款次数
    private int remindCount;

    // 实际代偿金额
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
    // 催收方式
    private String collectionWay;

    // 催收对象
    private String collectionTarget;

    // 催收过程
    private String collectionProcess;

    // 客户意愿
    private String collectionWish;

    // 催收结果
    private String collectionResult;

    // 是否提供押金
    private String depositIsProvide;

    // 催收情况说明
    private String collectionNote;

    // ******************处理数据******************

    // ******************拖车数据******************
    // 是否典当行赎回
    private String pawnshopIsRedeem;

    // 典当行名称
    private String pawnshopName;

    // 典当行赎金小写
    private String ransom;

    // 拖车申请费用
    private Long tsCarAmount;

    // 拖车收款账号
    private String tsBankcardNumber;

    // 拖车开户行
    private String tsBankName;

    // 拖车开户支行
    private String tsSubbranch;

    // 拖车申请说明
    private String tcApplyNote;

    // ******************拖车数据******************

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

    // 拖车时间
    private Date takeDatetime;

    // 拖车人员
    private String takeName;

    // 拖车停放位置
    private String takeLocation;

    // 拖车说明
    private String takeNote;

    // 处理结果
    private String dealResult;

    // 出售价格
    private Long sellPrice;

    // 保证金
    private Long deposit;

    // 费用说明
    private String feeNote;

    // ****** 辅助字段 ******
    // 还款计划开始时间
    private Date repayStartDatetime;

    // 还款计划结束时间
    private Date repayEndDatetime;

    // 用户信息
    private User user;

    // 还款业务
    private RepayBiz repayBiz;

    // 费用清单
    private List<Cost> costList;

    // 催收记录
    private List<RemindLog> remindLogList;

    // 状态list
    private List<String> curNodeCodeList;

    // 未结清贷款金额
    private Long unsettledLoan;

    // 本月还款金额
    private Long monthRepayAmount;

    // 还款卡号
    private String bankcardNumber;

    // 角色编号
    private String roleCode;

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(Long remitAmount) {
        this.remitAmount = remitAmount;
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

    public String getTcApplyNote() {
        return tcApplyNote;
    }

    public void setTcApplyNote(String tcApplyNote) {
        this.tcApplyNote = tcApplyNote;
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

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public Long getMonthRepayAmount() {
        return monthRepayAmount;
    }

    public void setMonthRepayAmount(Long monthRepayAmount) {
        this.monthRepayAmount = monthRepayAmount;
    }

    public Long getUnsettledLoan() {
        return unsettledLoan;
    }

    public void setUnsettledLoan(Long unsettledLoan) {
        this.unsettledLoan = unsettledLoan;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
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

    public String getDepositWay() {
        return depositWay;
    }

    public void setDepositWay(String depositWay) {
        this.depositWay = depositWay;
    }

    public int getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(int remindCount) {
        this.remindCount = remindCount;
    }

    public long getOverplusAmount() {
        return overplusAmount;
    }

    public void setOverplusAmount(long overplusAmount) {
        this.overplusAmount = overplusAmount;
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

    public List<RemindLog> getRemindLogList() {
        return remindLogList;
    }

    public void setRemindLogList(List<RemindLog> remindLogList) {
        this.remindLogList = remindLogList;
    }
}
