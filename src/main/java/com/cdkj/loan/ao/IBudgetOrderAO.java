package com.cdkj.loan.ao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN630908Req;
import com.cdkj.loan.dto.req.XN630909Req;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632142Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;
import com.cdkj.loan.dto.req.XN632193Req;
import com.cdkj.loan.dto.req.XN632194Req;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.dto.req.XN632220Req;
import com.cdkj.loan.dto.req.XN632230Req;
import com.cdkj.loan.dto.req.XN632270Req;
import com.cdkj.loan.dto.req.XN632271Req;
import com.cdkj.loan.dto.req.XN632272Req;
import com.cdkj.loan.dto.req.XN632280Req;
import com.cdkj.loan.dto.req.XN632281Req;
import com.cdkj.loan.dto.req.XN632292Req;
import com.cdkj.loan.dto.req.XN632341Req;
import com.cdkj.loan.dto.res.XN632234Res;
import com.cdkj.loan.dto.res.XN632690Res;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBudgetOrder(XN632120Req req);

    // 区域总经理审核
    public void approveAreaManager(String code, String operator,
            String approveResult, String approveNote);

    // 省分公司总经理审核
    public void approveBranchCompany(String code, String operator,
            String approveResult, String approveNote);

    // 二审
    public void approveGlobalManager(String code, String operator,
            String approveResult, String approveNote);

    // 申请撤销
    public void canceOrder(String code, String operator, String cancelNote);

    // 银行放款确认提交
    public void bankLoanCommit(String code, Date bankCommitDatetime,
            String bankCommitNote, String operator);

    // 确认银行放款
    public void bankLoanConfirm(XN632141Req req);

    // 车辆抵押确认提交银行
    public void carPledgeCommit(String code, Date pledgeCommitDatetime,
            String pledgeCommitNote, String operator);

    // 确认抵押完成
    public void carPledgeConfirm(XN632191Req req);

    // 车贷入档补录
    public void carLoanArchive(XN632200Req req);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    // 根据角色分页查
    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition);

    // 制卡申请
    public void approveMakeCard(String code, String makeCardRemark,
            String operator);

    // 制卡录入
    public void cardMaking(String code, String bankCardNumber,
            String makeCardRemark, String operator);

    // 发保合录入
    public void entryPreservation(XN632220Req req);

    // 发票不匹配申请
    public void invoiceMismatchApply(XN632230Req req);

    // 发票不匹配审核
    public void invoiceMismatchApprove(String code, String approveResult,
            String approveNote, String operator);

    // 发票不匹配二审
    public void invoiceMismatchSecondApprove(String code, String approveResult,
            String approveNote, String operator);

    // 应退按揭款
    public void mortgageRefund(String code, String shouldBackBankcardCode,
            String shouldBackDatetime, String shouldBackBillPdf);

    // 申请作废
    public void applyCancel(XN632270Req req);

    // 作废审核
    public void cancelBizAudit(XN632271Req req);

    // 财务确认收款
    public void financeConfirm(XN632272Req req);

    // 收款回录
    public void receiptAndReturn(XN632280Req req);

    // 收回垫资款财务审核
    public void remindingProcess(XN632281Req req);

    // 续保短信提醒
    public void renewInsuranceRemind(String code);

    // 续保
    public void renewInsurance(XN632341Req req);

    // 修改贷款金额计算关联数据
    public XN632234Res modifyLoanAmountCalculateData(String code,
            String loanAmount);

    // 垫资超过1天未放款客户
    public ArrayList<BudgetOrder> queryBudgetOrderPageByDz(int start, int limit,
            BudgetOrder condition);

    // 银行放款合同打印
    public BudgetOrder loanContractPrint(XN632142Req req);

    // 车辆抵押合同打印
    public BudgetOrder pledgeContractPrint(XN632192Req req);

    // 车辆抵押理件完成
    public void collateAchieve(XN632193Req req);

    // 车辆抵押开始
    public void pledgeBegin(XN632194Req req);

    // 银行放款理件完成
    public void bankLoanCollateAchieve(XN632143Req req);

    // 银行驻点推送已放款名单
    public void bankPointPushHasLoanList(XN632144Req req);

    // 银行返点（批量改变状态）
    public void bankRepoint(XN632292Req req);

    // list查询预算单
    public List<BudgetOrder> queryBudgetOrderByList(List<String> list);

    // 计算器
    public XN632690Res calculation(String loanBankCode, String loanPeriods,
            String loanAmount, String rateType, String serviceChargeWay,
            String bankRate, String surcharge);

    // 统计分析 余额明细
    public Object queryBudgetOrderPageForBalanceDetail(int start, int limit,
            BudgetOrder condition);

    // 统计分析 风险客户四级分类
    public Object riskCustomerFourClass(int start, int limit,
            BudgetOrder condition);

    // 统计分析 代偿明细
    public Object queryBudgetOrderPageForCompensatoryDetail(int start,
            int limit, BudgetOrder condition);

    // 统计分析 业绩完成情况
    public Object performanceCompletionSituation(XN630908Req req);

    // 统计分析 月度业绩完成情况
    public Object monthPerformanceCompletionSituation(XN630909Req req);

}
