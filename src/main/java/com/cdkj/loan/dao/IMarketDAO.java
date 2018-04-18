package com.cdkj.loan.dao;

import java.math.BigDecimal;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Market;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketDAO extends IBaseDAO<Market> {

    String NAMESPACE = IMarketDAO.class.getName().concat(".");

    int update(Market market);

    BigDecimal selectMarketAvg(Market condition);

}
