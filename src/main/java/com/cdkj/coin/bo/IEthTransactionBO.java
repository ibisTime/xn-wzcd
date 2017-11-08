package com.cdkj.coin.bo;

import java.math.BigInteger;
import java.util.List;

import org.web3j.protocol.core.methods.response.EthBlock;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthTransaction;
import com.cdkj.coin.eth.CtqEthTransaction;

public interface IEthTransactionBO extends IPaginableBO<EthTransaction> {

    public int saveEthTransaction(EthBlock.TransactionObject tx);

    public int saveEthTransaction(CtqEthTransaction ctqEthTransaction);

    public List<EthTransaction> queryEthTransactionList(EthTransaction condition);

    public EthTransaction getEthTransaction(String hash);

    public String customTxByWalletFile(String from, String fromPassword,
            String to, BigInteger amount);
}
