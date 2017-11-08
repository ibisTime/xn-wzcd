package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IAccountAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IJourBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EAccountType;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.exception.BizException;

@Service
public class AccountAOImpl implements IAccountAO {

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IJourBO jourBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Override
    @Transactional
    public void distributeAccount(String userId, String realName,
            String accountType, List<String> currencyList, String systemCode,
            String companyCode) {
        if (CollectionUtils.isNotEmpty(currencyList)) {
            Map<String, EAccountType> map = EAccountType
                .getAccountTypeResultMap();
            EAccountType eAccountType = map.get(accountType);
            if (null == eAccountType) {
                new BizException("XN0000", "账户类型不存在");
            }
            for (String currency : currencyList) {
                accountBO.distributeAccount(userId, realName, eAccountType,
                    currency, systemCode, companyCode);
            }
        }
    }

    @Override
    public void editAccountName(String userId, String realName) {
        // 验证用户名和系统编号
        Account condition = new Account();
        condition.setUserId(userId);
        List<Account> accountList = accountBO.queryAccountList(condition);
        if (CollectionUtils.isEmpty(accountList)) {
            new BizException("XN0000", "该用户无对应账号");
        }
        accountBO.refreshAccountName(userId, realName);
    }

    @Override
    @Transactional
    public void transAmountCZB(String fromUserId, String fromCurrency,
            String toUserId, String toCurrency, BigDecimal transAmount,
            String bizType, String fromBizNote, String toBizNote, String refNo) {
        EBizType a = EBizType.getBizType(bizType);
        accountBO.transAmountCZB(fromUserId, fromCurrency, toUserId,
            toCurrency, transAmount, a, fromBizNote, toBizNote, refNo);
    }

    @Override
    public Paginable<Account> queryAccountPage(int start, int limit,
            Account condition) {
        return accountBO.getPaginable(start, limit, condition);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountBO.getAccount(accountNumber);
    }

    @Override
    public List<Account> getAccountByUserId(String userId, String currency) {
        Account condition = new Account();
        condition.setUserId(userId);
        condition.setCurrency(currency);
        List<Account> accounts = accountBO.queryAccountList(condition);
        for (Account account : accounts) {
            if (ECurrency.ETH.getCode().equals(account.getCurrency())) {
                EthAddress ethAddress = ethAddressBO
                    .getEthAddressByUserId(userId);
                account.setCoinAddress(ethAddress.getAddress());
            }
        }
        return accounts;
    }

    @Override
    public List<Account> queryAccountList(Account condition) {
        return accountBO.queryAccountList(condition);
    }

    @Override
    public void changeAmount(String accountNumber, String channelType,
            String channelOrder, String payGroup, String refNo, String bizType,
            String bizNote, BigDecimal transAmount) {
        accountBO.changeAmount(accountNumber,
            EChannelType.getEChannelType(channelType), channelOrder, payGroup,
            refNo, EBizType.getBizType(bizType), bizNote, transAmount);
    }
}
