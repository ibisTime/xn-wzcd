/**
 * @Title ParityClient.java 
 * @Package ethereum 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月18日 下午7:42:57 
 * @version V1.0   
 */
package com.cdkj.coin.eth;

import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;

import com.cdkj.coin.common.PropertiesUtil;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月18日 下午7:42:57 
 * @history:
 */
public class ParityClient {

    private static String createIp = PropertiesUtil.Config.ETH_CREATE_URL;

    private static String tradeIp = PropertiesUtil.Config.ETH_TRADE_URL;

    private ParityClient() {
    }

    private static class ClientHolder {
        private static final Parity creaateParity = Parity
            .build(new HttpService(createIp));

        private static final Parity tradeParity = Parity.build(new HttpService(
            tradeIp));
    }

    public static final Parity getCreateParity() {
        return ClientHolder.creaateParity;
    }

    public static final Parity getTradeParity() {
        return ClientHolder.tradeParity;
    }
}
