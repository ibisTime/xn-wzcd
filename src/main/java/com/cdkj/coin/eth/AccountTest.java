/**
 * @Title AccountTest.java 
 * @Package ethereum 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月18日 下午7:49:59 
 * @version V1.0   
 */
package com.cdkj.coin.eth;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月18日 下午7:49:59 
 * @history:
 */
public class AccountTest {

    public static void main(String args[]) {
        String hash = broadcast("0x901536393df4bf66986c12cf98f3d6718c534f20",
            "533109", "0xb5b65134878ff514aecc989c0720674f3dd6aab2",
            new BigDecimal("1000000000000000"));
        System.out.println("广播完成，交易hash=" + hash + "，交易金额="
                + Convert.fromWei("1000000000000000", Unit.ETHER));

        // BigDecimal a = new BigDecimal("10000000000000000000");
        // BigDecimal b = new BigDecimal("9999999999999999999");
        // System.out.println(a + " " + b);

        // BigDecimal balance = new BigDecimal("10000000000000000");
        // if (balance.compareTo(Convert.toWei("0.01", Unit.ETHER)) < 0) {
        // throw new BizException("xn625000", "余额太少，无需归集");
        // }
    }

    public static void getBalance() {
        EthAccount account = new EthAccount();
        BigDecimal ba = account
            .getBalance("0xb1cd852c72141bdac6ccf314d9ea82d2af03f2ac");
        System.out.print(ba);
    }

    public static void queryAccount() {
        EthAccount account = new EthAccount();
        List<String> accounts = account.getAccountlist();
        for (String accountId : accounts) {
            System.out.println(accountId);
        }

    }

    public static void createAccount() {
        EthAccount account = new EthAccount();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setPhone("229787499");
        accountInfo.setAddress("世宁大厦");
        accountInfo.setSchool("buaa");
        accountInfo.setUserName("lzh");
        String accountId = account.createAccount("lzh", "123456", accountInfo);
        System.out.println("注册账户成功:" + accountId);
        // PersonalAccountsInfo.AccountsInfo accountsInfo =
        // account.getAccountInfo("0xad7bbca86e02e503076b06931e05938e51e49fb9");
        // System.out.println(accountsInfo.toString());
    }

    public static String broadcast(String from, String fromPassword, String to,
            BigDecimal value) {
        Web3j web3j = Web3j.build(new HttpService(
            "https://mainnet.infura.io/ZJR3JJlmLyf5mg4A9UxA"));
        String txHash = null;
        try {
            String fileDirPath = "/Users/haiqingzheng/Desktop/ethereum/beikeying/data/keystore";
            File keyStoreFileDir = new File(fileDirPath);
            File[] subFiles = keyStoreFileDir.listFiles();
            File keystoreFile = null;
            for (File file : subFiles) {
                if (file.isDirectory() != true) {
                    // from: 0x244eb6078add0d58b2490ae53976d80f54a404ae
                    if (file.getName().endsWith(from.substring(2))) {
                        // 找到了该文件
                        keystoreFile = file;
                        break;
                    }
                }
            }
            if (keystoreFile == null) {
                throw new BizException("xn6250000", "未找到keystore文件");
            }
            //
            Credentials credentials = WalletUtils.loadCredentials(fromPassword,
                keystoreFile);
            //
            EthGetTransactionCount ethGetTransactionCount = web3j
                .ethGetTransactionCount(from, DefaultBlockParameterName.LATEST)
                .sendAsync().get();
            //
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            // TODO 动态获取
            BigInteger gasLimit = BigInteger.valueOf(30000);
            BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();

            // 本地签名的
            RawTransaction rawTransaction = RawTransaction.createTransaction(
                nonce, gasPrice, gasLimit, to,
                new BigInteger(value.toString()), "");

            // 签名
            byte[] signedMessage = TransactionEncoder.signMessage(
                rawTransaction, credentials);
            txHash = Numeric.toHexString(signedMessage);
            EthSendTransaction ethSendTransaction = web3j
                .ethSendRawTransaction(txHash).sendAsync().get();

            if (ethSendTransaction.getError() != null) {
                // failure
            }
            txHash = ethSendTransaction.getTransactionHash();

        } catch (Exception e) {
            throw new BizException("xn625000", "交易广播异常" + e.getMessage());
        }
        return txHash;
        // success

    }

}
