package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthAddress;

public interface IEthAddressBO extends IPaginableBO<EthAddress> {

    public int saveEthAddress(String userId, String address, String password);

    public List<EthAddress> queryEthAddressList(EthAddress condition);

    public EthAddress getEthAddress(Long id);

    public EthAddress getEthAddress(String address);

    public EthAddress getEthAddressByUserId(String userId);

}
