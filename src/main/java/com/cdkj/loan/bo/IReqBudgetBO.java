package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ReqBudget;

public interface IReqBudgetBO extends IPaginableBO<ReqBudget> {

    public String saveReqBudget(ReqBudget data);

    public int removeReqBudget(String code);

    public int refreshReqBudget(ReqBudget data);

    public List<ReqBudget> queryReqBudgetList(ReqBudget condition);

    public ReqBudget getReqBudget(String code);

    public int refreshReqBudgetNode(ReqBudget condition);

    public int credit(ReqBudget condition);

}
