package com.cdkj.coin.bo;

import java.util.List;

import org.web3j.protocol.core.methods.response.EthBlock;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthTransaction;

public interface IEthTransactionBO extends IPaginableBO<EthTransaction> {

    public int saveEthTransaction(EthBlock.TransactionObject tx);

    public List<EthTransaction> queryEthTransactionList(EthTransaction condition);

    public EthTransaction getEthTransaction(String hash);

}
