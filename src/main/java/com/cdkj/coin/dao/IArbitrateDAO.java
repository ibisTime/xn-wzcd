package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.Arbitrate;

public interface IArbitrateDAO extends IBaseDAO<Arbitrate> {
    String NAMESPACE = IArbitrateDAO.class.getName().concat(".");

    public int updateHandle(Arbitrate data);

    public int updateCancel(Arbitrate data);
}
