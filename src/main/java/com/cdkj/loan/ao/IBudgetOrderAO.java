package com.cdkj.loan.ao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.dto.req.XN632220Req;
import com.cdkj.loan.dto.req.XN632270Req;
import com.cdkj.loan.dto.req.XN632271Req;
import com.cdkj.loan.dto.req.XN632272Req;
import com.cdkj.loan.dto.req.XN632280Req;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addBudgetOrder(XN632120Req req);

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
    public void carPledgeConfirm(String code, String operator);

    // 车贷入档补录
    public void carLoanArchive(XN632200Req req);

    public void installGps(String code, String operator,
            List<XN632126ReqGps> gpsAzList);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    // 根据角色分页查
    public Object queryBudgetOrderPageByRoleCode(int start, int limit,
            BudgetOrder condition);

    // 制卡申请
    public void approveMakeCard(String code, String makeCardRemark,
            String operator);

    // 制卡录入
    public void cardMaking(String code, String bankCardNumber,
            String makeCardRemark);

    // 发保合录入
    public void entryPreservation(XN632220Req req);

    // 发票不匹配申请
    public void invoiceMismatchApply(String code, String loanAmount,
            String dealType, String operator);

    // 审核
    public void approveApply(String code, String approveResult,
            String approveNote, String operator);

    // 二审
    public void twoApproveApply(String code, String approveResult,
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

    // 提醒发起流程
    public void remindingProcess(String code);

}
