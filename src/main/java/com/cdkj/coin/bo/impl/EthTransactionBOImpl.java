package com.cdkj.coin.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.protocol.core.methods.response.EthBlock;

import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.dao.IEthTransactionDAO;
import com.cdkj.coin.domain.EthTransaction;
import com.cdkj.coin.exception.BizException;

@Component
public class EthTransactionBOImpl extends PaginableBOImpl<EthTransaction>
        implements IEthTransactionBO {

    @Autowired
    private IEthTransactionDAO ethTransactionDAO;

    @Override
    public int saveEthTransaction(EthBlock.TransactionObject tx) {
        int count = 0;
        if (tx != null) {
            EthTransaction transaction = new EthTransaction();
            transaction.setHash(tx.getHash());
            transaction.setNonce(tx.getNonce().toString());
            transaction.setBlockHash(tx.getBlockHash());
            transaction.setBlockNumber(tx.getBlockNumber().toString());
            transaction
                .setTransactionIndex(tx.getTransactionIndex().toString());
            transaction.setFrom(tx.getFrom());
            transaction.setTo(tx.getTo());
            transaction.setValue(tx.getValue().toString());
            transaction.setGasPrice(tx.getGasPrice().toString());
            transaction.setGas(tx.getGas().toString());
            transaction.setInput(tx.getInput());
            transaction.setPublicKey(tx.getPublicKey());
            transaction.setRaw(tx.getRaw());
            transaction.setR(tx.getR());
            transaction.setS(tx.getS());
            count = ethTransactionDAO.insert(transaction);
        }
        return count;
    }

    @Override
    public List<EthTransaction> queryEthTransactionList(EthTransaction condition) {
        return ethTransactionDAO.selectList(condition);
    }

    @Override
    public EthTransaction getEthTransaction(String hash) {
        EthTransaction data = null;
        if (StringUtils.isNotBlank(hash)) {
            EthTransaction condition = new EthTransaction();
            condition.setHash(hash);
            data = ethTransactionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "以太坊交易记录不存在");
            }
        }
        return data;
    }
}
