/**
 * @Title IEthTransactionAO.java 
 * @Package com.cdkj.coin.ao 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月7日 下午8:32:00 
 * @version V1.0   
 */
package com.cdkj.coin.ao;

import com.cdkj.coin.eth.CtqEthTransaction;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月7日 下午8:32:00 
 * @history:
 */
public interface IEthTransactionAO {

    // 充值
    public void charge(CtqEthTransaction ctqEthTransaction);
}
