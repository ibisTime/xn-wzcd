package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.TradeOrder;

public interface ITradeOrderDAO extends IBaseDAO<TradeOrder> {
	String NAMESPACE = ITradeOrderDAO.class.getName().concat(".");
}