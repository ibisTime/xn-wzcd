package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.dto.req.XN632180Req;
import com.cdkj.loan.dto.req.XN632190Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 填写准入申请单
    public void editBudgetOrder(XN632120Req req);

    // 风控专员审核
    public void riskApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控主管审核
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 面签
    public void interview(String code, String interviewVideo,
            String interviewContract, String operator);

    // 业务总监审核
    public void bizChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 财务确认垫资
    public void advanceFund(String code, String operator,
            String advanceFundDatetime, String advanceFundAmount,
            String billPdf);

    // 安装GPS
    public void installGps(String code, String operator,
            List<XN632126ReqGps> budgetOrderGpsList);

    // GPS管理员审核
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    // 车辆落户
    public void carSettle(XN632128Req req);

    // 确认提交银行
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote);

    // 确认收款
    public void confirmLoan(XN632130Req req);

    // 录入放款信息
    public void entryFk(XN632135Req req);

    // 确定入档
    public void archive(String code, String operator, String enterLocation);

    // 录入抵押信息
    public void entryMortgage(String code, String operator,
            String pledgeDatetime, String greenBigSmj);

    // 抵押确认提交银行
    public void mortgageCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote);

    // 抵押完成
    public void mortgageFinish(XN632133Req req);

    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition);

    public BudgetOrder getMoreBudget(String code);

    // 财务确认退垫资款
    public void confirmBackAdvanceFund(XN632180Req req);

    // 客户申请作废
    public void applyCancel(XN632190Req req);

    // 客户作废 业务总监审核
    public void cancelBizAudit(XN632191Req req);

    // 客户作废 财务总监审核
    public void cancelFinanceAudit(XN632192Req req);

    // 垫资超过1天未放款客户
    public Paginable<BudgetOrder> queryBudgetOrderPageByDz(int start, int limit,
            BudgetOrder condition);

}
