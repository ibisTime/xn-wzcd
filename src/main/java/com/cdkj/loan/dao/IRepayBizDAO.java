package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayBiz;

public interface IRepayBizDAO extends IBaseDAO<RepayBiz> {
    String NAMESPACE = IRepayBizDAO.class.getName().concat(".");

    public int updateBankcard(RepayBiz data);

    public int updateRepayBizStatus(RepayBiz repayBiz);

    public int repayComplete(RepayBiz data);

    public int EnterBlackList(RepayBiz repayBiz);

    public int confirmClose(RepayBiz repayBiz);
}
