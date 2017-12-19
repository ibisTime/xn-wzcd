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
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月18日 下午7:49:59 
 * @history:
 */
public class AccountTest {

    public static void main(String args[]) {
        // String hash = broadcast("0x3a7b569f809cbe7e63ebfb02c313bc9a34d5e5c8",
        // "12345678", "0x1bb4fd555fdcdbf365c5fc3d549f5647a631adae",
        // new BigDecimal("1000000000000000"));
        // System.out.println("广播完成，交易hash=" + hash + "，交易金额="
        // + Convert.fromWei("1000000000000000", Unit.ETHER));

        // BigDecimal a = new BigDecimal("10000000000000000000");
        // BigDecimal b = new BigDecimal("9999999999999999999");
        // System.out.println(a + " " + b);

        // BigDecimal balance = new BigDecimal("10000000000000000");
        // if (balance.compareTo(Convert.toWei("0.01", Unit.ETHER)) < 0) {
        // throw new BizException("xn625000", "余额太少，无需归集");
        // }

        createAccount();
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

        Admin selfAdmin = Admin.build(new HttpService(
            "http://47.96.161.183:8545"));
        NewAccountIdentifier newAccountIdentifier;
        try {
            newAccountIdentifier = selfAdmin.personalNewAccount("123456")
                .send();
            if (newAccountIdentifier != null) {
                String address = newAccountIdentifier.getAccountId();
                System.out.println(address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
