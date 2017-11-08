/**
 * @Title EthTransactionAOImpl.java 
 * @Package com.cdkj.coin.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月7日 下午8:33:42 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IChargeAO;
import com.cdkj.coin.ao.IEthTransactionAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IChargeBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.Charge;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.eth.CtqEthTransaction;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月7日 下午8:33:42 
 * @history:
 */
@Service
public class EthTransactionAOImpl implements IEthTransactionAO {

    @Autowired
    private IChargeBO chargeBO;

    @Autowired
    private IChargeAO chargeAO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Override
    @Transactional
    public void charge(CtqEthTransaction ctqEthTransaction) {
        EthAddress ethAddress = ethAddressBO.getEthAddress(EEthAddressType.X,
            ctqEthTransaction.getTo());
        if (ethAddress == null) {
            throw new BizException("xn6250000", "充值地址不存在");
        }
        Charge condition = new Charge();
        condition.setRefNo(ctqEthTransaction.getHash());
        if (chargeBO.getTotalCount(condition) > 0) {
            return;
        }
        Account account = accountBO.getAccountByUser(ethAddress.getUserId(),
            ECurrency.ETH.getCode());
        String payGroup = OrderNoGenerater.generate("PG");
        BigDecimal amount = new BigDecimal(ctqEthTransaction.getValue());
        // 充值订单落地
        String code = chargeBO.applyOrderOnline(account, payGroup,
            ctqEthTransaction.getHash(), EBizType.AJ_CHARGE, "ETH充值-来自地址："
                    + ctqEthTransaction.getFrom(), amount, EChannelType.ETH,
            "程序");
        // Charge data = chargeBO.getCharge(code, ESystemCode.COIN.getCode());
        // 账户加钱
        accountBO.changeAmount(account.getAccountNumber(), EChannelType.ETH,
            ctqEthTransaction.getHash(), payGroup, code, EBizType.AJ_CHARGE,
            "ETH充值-来自地址：" + ctqEthTransaction.getFrom(), amount);
        // 落地交易记录
        ethTransactionBO.saveEthTransaction(ctqEthTransaction);
    }
}
