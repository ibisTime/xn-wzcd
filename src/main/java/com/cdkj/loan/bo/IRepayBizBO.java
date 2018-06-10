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

    public RepayBiz genereateNewCarLoanRepayBiz(BudgetOrder budgetOrder,
            String userId, String bankcardCode, String operator);

    public void repaySuccessNormal(String repayBizCode);

    public RepayBiz genereateNewProductLoanRepayBiz(Order order);

    public int refreshStatusEarlyRepayment(RepayBiz repayBiz);

    public int refreshRepayBizStatus(RepayBiz repayBiz);

    public int confirmClose(RepayBiz repayBiz);

    public int refreshRestAmount(RepayBiz repayBiz, Long realWithholdAmount);

    public int repayEarlySuccess(RepayBiz repayBiz, Long realWithholdAmount);

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
}
