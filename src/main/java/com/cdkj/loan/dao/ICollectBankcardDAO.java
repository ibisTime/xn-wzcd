package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CollectBankcard;

public interface ICollectBankcardDAO extends IBaseDAO<CollectBankcard> {
    String NAMESPACE = ICollectBankcardDAO.class.getName().concat(".");

    int update(CollectBankcard data);

    List<CollectBankcard> selectCollectBankcardByCompanyCodeAndTypeList(
            CollectBankcard condition);
}
