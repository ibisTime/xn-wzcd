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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IAccountAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月10日 上午11:09:14 
 * @history:
 */
@Service
public class AccountAOImpl implements IAccountAO {

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Override
    public List<Account> getAccountByUserId(String userId) {
        List<Account> accounts = new ArrayList<Account>();
        // 以太币账户
        Account ethAccount = accountBO.getRemoteAccount(userId, ECurrency.ETH);
        EthAddress ethAddress = ethAddressBO.getEthAddressByUserId(userId);
        ethAccount.setCoinAddress(ethAddress.getAddress());
        accounts.add(ethAccount);
        return accounts;
    }

    @Override
    public void transfer(String fromUserId, String toAddress, BigDecimal amount) {
        Account account = accountBO.getRemoteAccount(fromUserId, ECurrency.ETH);
        if (account.getAmount().compareTo(amount) == -1) {
            throw new BizException("xn625000", "以太币余额不足");
        }
        EthAddress ethAddress = ethAddressBO.getEthAddress(toAddress);
        if (ethAddress == null) {
            throw new BizException("xn625000", "接受地址不是本平台的地址");
        }
        accountBO.doTransferAmountRemote(fromUserId, ethAddress.getUserId(),
            ECurrency.ETH, amount, EBizType.Transfer_CURRENCY,
            EBizType.Transfer_CURRENCY.getValue(),
            EBizType.Transfer_CURRENCY.getValue(), "toAddress:" + toAddress);
    }

}
