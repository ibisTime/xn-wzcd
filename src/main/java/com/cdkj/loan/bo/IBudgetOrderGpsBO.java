package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrderGps;

public interface IBudgetOrderGpsBO extends IPaginableBO<BudgetOrderGps> {

    public String saveBudgetOrderGps(BudgetOrderGps data);

    public void saveBudgetOrderGpsList(String budgetOrderCode,
            List<String> gpsList, String gpsLocation);

    public int removeBudgetOrderGps(String code);

    public void removeBudgetOrderGpsList(String code);

    public void abandonBudgetOrderGps(BudgetOrderGps data);

    public List<BudgetOrderGps> queryBudgetOrderGpsList(String budgetCode);

    public List<BudgetOrderGps> queryBudgetOrderGpsList(
            BudgetOrderGps condition);

    public BudgetOrderGps getBudgetOrderGps(String code);

}
