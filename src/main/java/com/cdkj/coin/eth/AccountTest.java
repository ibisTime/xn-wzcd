/**
 * @Title AccountTest.java 
 * @Package ethereum 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月18日 下午7:49:59 
 * @version V1.0   
 */
package com.cdkj.coin.eth;

import java.math.BigInteger;
import java.util.List;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月18日 下午7:49:59 
 * @history:
 */
public class AccountTest {

    public static void main(String args[]) {
        createAccount();
        // queryAccount();
        // getBalance();
    }

    public static void getBalance() {
        EthAccount account = new EthAccount();
        BigInteger ba = account
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
}
