package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CompanyClearance;

public interface ICompanyClearanceBO extends IPaginableBO<CompanyClearance> {

    public void saveCompanyClearance(CompanyClearance data);

    public List<CompanyClearance> queryCompanyClearanceList(
            CompanyClearance condition);

    public CompanyClearance getCompanyClearance(int id);

}
