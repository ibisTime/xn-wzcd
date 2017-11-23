package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthTransaction;
import com.cdkj.coin.eth.CtqEthTransaction;

public interface IEthTransactionBO extends IPaginableBO<EthTransaction> {

    public int saveEthTransaction(CtqEthTransaction ctqEthTransaction,
            String refNo);

    public List<EthTransaction> queryEthTransactionList(EthTransaction condition);

    public EthTransaction getEthTransaction(String hash);

    // 估算交易价格

    // 广播
    public String broadcast(String from, String fromPassword, String to,
            BigDecimal value);

    // 获取以太坊gas价格
    public BigDecimal getGasPrice();
}
