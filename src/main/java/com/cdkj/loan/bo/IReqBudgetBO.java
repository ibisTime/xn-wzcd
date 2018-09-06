package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ReqBudget;

public interface IReqBudgetBO extends IPaginableBO<ReqBudget> {

    public String saveReqBudget(ReqBudget data);

    public int removeReqBudget(String code);

    public int refreshReqBudget(ReqBudget data);

    public List<ReqBudget> queryReqBudgetList(ReqBudget condition);

    public ReqBudget getReqBudget(String code);

    public int refreshReqBudgetNode(ReqBudget condition);

    public int loan(ReqBudget condition);

    public Paginable<ReqBudget> getPaginableByRoleCode(int start, int pageSize,
            ReqBudget condition);

    public int collectionReqBudget(ReqBudget data);

    // 查询今天的请款预算单（打款时间是今天的）
    public ReqBudget getTodayReqBudget(String companyCode);

    // 打款回录
    public void backRecord(ReqBudget reqBudget);

}
