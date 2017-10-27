/**
 * @Title Web3JClient.java 
 * @Package ethereum 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月18日 下午7:37:41 
 * @version V1.0   
 */
package com.cdkj.coin.eth;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月18日 下午7:37:41 
 * @history:
 */
public class Web3JClient {

    private static String ip = "http://116.62.6.195:8545/";

    private Web3JClient() {
    }

    private volatile static Web3j web3j;

    public static Web3j getClient() {
        if (web3j == null) {
            synchronized (Web3JClient.class) {
                if (web3j == null) {
                    web3j = Web3j.build(new HttpService(ip));
                }
            }
        }
        return web3j;
    }
}
