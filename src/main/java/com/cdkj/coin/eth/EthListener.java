package com.cdkj.coin.eth;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.common.PropertiesUtil;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.ESystemAccount;

/**
 * @author: haiqingzheng 
 * @since: 2017年10月24日 下午6:58:41 
 * @history:
 */
public class EthListener implements ApplicationListener<ContextRefreshedEvent> {

    private Web3j web3j;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IAccountBO accountBO;

    public static void main(String[] args) {
        System.out.println(BigInteger.valueOf(-1).compareTo(BigInteger.ZERO));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            String url = PropertiesUtil.Config.ETH_CREATE_URL;
            web3j = Web3j.build(new HttpService(url));
            web3j.pendingTransactionObservable()
                .subscribe(tx -> {
                    String fromAddress = tx.getFrom();
                    String toAddress = tx.getTo();
                    BigInteger value = tx.getValue();
                    // 挂起的交易
                    System.out.println("****** 交易开始，待矿工记账 " + tx.getCreates()
                            + " ******");
                    System.out.println("****** AddressFrom=" + fromAddress
                            + " ******");
                    System.out.println("****** AddressTo=" + toAddress
                            + " ******");
                    System.out.println("****** value=" + value + " ******");
                });

            //
            web3j.transactionObservable()
                .subscribe((tx) -> {
                    // 完成的交易，推送到
                    String fromAddress = tx.getFrom();
                    String toAddress = tx.getTo();
                    BigInteger value = tx.getValue();
                    System.out.println("****** 交易完成 " + tx.getCreates()
                            + " ******");
                    System.out.println("****** AddressFrom=" + fromAddress
                            + " ******");
                    System.out.println("****** AddressTo=" + toAddress
                            + " ******");
                    System.out.println("****** value=" + value + " ******");
                    // 1.外部向 我们的用户转账
                    // 2. 我们主动发起的转账
                    try {
                        // todo 业务逻辑
                        EthAddress ethAddress = ethAddressBO
                            .getEthAddress(toAddress);
                        if (ethAddress != null) {
                            Account account = accountBO.getRemoteAccount(
                                ethAddress.getUserId(), ECurrency.ETH);
                            accountBO.changeAmount(account.getAccountNumber(),
                                EChannelType.Offline.getCode(), "fromAddress:"
                                        + fromAddress, "ETH", "toAddress:"
                                        + toAddress, EBizType.AJ_CZ.getCode(),
                                EBizType.AJ_CZ.getValue(), value);
                            accountBO.changeAmount(
                                ESystemAccount.SYS_ACOUNT_TG_ETH.getCode(),
                                EChannelType.Offline.getCode(), "fromAddress:"
                                        + fromAddress, "ETH", "toAddress:"
                                        + toAddress, EBizType.AJ_CZ.getCode(),
                                EBizType.AJ_CZ.getValue(), value);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        }
    }
}
