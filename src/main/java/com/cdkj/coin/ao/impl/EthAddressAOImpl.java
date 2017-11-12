/**
 * @Title EthAddressAOImpl.java 
 * @Package com.cdkj.coin.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月27日 下午5:43:34 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IEthAddressAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.ICtqBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.enums.ESysUser;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月27日 下午5:43:34 
 * @history:
 */
@Service
public class EthAddressAOImpl implements IEthAddressAO {
    private static final Logger logger = LoggerFactory
        .getLogger(EthAddressAOImpl.class);

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ICtqBO ctqBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    /** 
     * @see com.cdkj.coin.ao.IEthAddressAO#doSynchronizeEthJour()
     */
    @Override
    public void doEthTransactionSync() {
        // try {
        // Long blockNumber = sysConfigBO
        // .getLongValue(SysConstants.CUR_BLOCK_NUMBER);
        // while (true) {
        // blockNumber = blockNumber + 1;
        // System.out.println("*********同步循环开始，扫描区块" + blockNumber
        // + "*******");
        // EthBlock ethBlockResp = web3j.ethGetBlockByNumber(
        // new DefaultBlockParameterNumber(blockNumber), true).send();
        // if (ethBlockResp.getError() != null) {
        // logger.error("扫描以太坊区块同步流水发送异常，原因："
        // + ethBlockResp.getError());
        // }
        // EthBlock.Block block = ethBlockResp.getResult();
        // // 如果取到区块信息
        // if (block != null) {
        // block
        // .getTransactions()
        // .forEach(
        // txObj -> {
        // EthBlock.TransactionObject tx = (EthBlock.TransactionObject) txObj;
        // String toAddress = tx.getTo();
        // if (StringUtils.isNotBlank(toAddress)) {
        // // 查询改地址是否在我们系统中存在
        // EthAddress ethAddress = ethAddressBO
        // .getEthAddress(EEthAddressType.X,
        // toAddress);
        // // 存在逻辑
        // if (ethAddress != null) {
        // // 落地交易信息
        // ethTransactionBO.saveEthTransaction(tx);
        // // 虚拟账户加钱
        // // Account account = accountBO
        // // .getRemoteAccount(
        // // ethAddress.getUserId(),
        // // ECurrency.ETH);
        // String fromAddress = tx.getFrom();
        // BigInteger value = tx.getValue();
        // String hash = tx.getHash();
        // // accountBO.changeAmount(
        // // account.getAccountNumber(),
        // // EChannelType.ETH.getCode(), hash,
        // // hash, hash,
        // // EBizType.AJ_CZ.getCode(), "来自地址:"
        // // + fromAddress, value);
        // // accountBO.changeAmount(
        // // ESystemAccount.SYS_ACOUNT_TG_ETH
        // // .getCode(), EChannelType.ETH
        // // .getCode(), hash, hash, hash,
        // // EBizType.AJ_CZ.getCode(), "发送地址:"
        // // + fromAddress + " 接收地址:"
        // // + toAddress, value);
        // }
        // }
        // });
        // } else {
        // System.out.println("*********同步循环结束,区块号"
        // + (blockNumber - 1) + "为最后一个区块*******");
        // break;
        // }
        // SYSConfig config = sysConfigBO.getSYSConfig(
        // SysConstants.CUR_BLOCK_NUMBER, ESystemCode.COIN.getCode(),
        // ESystemCode.COIN.getCode());
        // sysConfigBO.refreshSYSConfig(config.getId(),
        // String.valueOf(blockNumber), "procedure", "当前扫描至哪个区块");
        //
        // }
        // } catch (IOException e1) {
        // logger.error("扫描以太坊区块同步流水发送异常，原因：" + e1.getMessage());
        // }
    }

    @Override
    public EEthAddressType getType(String address) {
        EEthAddressType type = EEthAddressType.Y;
        EthAddress condition = new EthAddress();
        condition.setAddress(address);
        List<EthAddress> results = ethAddressBO.queryEthAddressList(condition);
        if (CollectionUtils.isNotEmpty(results)) {
            EthAddress ethAddress = results.get(0);
            type = EEthAddressType.getEthAddressType(ethAddress.getType());
        }
        return type;
    }

    @Override
    public String generateMAddress(Date availableDatetimeStart,
            Date availableDatetimeEnd) {
        if (availableDatetimeEnd.before(availableDatetimeStart)) {
            throw new BizException("625000", "可使用时间范围有误");
        }
        String ethAccountName = OrderNoGenerater.generate("M");
        String address = ethAddressBO.generateAddress(EEthAddressType.M,
            ethAccountName, ESysUser.SYS_USER.getCode(),
            availableDatetimeStart, availableDatetimeEnd);
        // 通知橙提取
        ctqBO.uploadAddress(address, EEthAddressType.M.getCode());
        return address;
    }

    @Override
    public String importWAddress(String address, Date availableDatetimeStart,
            Date availableDatetimeEnd) {
        return ethAddressBO.saveEthAddress(EEthAddressType.W,
            ESysUser.SYS_USER.getCode(), address, null, BigDecimal.ZERO,
            availableDatetimeStart, availableDatetimeEnd);
    }

    @Override
    public Paginable<EthAddress> queryEthAddressPage(int start, int limit,
            EthAddress condition) {
        Paginable<EthAddress> results = ethAddressBO.getPaginable(start, limit,
            condition);
        for (EthAddress ethAddress : results.getList()) {
            ethAddress.setUser(userBO.getUser(ethAddress.getUserId()));
        }
        return results;
    }

    @Override
    public EthAddress getEthAddress(String code) {
        return ethAddressBO.getEthAddress(code);
    }

}
