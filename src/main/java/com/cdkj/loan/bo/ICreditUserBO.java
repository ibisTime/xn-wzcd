package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditUser;

public interface ICreditUserBO extends IPaginableBO<CreditUser> {

    public void addCreditList(List<CreditUser> dataList);

}
