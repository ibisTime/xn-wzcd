package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.EthCollection;

public interface IEthCollectionDAO extends IBaseDAO<EthCollection> {
    String NAMESPACE = IEthCollectionDAO.class.getName().concat(".");

    public int updateNotice(EthCollection data);

    public EthAddress selectAddressUseInfo(EthCollection data);
}
