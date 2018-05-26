package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CollectBankcard;

//dao层 
public interface ICollectBankcardDAO extends IBaseDAO<CollectBankcard> {
    String NAMESPACE = ICollectBankcardDAO.class.getName().concat(".");

    int update(CollectBankcard data);
}
