package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Cost;

public interface ICostBO extends IPaginableBO<Cost> {

    public boolean isCostExist(String code);

    public String saveCost(Cost data);

    public int removeCost(String code);

    public void refreshRepay(Cost data, String repayWay);

    public List<Cost> queryCostList(Cost condition);

    public Cost getCost(String code);
}
