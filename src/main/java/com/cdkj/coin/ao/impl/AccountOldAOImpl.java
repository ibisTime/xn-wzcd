/**
 * @Title AccountAOImpl.java 
 * @Package com.cdkj.ylq.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月10日 上午11:09:14 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IAccountOldAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月10日 上午11:09:14 
 * @history:
 */
@Service
public class AccountOldAOImpl implements IAccountOldAO {

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Override
    public List<Account> getAccountByUserId(String userId) {
        List<Account> accounts = new ArrayList<Account>();
        // 以太币账户
        Account ethAccount = accountBO.getAccountByUser(userId,
            ECurrency.ETH.getCode());
        EthAddress ethAddress = ethAddressBO.getEthAddressByUserId(userId);
        // ethAccount.setCoinAddress(ethAddress.getAddress());
        accounts.add(ethAccount);
        return accounts;
    }

    @Override
    public void transfer(String fromUserId, String toAddress, BigDecimal amount) {
        Account account = accountBO.getAccountByUser(fromUserId,
            ECurrency.ETH.getCode());
        if (account.getAmount().compareTo(amount) == -1) {
            throw new BizException("xn625000", "以太币余额不足");
        }
        EthAddress ethAddress = ethAddressBO.getEthAddress(EEthAddressType.X,
            toAddress);
        if (ethAddress == null) {
            throw new BizException("xn625000", "接受地址不是本平台的用户地址");
        }
        // accountBO.doTransferAmountRemote(fromUserId, ethAddress.getUserId(),
        // ECurrency.ETH, amount, EBizType.Transfer_CURRENCY,
        // EBizType.Transfer_CURRENCY.getValue(),
        // EBizType.Transfer_CURRENCY.getValue(), "toAddress:" + toAddress);
    }

    @Override
    public void payOrder(String code, String payUser, String payResult,
            String payNote) {
        String channelOrder = null;
        // 如果审核通过，先进行广播
        if (EBoolean.YES.getCode().equals(payResult)) {
            // 获取散取地址
            List<EthAddress> mList = ethAddressBO.queryMEthAddressList();
            if (CollectionUtils.isNotEmpty(mList)) {
                EthAddress mEthAddress = mList.get(0);
                // Withdraw withdraw = accountBO.getWithdraw(code);
                // // 广播
                // channelOrder = ethTransactionBO.customTxByWalletFile(
                // mEthAddress.getAddress(), mEthAddress.getPassword(),
                // withdraw.getPayCardNo(), new BigInteger(withdraw
                // .getAmount().toString()));
                if (StringUtils.isBlank(channelOrder)) {
                    throw new BizException("xn625000", "交易广播失败");
                }
            } else {
                throw new BizException("xn625000", "未找到可用的散取账户");
            }

        } else {
            channelOrder = "pay_no";
        }
        // accountBO.payOrder(code, payUser, payResult, payNote, channelOrder);
    }
}
