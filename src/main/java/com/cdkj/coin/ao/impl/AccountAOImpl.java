package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.cdkj.coin.ao.IAccountAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.ICurrencyRateBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IJourBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.dto.res.XN802503Res;
import com.cdkj.coin.enums.EAccountType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EMarketOrigin;
import com.cdkj.coin.exception.BizException;

@Service
public class AccountAOImpl implements IAccountAO {

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IJourBO jourBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IMarketBO marketBO;

    @Autowired
    private ICurrencyRateBO currencyRateBO;

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
            String fromBizType, String toBizType, String fromBizNote,
            String toBizNote, String refNo) {
        accountBO.transAmountCZB(fromUserId, fromCurrency, toUserId,
            toCurrency, transAmount, fromBizType, toBizType, fromBizNote,
            toBizNote, refNo);
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
    public XN802503Res getAccountByUserId(String userId, String currency) {
        XN802503Res res = new XN802503Res();

        // 总资产
        BigDecimal totalAmountCNY = BigDecimal.ZERO;
        BigDecimal totalAmountUSD = BigDecimal.ZERO;
        BigDecimal totalAmountHKD = BigDecimal.ZERO;

        Account condition = new Account();
        condition.setUserId(userId);
        condition.setCurrency(currency);
        List<Account> accountList = accountBO.queryAccountList(condition);
        for (Account account : accountList) {
            // 以太坊账户逻辑
            if (ECoin.ETH.getCode().equals(account.getCurrency())) {
                // 以太坊B站行情
                Market market = marketBO.marketByCoinTypeAndOrigin(
                    ECoin.ETH.getCode(), EMarketOrigin.BITFINEX.getCode());
                // 人民币总资产折算
                totalAmountCNY = totalAmountCNY.add(market.getMid().multiply(
                    Convert.fromWei(account.getAmount(), Unit.ETHER)));
                // 美元总资产折算
                CurrencyRate usdRate = currencyRateBO
                    .currencyRateByCurrency(ECurrency.USD.getCode());
                totalAmountUSD = totalAmountUSD.add(totalAmountCNY.divide(
                    usdRate.getRate(), 2, RoundingMode.DOWN));
                // 港币总资产折算
                CurrencyRate hkdRate = currencyRateBO
                    .currencyRateByCurrency(ECurrency.HKD.getCode());
                totalAmountHKD = totalAmountHKD.add(totalAmountCNY.divide(
                    hkdRate.getRate(), 2, RoundingMode.DOWN));

                // X地址获取
                EthAddress ethAddress = ethAddressBO
                    .getEthAddressByUserId(userId);
                account.setCoinAddress(ethAddress.getAddress());
            }
            // todo 其他币账户逻辑
        }

        res.setAccountList(accountList);
        res.setTotalAmountCNY(totalAmountCNY.toString());
        res.setTotalAmountUSD(totalAmountUSD.toString());
        res.setTotalAmountHKD(totalAmountHKD.toString());

        return res;
    }

    @Override
    public List<Account> queryAccountList(Account condition) {
        return accountBO.queryAccountList(condition);
    }

    @Override
    public void changeAmount(String accountNumber, String channelType,
            String channelOrder, String payGroup, String refNo, String bizType,
            String bizNote, BigDecimal transAmount) {
        Account account = accountBO.getAccount(accountNumber);
        accountBO.changeAmount(account, transAmount,
            EChannelType.getEChannelType(channelType), channelOrder, payGroup,
            refNo, bizType, bizNote);
    }
}
