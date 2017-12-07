package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressStatus;
import com.cdkj.coin.enums.EEthAddressType;

public interface IEthAddressBO extends IPaginableBO<EthAddress> {

    // 生成地址（有私钥）
    public String generateAddress(EEthAddressType type, String ethAccountName,
            String userId, Date availableDatetimeStart,
            Date availableDatetimeEnd);

    // 导入（保存）地址
    public String saveEthAddress(EEthAddressType type, String userId,
            String address, String label, String password, BigDecimal balance,
            Date availableDatetimeStart, Date availableDatetimeEnd,
            EEthAddressStatus status, String keystoreName,
            String keystoreContent);

    // 获取今日散取地址
    public EthAddress getMEthAddressToday();

    // 获取今日归集地址
    public EthAddress getWEthAddressToday();

    // 查询以太坊地址余额
    public BigDecimal getEthBalance(String address);

    // 更新余额
    public int refreshBalance(EthAddress address);

    public EthAddress getEthAddress(EEthAddressType type, String address);

    public EthAddress getEthAddressByUserId(String userId);

    public boolean isEthAddressExist(String address);

    public EthAddress getEthAddressSecret(String code);

    public List<EthAddress> queryEthAddressList(EthAddress condition);

    public EthAddress getEthAddress(String code);

    public int abandonAddress(EthAddress ethAddress);

    public BigDecimal getTotalBalance(EEthAddressType type);

}
