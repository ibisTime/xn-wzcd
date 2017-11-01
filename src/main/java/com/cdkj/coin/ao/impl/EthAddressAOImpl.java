/**
 * @Title EthAddressAOImpl.java 
 * @Package com.cdkj.coin.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月27日 下午5:43:34 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.io.IOException;
import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;

import com.cdkj.coin.ao.IEthAddressAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.SYSConfig;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.enums.ESystemAccount;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.eth.Web3JClient;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月27日 下午5:43:34 
 * @history:
 */
@Service
public class EthAddressAOImpl implements IEthAddressAO {
    static final Logger logger = LoggerFactory
        .getLogger(EthAddressAOImpl.class);

    private static Web3j web3j = Web3JClient.getClient();

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    /** 
     * @see com.cdkj.coin.ao.IEthAddressAO#doSynchronizeEthJour()
     */
    @Override
    public void doEthTransactionSync() {
        try {
            Long blockNumber = sysConfigBO
                .getLongValue(SysConstants.CUR_BLOCK_NUMBER);
            while (true) {
                blockNumber = blockNumber + 1;
                System.out.println("*********同步循环开始，扫描区块" + blockNumber
                        + "*******");
                EthBlock ethBlockResp = web3j.ethGetBlockByNumber(
                    new DefaultBlockParameterNumber(blockNumber), true).send();
                if (ethBlockResp.getError() != null) {
                    logger.error("扫描以太坊区块同步流水发送异常，原因："
                            + ethBlockResp.getError());
                }
                EthBlock.Block block = ethBlockResp.getResult();
                // 如果取到区块信息
                if (block != null) {
                    block
                        .getTransactions()
                        .forEach(
                            txObj -> {
                                EthBlock.TransactionObject tx = (EthBlock.TransactionObject) txObj;
                                String toAddress = tx.getTo();
                                if (StringUtils.isNotBlank(toAddress)) {
                                    // 查询改地址是否在我们系统中存在
                                    EthAddress ethAddress = ethAddressBO
                                        .getEthAddress(EEthAddressType.D,
                                            toAddress);
                                    // 存在逻辑
                                    if (ethAddress != null) {
                                        // 落地交易信息
                                        ethTransactionBO.saveEthTransaction(tx);
                                        // 虚拟账户加钱
                                        Account account = accountBO
                                            .getRemoteAccount(
                                                ethAddress.getUserId(),
                                                ECurrency.ETH);
                                        String fromAddress = tx.getFrom();
                                        BigInteger value = tx.getValue();
                                        String hash = tx.getHash();
                                        accountBO.changeAmount(
                                            account.getAccountNumber(),
                                            EChannelType.ETH.getCode(), hash,
                                            hash, hash,
                                            EBizType.AJ_CZ.getCode(), "来自地址:"
                                                    + fromAddress, value);
                                        accountBO.changeAmount(
                                            ESystemAccount.SYS_ACOUNT_TG_ETH
                                                .getCode(), EChannelType.ETH
                                                .getCode(), hash, hash, hash,
                                            EBizType.AJ_CZ.getCode(), "发送地址:"
                                                    + fromAddress + " 接收地址:"
                                                    + toAddress, value);
                                    }
                                }
                            });
                } else {
                    System.out.println("*********同步循环结束,区块号"
                            + (blockNumber - 1) + "为最后一个区块*******");
                    break;
                }
                SYSConfig config = sysConfigBO.getSYSConfig(
                    SysConstants.CUR_BLOCK_NUMBER, ESystemCode.COIN.getCode(),
                    ESystemCode.COIN.getCode());
                sysConfigBO.refreshSYSConfig(config.getId(),
                    String.valueOf(blockNumber), "procedure", "当前扫描至哪个区块");

            }
        } catch (IOException e1) {
            logger.error("扫描以太坊区块同步流水发送异常，原因：" + e1.getMessage());
        }
    }

}
