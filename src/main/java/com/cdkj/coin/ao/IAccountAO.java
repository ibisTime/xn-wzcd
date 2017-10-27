/**
 * @Title IAccountAO.java 
 * @Package com.std.user.ao 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月10日 上午11:08:04 
 * @version V1.0   
 */
package com.cdkj.coin.ao;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.coin.domain.Account;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月10日 上午11:08:04 
 * @history:
 */
public interface IAccountAO {

    public List<Account> getAccountByUserId(String userId);

    // 以太币划转
    public void transfer(String fromUserId, String toAddress, BigDecimal amount);
}
