package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BasicValuation;

public interface IBasicValuationBO extends IPaginableBO<BasicValuation> {

    public void saveBasicValuation(BasicValuation data);

    public List<BasicValuation> queryBasicValuationList(
            BasicValuation condition);

    public BasicValuation getBasicValuation(int id);

}
