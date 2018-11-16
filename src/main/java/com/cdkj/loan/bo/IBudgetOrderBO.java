package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    // 征信结果生成的预算单
    public String saveBudgetOrder(BudgetOrder data);

    // 预算单页面新增预算单
    public void refresh(BudgetOrder data);

    // 申请撤销
    public void canceOrder(BudgetOrder budgetOrder);

    public void refreshAreaManagerApprove(BudgetOrder data);

    public void refreshBranchCompanyApprove(BudgetOrder data);

    public void refreshGlobalManagerApprove(BudgetOrder data);

    public void refreshCanceOrder(BudgetOrder data);

    // 银行放款确认提交
    public void refreshBankLoanCommit(BudgetOrder data);

    // 确认银行放款
    public void refreshBankLoanConfirm(BudgetOrder data);

    // 车辆抵押确认提交银行
    public void refreshCarPledgeCommit(BudgetOrder data);

    // 确认抵押完成
    public void refreshCarPledgeConfirm(BudgetOrder data);

    // 车贷入档补录
    public void refreshCarLoanArchive(BudgetOrder data);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode);

    public void logicOrder(String code, String logisticsCode, String operator);

    // 发件，改变节点
    public void updateCurNodeCode(BudgetOrder budgetOrder);

    // 根据角色分页查
    public Paginable<BudgetOrder> getPaginableByRoleCode(int start, int limit,
            BudgetOrder condition);

    // 根据角色分页查
    public Paginable<BudgetOrder> getPaginableByDz(int start, int limit,
            BudgetOrder condition);

    // 申请制卡
    public void approveMakeCard(BudgetOrder budgetOrder);

    // 制卡录入
    public void refreshCardMaking(BudgetOrder condition);

    // 发保合录入
    public void entryPreservation(BudgetOrder budgetOrder);

    // 发票不匹配申请(录发保合时不匹配且影响贷款额时改变预算单节点为发票不匹配申请)
    public void invoiceMismatchApply(BudgetOrder budgetOrder);

    // 发票不匹配审核
    public void invoiceMismatchApprove(BudgetOrder budgetOrder);

    // 二审通过
    public void twoApproveYes(BudgetOrder budgetOrder);

    // 二审不通过
    public void twoApproveNo(BudgetOrder budgetOrder);

    // 应退按揭款
    public void mortgageRefund(BudgetOrder budgetOrder);

    // 作废申请
    public void applyCancel(BudgetOrder budgetOrder);

    // 作废审核
    public void cancelBizAudit(BudgetOrder budgetOrder);

    // 财务确认收款
    public void financeConfirm(BudgetOrder budgetOrder);

    // 发起收回垫资款
    public void receiptAndReturn(BudgetOrder budgetOrder);

    // 提醒发起流程
    public void remindingProcess(BudgetOrder budgetOrder);

    // 银行放款确认提交银行
    public void bankLoanConfirmSubmitBank(BudgetOrder budgetOrder);

    // 续保短信提醒
    public void renewInsuranceRemind(String code, int insuranceRemindCount);

    // 续保
    public void renewInsurance(BudgetOrder data);

    // 改变预算单节点 公共
    public void refreshCurNodeCode(BudgetOrder budgetOrder);

    // 更改预算单的业务编号
    public void updateRepayBizCode(String code, String repayBizCode,
            String userId);

    // 申请发票不匹配（发票不匹配界面的申请 发送）
    public void applyInvoiceMismatch(BudgetOrder budgetOrder);

    // 银行放款合同打印
    public void loanContractPrint(BudgetOrder budgetOrder);

    // 车辆抵押合同打印
    public void pledgeContractPrint(BudgetOrder budgetOrder);

    // 车辆抵押理件完成
    public void collateAchieve(BudgetOrder budgetOrder);

    // 更改入档状态
    public void updateEnterFileStatus(BudgetOrder budgetOrder);

    // 银行放款理件完成
    public void loanBankCollateAchieve(BudgetOrder budgetOrder);

    // 物流传递中
    public void updateIsLogistics(BudgetOrder budgetOrder);

    // 银行驻点推送已放款名单
    public void bankPointPushHasLoanList(BudgetOrder budgetOrder);

    // 发票不匹配财务确认
    public void invoiceMismatchFinanceConfirm(BudgetOrder budgetOrder);

    // 银行返点
    public void bankRepoint(BudgetOrder budgetOrder);

    // 银行合同导入
    public void importContract(BudgetOrder budgetOrder);

    // 收回垫资款财务审核
    public void backAdvanceFundFinanceAudit(BudgetOrder budgetOrder);

    // 生成业务员奖金
    public void generateSaleUserBonus(BudgetOrder budgetOrder);

    // 预算单改为已结束
    public void updateBudgetOrderEnd(BudgetOrder budgetOrder);

    // 更改补件原因id和节点
    public void updateCurNodeCodeAndReasonId(BudgetOrder budgetOrder);

    // 汽车估值结果
    public void refreshCar300Url(BudgetOrder budgetOrder);

}
