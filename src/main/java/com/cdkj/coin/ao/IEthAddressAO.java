/**
 * @Title IEthAddressAO.java 
 * @Package com.cdkj.coin.ao 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月27日 下午5:38:33 
 * @version V1.0   
 */
package com.cdkj.coin.ao;

import com.cdkj.coin.enums.EEthAddressType;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月27日 下午5:38:33 
 * @history:
 */
public interface IEthAddressAO {

    // 定时器调用：每隔**同步账户流水
    public void doEthTransactionSync();

    // 根据地址获取地址类型
    public EEthAddressType getType(String address);

    // 生成地址（有私钥）
    public String generateMAddress();
}
