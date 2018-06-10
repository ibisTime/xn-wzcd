package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizDAO extends IBaseDAO<RepayBiz> {
    String NAMESPACE = IRepayBizDAO.class.getName().concat(".");

    public int updateBankcard(RepayBiz data);

    public int updateRepayAllAdvance(RepayBiz data);

    public int updateRepayAll(RepayBiz data);

    public int updateEnterBlackList(RepayBiz data);

    public int updateConfirmSettled(RepayBiz data);

    public int updateRepayBizRestAmount(RepayBiz data);

}
