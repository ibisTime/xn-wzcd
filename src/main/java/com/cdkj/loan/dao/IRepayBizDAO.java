package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizDAO extends IBaseDAO<RepayBiz> {
    String NAMESPACE = IRepayBizDAO.class.getName().concat(".");

    public int updateBankcard(RepayBiz data);

    public int updateRepayAllAdvance(RepayBiz data);

    public int updateRepayAll(RepayBiz data);

    public int updateEnterBlackList(RepayBiz data);

    public int updateConfirmSettledProduct(RepayBiz data);

    public int updateRepayBizRestAmount(RepayBiz data);

    // 红名单处理
    public int updateOverdueRedHandle(RepayBiz data);

    // 申请收车
    public int updateTakeCarApply(RepayBiz data);

    // 收车分控经理审核
    public int updateTakeCarRiskManageCheck(RepayBiz data);

    // 收车分公司总公司审核
    public int updateTakeCarCompanyManageCheck(RepayBiz data);

    // 风控总监审核
    public int updateTakeCarRiskLeaderCheck(RepayBiz data);

    // 财务经理审核
    public int updateTakeCarFinanceManageCheck(RepayBiz data);

    // 确认放款
    public int updateTakeCarSureFk(RepayBiz data);

    // 录入收车结果
    public int updateTakeCarInputResult(RepayBiz data);

    // 结果处理
    public int updateTakeCarResultHandle(RepayBiz data);

    // 根据角色查条数
    public long selectTotalCountByRoleCode(RepayBiz condition);

    // 根据角色查集合
    public List<RepayBiz> selectRepayBizByRoleCode(RepayBiz condition,
            int start, int pageSize);

    // 根据逾期次数查集合
    public List<RepayBiz> selectRepayBizByTotalOverdueCount(RepayBiz condition,
            int start, int pageSize);

    // 更新逾期金额和次数
    public int repayOverDue(RepayBiz repayBiz);

    // ********************************司法诉讼********************************
    // 诉讼申请
    public int updateJudgeApply(RepayBiz data);

    // 诉讼跟进
    public int updateJudgeFollow(RepayBiz data);

    // 执行结果录入
    public int updateJudgeResultInput(RepayBiz data);

    // 财务确认收货
    public int updateFinanceSureReceipt(RepayBiz data);

    // ********************************结清管理********************************
    // 公司结清出纳打款
    public void clearanceCashier(RepayBiz repayBiz);

    // 结算单申请
    public int updateCommitSettle(RepayBiz data);

    // 财务审核
    public int updateFinanceCheck(RepayBiz data);

    // 确认付款
    public int updateCashRemit(RepayBiz data);

    // 申请解除
    public int updateReleaseMortgageApply(RepayBiz data);

    // 风控内勤审核
    public int updateRiskIndoorCheck(RepayBiz data);

    // 风控主管审核
    public int updateRiskManagerCheck(RepayBiz data);

    // 打印岗打印
    public int updateMortgagePrint(RepayBiz data);

    // 收件
    public int updateBankRecLogic(RepayBiz data);

    // 结果回录
    public int updateMortgageCommit(RepayBiz data);

    // 还款计划结束后更新为提交结算单
    public int updateRepayEndCommitSettle(RepayBiz data);

    // 入档更新还款业务
    public void updateRepayBiz(RepayBiz repayBiz);

    // 改变资料传递中的状态
    public void updateIsLogistics(RepayBiz repayBiz);

    // 改变节点
    public void updateCurNodeCode(RepayBiz repayBiz);

    // 更新剩余期数
    public void updateRestPeriods(RepayBiz repayBiz);

}
