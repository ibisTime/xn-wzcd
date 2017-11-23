package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.EthCollection;
import com.cdkj.coin.domain.Withdraw;

public interface IWithdrawDAO extends IBaseDAO<Withdraw> {
    String NAMESPACE = IWithdrawDAO.class.getName().concat(".");

    void approveOrder(Withdraw data);

    void payOrder(Withdraw data);

    void broadcastOrder(Withdraw data);

    public EthAddress selectAddressUseInfo(EthCollection data);

}
