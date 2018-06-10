package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizBO extends IPaginableBO<RepayBiz> {

    public void refreshBankcardNew(String code, String bankcardCode,
            String updater, String remark);

    public void refreshBankcardModify(String code, String bankcardCode,
            String updater, String remark);

    public List<RepayBiz> queryRepayBizList(RepayBiz condition);

    public RepayBiz getRepayBiz(String code);

    // ********************************car********************************

    // 形成还款业务
    public RepayBiz generateCarLoanRepayBiz(BudgetOrder budgetOrder,
            String userId, String bankcardCode, String operator);

    // 车贷提前还款
    public void refreshAdvanceRepayCarLoan(RepayBiz repayBiz,
            Long realWithholdAmount);

    // 车贷正常还款
    public void refreshRepayAllCarLoan(String repayBizCode);

    // 车贷确认结算
    public void confirmSettledProduct(RepayBiz repayBiz);

    // 清欠催收部审核
    public void approveByQkcsDepart(String code, String curNodeCode,
            Long cutLyDeposit, String updater, String remark);

    // 驻行人员审核
    public void approveByBankCheck(String code, String curNodeCode,
            Date settleDatetime, String settleAttach, String updater,
            String remark);

    // 总经理审核
    public void approveByManager(String code, String curNodeCode,
            String updater, String remark);

    // 财务审核
    public void approveByFinance(String code, String curNodeCode,
            String updater, String remark);

    // 业务团队解除抵押
    public void releaseMortgage(String code, String curNodeCode,
            Date releaseDatetime, String updater);

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

    // ********************************common********************************
}
