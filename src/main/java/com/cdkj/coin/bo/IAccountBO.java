/**
 * @Title IAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cdkj.coin.domain.Account;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.ECurrency;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:15:49 
 * @history:
 */
public interface IAccountBO {

    // 根据用户编号和币种获取账户
    public Account getRemoteAccount(String userId, ECurrency currency);

    // 根据用户编号进行账户资金划转
    public void doTransferAmountRemote(String fromUserId, String toUserId,
            ECurrency currency, BigDecimal amount, EBizType bizType,
            String fromBizNote, String toBizNote, String refNo);

    public void doTransferAmountRemote(String fromUserId,
            ECurrency fromCurrency, String toUserId, ECurrency toCurrency,
            Long amount, EBizType bizType, String fromBizNote,
            String toBizNote, String refNo);

    public void changeAmount(String accountNumber, String channelType,
            String channelOrder, String payGroup, String refNo, String bizType,
            String bizNote, BigInteger transAmount);

}
