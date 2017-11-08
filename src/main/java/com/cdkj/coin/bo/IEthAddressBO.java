package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressType;

public interface IEthAddressBO extends IPaginableBO<EthAddress> {

    public String generateAddress(EEthAddressType type, String ethAccountName,
            String userId, Date availableDatetimeStart,
            Date availableDatetimeEnd);

    public String saveEthAddress(EEthAddressType type, String userId,
            String address, String password, BigDecimal balance,
            Date availableDatetimeStart, Date availableDatetimeEnd);

    public List<EthAddress> queryEthAddressList(EthAddress condition);

    public List<EthAddress> queryMEthAddressList();

    public EthAddress getEthAddress(String code);

    public EthAddress getEthAddress(EEthAddressType type, String address);

    public EthAddress getEthAddressByUserId(String userId);

}
