package com.cdkj.loan.bo;

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

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

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
    public void refreshRepayCarLoan(String repayBizCode, Long realWithholdAmount);

    // 车贷确认结算
    public void confirmSettledProduct(RepayBiz repayBiz);

    // 申请拖车
    public void takeCarApply(RepayBiz data);

    // 拖车分控经理审核
    public void takeCarRiskManageCheck(RepayBiz data);

    // 拖车分公司总公司审核
    public void takeCarCompanyManageCheck(RepayBiz data);

    // 风控总监审核
    public void takeCarRiskLeaderCheck(RepayBiz data);

    // 财务经理审核
    public void takeCarFinanceManageCheck(RepayBiz data);

    // 确认放款
    public void takeCarSureFk(RepayBiz data);

    // 录入拖车结果
    public void takeCarInputResult(RepayBiz data);

    // 结果处理
    public void takeCarResultHandle(RepayBiz data);

    /********************************司法诉讼********************************/
    // 诉讼申请
    public void refreshJudgeApply(String code);

    // 诉讼跟进
    public void refreshJudgeFollow(String code);

    // 执行结果录入
    public void refreshJudgeResultInput(String code);

    // 财务确认收货
    public void refreshFinanceSureReceipt(RepayBiz data);

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

    // ********************************common********************************
}
