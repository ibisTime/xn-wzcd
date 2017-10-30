package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.EthTransaction;

public interface IEthTransactionDAO extends IBaseDAO<EthTransaction> {
	String NAMESPACE = IEthTransactionDAO.class.getName().concat(".");
}