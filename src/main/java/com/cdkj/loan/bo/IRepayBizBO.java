package com.cdkj.loan.bo;

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

}
