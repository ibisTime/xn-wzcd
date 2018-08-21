package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.PerformanceBond;

public interface IPerformanceBondBO extends IPaginableBO<PerformanceBond> {

    public void savePerformanceBond(PerformanceBond data);

    public void refreshPerformanceBond(PerformanceBond data);

    public List<PerformanceBond> queryPerformanceBondList(
            PerformanceBond condition);

    public PerformanceBond getPerformanceBond(int id);

    public PerformanceBond getPerformanceBondByBudget(String budgetCode);

}
