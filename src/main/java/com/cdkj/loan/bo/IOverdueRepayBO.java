package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.OverdueRepay;

public interface IOverdueRepayBO extends IPaginableBO<OverdueRepay> {

    public void saveOverdueRepay(String overdueCode, String repayBizCode);

    public List<OverdueRepay> queryOverdueRepayList(OverdueRepay condition);

    public OverdueRepay getOverdueRepay(String code);

}
