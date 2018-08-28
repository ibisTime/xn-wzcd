package com.cdkj.loan.ao;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.req.XN630556Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.dto.req.XN630563Req;
import com.cdkj.loan.dto.req.XN630570Req;
import com.cdkj.loan.dto.req.XN630572Req;
import com.cdkj.loan.dto.req.XN630578Req;

public interface IRepayBizAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBankcardNew(XN630510Req req);

    public void editBankcardModify(XN630511Req req);

    // 管理端提前还款
    public void advanceRepayOss(XN630512Req req);

    // 前端提前还款(保留)
    // public void advanceRepay(String code, String updater, String remark);

    // ********************************car********************************

    // 申请收车
    public void takeCarApply(XN630550Req req);

    // 收车分控经理审核
    public void takeCarRiskManageCheck(String code, String approveResult,
            String operator, String remark);

    // 收车分公司总公司审核
    public void takeCarCompanyManageCheck(String code, String approveResult,
            String operator, String remark);

    // 风控总监审核
    public void takeCarRiskLeaderCheck(String code, String approveResult,
            String operator, String remark);

    // 财务经理审核
    public void takeCarFinanceManageCheck(String code, String approveResult,
            String operator, String remark);

    // 确认放款
    public void takeCarSureFk(String code, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator);

    // 录入收车结果
    public void takeCarInputResult(XN630556Req req);

    // 结果处理
    public void takeCarResultHandle(XN630557Req req);

    // 司法诉讼财务收款
    public void judgeFinanceSureReceipt(XN630563Req req);

    /********************************结清管理********************************/
    // 结算单申请
    public void commitSettle(XN630570Req req);

    // 风控经理审核
    public void riskManagerCheck(String code, String approveResult,
            String approveNote, String operator);

    // 风控总监理审核
    public void riskManageAudit(XN630578Req req);

    // 财务审核
    public void settleFinanceCheck(String code, String approveResult,
            String approveNote, String operator);

    // 确认付款
    public void settleCashRemit(XN630572Req req);

    // 申请解除
    public void settleReleaseMortgageApply(String code, String applyNote,
            String operator);

    // 风控内勤审核
    public void settleRiskIndoorCheck(String code, String approveResult,
            String approveNote, String operator);

    // 风控主管审核
    public void settleRiskManagerCheck(String code, String approveResult,
            String approveNote, String operator);

    // 抵押打印
    public RepayBiz settleMortgagePrint(String code, String releaseDatetime,
            String releaseTemplateId, String releaseNote, String operator);

    // 抵押解除确认
    public void settleMortgageCommitFile(String code, String operator);

    // ********************************car********************************

    // ********************************product********************************

    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark);

    public void confirmSettledProduct(XN630513Req req);

    // ********************************product********************************

    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start, int limit,
            RepayBiz condition);

    // 通过累计逾期次数查询业务
    public Object queryRepayBizByTotalOverdueCount(int start, int limit,
            RepayBiz condition, String curOverdueCount);

    // 理件岗理件
    public void physicalParts(List<String> codeList, String operator);

    // 处理结果财务审核（转卖，赎回）
    public void financialAudit(String code, String approveResult,
            String approveNote, String operator);

    // 逾期客户清收进度表
    public Object queryRepayBizByOverdue(int start, int limit,
            RepayBiz condition);

    // 在保金额（未结清贷款总额）
    public Object unclearedLoanTotalAmount();

    // 公司结清出纳打款
    public void clearanceCashier(String code, String paymentBank,
            String paymentPdf, String operator);

}
