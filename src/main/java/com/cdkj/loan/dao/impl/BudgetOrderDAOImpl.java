package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrder;

@Repository("budgetOrderDAOImpl")
public class BudgetOrderDAOImpl extends AMybatisTemplate
        implements IBudgetOrderDAO {

    @Override
    public void update(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_budgetOrder"), data);
    }

    @Override
    public int insert(BudgetOrder data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrder"), data);
    }

    @Override
    public int delete(BudgetOrder data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrder"), data);
    }

    @Override
    public int updateAreaManagerApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_areaManagerApprove"),
            data);
    }

    @Override
    public int updateBranchCompanyApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_branchCompanyApprove"),
            data);

    }

    @Override
    public int updateGlobalManagerApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_globalCompanyApprove"),
            data);
    }

    @Override
    public int updateCancelOrder(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_cancelOrder"), data);
    }

    @Override
    public BudgetOrder select(BudgetOrder condition) {
        return super.select(NAMESPACE.concat("select_budgetOrder"), condition,
            BudgetOrder.class);
    }

    @Override
    public long selectTotalCount(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count"), condition);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderList"),
            condition, BudgetOrder.class);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderList"),
            start, count, condition, BudgetOrder.class);
    }

    @Override
    public void updateBankLoanCommit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankLoanCommit"), data);
    }

    @Override
    public void updateBankLoanConfirm(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankLoanConfirm"), data);
    }

    @Override
    public void updateCarPledgeCommit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carPledgeCommit"), data);
    }

    @Override
    public void updateCarPledgeConfirm(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carPledgeConfirm"), data);
    }

    @Override
    public void updateCarLoanArchive(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carLoanArchive"), data);
    }

    @Override
    public void updaterLogicNode(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_logicNode"), data);
    }

    @Override
    public void updateCurNodeCode(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_curNodeCode"), data);
    }

    @Override
    public long selectTotalCountByRoleCode(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byRoleCode"), condition);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderByRoleCodeList(
            BudgetOrder condition, int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder_roleCode"),
            start, pageSize, condition, BudgetOrder.class);
    }

    @Override
    public long selectTotalCountByDz(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count_byDz"), condition);
    }

    @Override
    public List<BudgetOrder> selectBudgetOrderByDzList(BudgetOrder condition,
            int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_budgetOrder_dz"),
            start, pageSize, condition, BudgetOrder.class);
    }

    @Override
    public void refreshCardMaking(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_cardMaking"), condition);
    }

    @Override
    public void entryPreservation(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_entryPreservation"), condition);
    }

    @Override
    public void invoiceMismatchApply(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_invoiceMismatchApply"),
            condition);
    }

    @Override
    public void invoiceMismatchApprove(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_invoiceMismatchApprove"),
            condition);
    }

    @Override
    public void twoApproveYes(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_twoApproveYes"), condition);
    }

    @Override
    public void twoApproveNo(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_twoApproveNo"), condition);
    }

    @Override
    public void mortgageRefund(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_mortgageRefund"), condition);
    }

    @Override
    public void applyCancel(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_applyCancel"), condition);
    }

    @Override
    public void cancelBizAudit(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_cancelBizAudit"), condition);
    }

    @Override
    public void invoiceMismatchFinanceConfirm(BudgetOrder condition) {
        super.update(
            NAMESPACE.concat("update_invoice_mismatch_finance_confirm"),
            condition);
    }

    @Override
    public void financeConfirm(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_financeConfirm"), condition);
    }

    @Override
    public void approveMakeCard(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_approveMakeCard"), condition);
    }

    @Override
    public void receiptAndReturn(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_receiptAndReturn"), condition);
    }

    @Override
    public void remindingProcess(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_remindingProcess"), condition);
    }

    @Override
    public void canceOrder(BudgetOrder condition) {
        super.update(NAMESPACE.concat("update_canceOrder"), condition);
    }

    @Override
    public int updateRenewInsuranceRemind(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_renewInsuranceRemind"),
            data);
    }

    @Override
    public int updateRenewInsurance(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_renewInsurance"), data);
    }

    @Override
    public void bankLoanConfirmSubmitBank(BudgetOrder data) {
        super.update(NAMESPACE.concat("bank_loan_confirm_submit_bank"), data);
    }

    @Override
    public void updateRepayBizCode(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_repayBizCode"), data);
    }

    @Override
    public void applyInvoiceMismatch(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_applyInvoiceMismatch"), data);
    }

    public void loanContractPrint(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_loanContractPrint"), data);
    }

    @Override
    public void pledgeContractPrint(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_pledgeContractPrint"), data);
    }

    @Override
    public void collateAchieve(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_collateAchieve"), data);
    }

    @Override
    public void updateEnterFileStatus(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_enterFileStatus"), data);
    }

    @Override
    public void loanBankCollateAchieve(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_loanBankCollateAchieve"), data);
    }

    @Override
    public void updateIsLogistics(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_isLogistics"), data);
    }

    @Override
    public void bankPointPushHasLoanList(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankPointPushHasLoanList"), data);
    }

    @Override
    public void bankRepoint(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankRepoint"), data);
    }

    @Override
    public void importContract(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_importContract"), data);
    }

    @Override
    public void backAdvanceFundFinanceAudit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_backAdvanceFundFinanceAudit"),
            data);
    }

}
