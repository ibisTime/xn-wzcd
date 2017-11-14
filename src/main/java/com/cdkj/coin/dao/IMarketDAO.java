package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.Market;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketDAO extends IBaseDAO<Market> {

    String NAMESPACE = IMarketDAO.class.getName().concat(".");

    int update(Market market);

}
