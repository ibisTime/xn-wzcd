package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressType;

public interface IEthAddressBO extends IPaginableBO<EthAddress> {

    public int saveEthAddress(EEthAddressType type, String userId,
            String address, String password);

    public List<EthAddress> queryEthAddressList(EthAddress condition);

    public List<EthAddress> queryMEthAddressList();

    public EthAddress getEthAddress(Long id);

    public EthAddress getEthAddress(EEthAddressType type, String address);

    public EthAddress getEthAddressByUserId(String userId);

}
