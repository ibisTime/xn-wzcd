package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630512Req;

public interface IRepayBizBO extends IPaginableBO<RepayBiz> {

    public void refreshBankcardNew(String code, String bankcardCode,
            String updater, String remark);

    public void refreshBankcardModify(String code, String bankcardCode,
            String updater, String remark);

    // 根据角色编号查询
    public Paginable<RepayBiz> getPaginableByRoleCode(int start, int limit,
            RepayBiz condition);

    // 通过累计逾期次数查询业务
    public Paginable<RepayBiz> getPaginableByTotalOverdueCount(int start,
            int limit, RepayBiz condition);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    // 根据关联编号（业务编号）查询
    public RepayBiz getRepayBizByRefCode(String code);

    // ********************************car********************************

    // 逾期红名单处理
    public void overdueRedMenuHandle(RepayBiz data, String curNodeCode);

    // 形成还款业务
    public RepayBiz generateCarLoanRepayBiz(BudgetOrder budgetOrder,
            String userId, String bankcardCode, String operator);

    // 车贷提前还款
    public void refreshAdvanceRepayCarLoan(XN630512Req req, RepayBiz repayBiz,
            Long realWithholdAmount);

    // 车贷还款订单
    public void refreshRepayCarLoan(String repayBizCode,
            Long realWithholdAmount);

    // 车贷确认结算
    public void confirmSettledProduct(RepayBiz repayBiz);

    // 申请收车
    public void takeCarApply(RepayBiz data);

    // 收车分控经理审核
    public void takeCarRiskManageCheck(RepayBiz data);

    // 收车分公司总公司审核
    public void takeCarCompanyManageCheck(RepayBiz data);

    // 风控总监审核
    public void takeCarRiskLeaderCheck(RepayBiz data);

    // 财务经理审核
    public void takeCarFinanceManageCheck(RepayBiz data);

    // 确认放款
    public void takeCarSureFk(RepayBiz data);

    // 录入收车结果
    public void takeCarInputResult(RepayBiz data);

    // 结果处理
    public void takeCarResultHandle(RepayBiz data);

    /********************************司法诉讼********************************/
    // 诉讼申请
    public void refreshJudgeApply(String code);

    // 重新申请执行
    public void resultInputAgain(String code);

    // 执行结果录入用户已还清
    public void refreshJudgePaid(String code);

    // 执行结果录入需要重新诉讼
    public void refreshJudgeAgain(String code);

    // 执行结果录入归入坏账
    public void refreshJudgeBad(String code);

    // 财务确认收款
    public void refreshJudgeFinanceSureReceipt(RepayBiz data);

    // 录入查封裁定到期时间
    public void inputVerdict(String repayBizCode);

    /********************************结清管理********************************/
    // 公司结清出纳打款
    public void clearanceCashier(RepayBiz repayBiz);

    // 结算单申请
    public void refreshCommitSettle(RepayBiz data);

    // 风控总监理审核
    public void riskManageAudit(String code, String nextNodeCode,
            String approveNote, String operator);

    // 财务审核
    public void refreshFinanceCheck(String code, String curNodeCode,
            String remark, String updater);

    // 确认付款
    public void refreshCashRemit(RepayBiz data);

    // 申请解除
    public void refreshReleaseMortgageApply(String code, String applyNote,
            String curNodeCode, String updater);

    // 风控内勤审核
    public void refreshRiskIndoorCheck(String code, String curNodeCode,
            String remark, String updater);

    // 风控主管审核
    public void refreshRiskManagerCheck(String code, String curNodeCode,
            String remark, String updater);

    // 解除抵押:风控总监审核
    public void settleriskManageAudit(String code, String nextNodeCode,
            String applyNote, String operator);

    // 打印岗打印
    public void refreshMortgagePrint(RepayBiz data, String curNodeCode,
            Date releaseDatetime, String releaseTemplateId, String releaseNote,
            String updater);

    // 收件
    public void refreshBankRecLogic(String code, String curNodeCode,
            String updater);

    // 结果回录
    public void refreshMortgageCommit(RepayBiz data);

    // 还款计划结束后更新为提交结算单
    public void refreshRepayEndCommitSettle(String code);

    // ********************************car********************************

    // ******************************product********************************

    public RepayBiz generateProductLoanRepayBiz(Order order);

    // 产品提前还款
    public void refreshAdvanceRepayProduct(RepayBiz repayBiz,
            Long realWithholdAmount);

    // 产品正常还款
    public void refreshRepayAllCarProduct(String repayBizCode);

    // 加入黑名单
    public void refreshEnterBlackList(RepayBiz data);

    // 产品确认结算
    public void confirmSettledCarProduct(RepayBiz repayBiz);

    // ********************************product********************************

    // ********************************common********************************

    // 部分还款更新还款金额
    public void refreshRestAmount(RepayBiz repayBiz, Long realWithholdAmount);

    // 更新逾期金额
    public void repayOverdue(RepayBiz repayBiz);

    // 更新还款业务
    public void refreshRepayBiz(BudgetOrder budgetOrder);

    // 改变资料传递中的状态
    public void updateIsLogistics(RepayBiz repayBiz);

    // 收件审核通过
    public void logicOrder(String code, String operator, String remark);

    // 改变节点
    public void updateCurNodeCode(RepayBiz repayBiz);

    // 更新剩余期数
    public void refreshRestPeriods(RepayBiz repayBiz);

    // 更新是否恢复申请
    public void updateRepayBizImplement(RepayBiz repayBiz);

    // ********************************common********************************
}
