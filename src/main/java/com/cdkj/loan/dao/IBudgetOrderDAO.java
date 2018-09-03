package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrder;

//dao层 
public interface IBudgetOrderDAO extends IBaseDAO<BudgetOrder> {
    String NAMESPACE = IBudgetOrderDAO.class.getName().concat(".");

    // 预算单页面新增预算单
    void update(BudgetOrder data);

    int updateAreaManagerApprove(BudgetOrder data);

    int updateBranchCompanyApprove(BudgetOrder data);

    int updateGlobalManagerApprove(BudgetOrder data);

    int updateCancelOrder(BudgetOrder data);

    // 银行放款确认提交
    public void updateBankLoanCommit(BudgetOrder data);

    // 确认银行放款
    public void updateBankLoanConfirm(BudgetOrder data);

    // 车辆抵押确认提交银行
    public void updateCarPledgeCommit(BudgetOrder data);

    // 确认抵押完成
    public void updateCarPledgeConfirm(BudgetOrder data);

    // 车贷入档补录
    public void updateCarLoanArchive(BudgetOrder data);

    // 收件审核通过，改变预算单状态
    void updaterLogicNode(BudgetOrder budgetOrder);

    // 改变节点
    void updateCurNodeCode(BudgetOrder budgetOrder);

    long selectTotalCountByRoleCode(BudgetOrder condition);

    List<BudgetOrder> selectBudgetOrderByRoleCodeList(BudgetOrder condition,
            int start, int pageSize);

    long selectTotalCountByDz(BudgetOrder condition);

    List<BudgetOrder> selectBudgetOrderByDzList(BudgetOrder condition,
            int start, int pageSize);

    // 申请制卡
    void approveMakeCard(BudgetOrder budgetOrder);

    // 制卡录入
    void refreshCardMaking(BudgetOrder condition);

    // 发保合录入
    void entryPreservation(BudgetOrder budgetOrder);

    // 发票不匹配申请(录发保合时 改预算单状态)
    void invoiceMismatchApply(BudgetOrder budgetOrder);

    // 发票不匹配审核
    void invoiceMismatchApprove(BudgetOrder budgetOrder);

    // 二审通过
    void twoApproveYes(BudgetOrder condition);

    // 二审不通过
    void twoApproveNo(BudgetOrder condition);

    // 应退按揭款
    void mortgageRefund(BudgetOrder budgetOrder);

    // 作废申请
    void applyCancel(BudgetOrder budgetOrder);

    // 作废审核
    void cancelBizAudit(BudgetOrder budgetOrder);

    // 财务确认收款
    void financeConfirm(BudgetOrder budgetOrder);

    // 收款回录
    void receiptAndReturn(BudgetOrder budgetOrder);

    // 提醒发起流程
    void remindingProcess(BudgetOrder budgetOrder);

    // 银行放款确认提交银行
    void bankLoanConfirmSubmitBank(BudgetOrder budgetOrder);

    // 申请撤销
    void canceOrder(BudgetOrder budgetOrder);

    // 续保短信提醒
    public int updateRenewInsuranceRemind(BudgetOrder data);

    // 续保
    public int updateRenewInsurance(BudgetOrder data);

    // 预算单修改还款业务编号
    void updateRepayBizCode(BudgetOrder budgetOrder);

    // 发票不匹配申请（申请发送）
    void applyInvoiceMismatch(BudgetOrder budgetOrder);

    // 银行放款合同打印
    void loanContractPrint(BudgetOrder budgetOrder);

    // 车辆抵押合同打印
    void pledgeContractPrint(BudgetOrder budgetOrder);

    // 车辆抵押理件完成
    void collateAchieve(BudgetOrder budgetOrder);

    // 更改入档状态
    void updateEnterFileStatus(BudgetOrder budgetOrder);

    // 银行放款理件完成
    void loanBankCollateAchieve(BudgetOrder budgetOrder);

    // 物流传递中
    void updateIsLogistics(BudgetOrder budgetOrder);

    // 银行驻点推送已放款名单
    void bankPointPushHasLoanList(BudgetOrder budgetOrder);

    // 发票不匹配财务确认
    void invoiceMismatchFinanceConfirm(BudgetOrder budgetOrder);

    // 银行返点
    void bankRepoint(BudgetOrder budgetOrder);

    // 银行合同导入
    void importContract(BudgetOrder budgetOrder);

    // 收回垫资款财务审核
    void backAdvanceFundFinanceAudit(BudgetOrder budgetOrder);

    // 生成业务员奖金
    void generateSaleUserBonus(BudgetOrder budgetOrder);

    // 预算单改为已结束
    void updateBudgetOrderEnd(BudgetOrder budgetOrder);

}
