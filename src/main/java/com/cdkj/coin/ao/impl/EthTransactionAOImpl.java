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

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.cdkj.coin.ao.IEthTransactionAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IChargeBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthCollectionBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.IWithdrawBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.Charge;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.EthCollection;
import com.cdkj.coin.domain.Withdraw;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.enums.EEthCollectionStatus;
import com.cdkj.coin.enums.EJourBizTypeCold;
import com.cdkj.coin.enums.EJourBizTypePlat;
import com.cdkj.coin.enums.EJourBizTypeUser;
import com.cdkj.coin.enums.ESystemAccount;
import com.cdkj.coin.enums.EWithdrawStatus;
import com.cdkj.coin.eth.CtqEthTransaction;
import com.cdkj.coin.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月7日 下午8:33:42 
 * @history:
 */
@Service
public class EthTransactionAOImpl implements IEthTransactionAO {

    private static final Logger logger = LoggerFactory
        .getLogger(EthTransactionAOImpl.class);

    @Autowired
    private IChargeBO chargeBO;

    @Autowired
    private IWithdrawBO withdrawBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Autowired
    private IEthCollectionBO ethCollectionBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    @Transactional
    public String chargeNotice(CtqEthTransaction ctqEthTransaction) {
        EthAddress ethAddress = ethAddressBO.getEthAddress(EEthAddressType.X,
            ctqEthTransaction.getTo());
        if (ethAddress == null) {
            throw new BizException("xn6250000", "充值地址不存在");
        }
        Charge condition = new Charge();
        condition.setRefNo(ctqEthTransaction.getHash());
        if (chargeBO.getTotalCount(condition) > 0) {
            return "";
        }
        Account account = accountBO.getAccountByUser(ethAddress.getUserId(),
            ECoin.ETH.getCode());
        String payGroup = OrderNoGenerater.generate("PG");
        BigDecimal amount = new BigDecimal(ctqEthTransaction.getValue());
        // 充值订单落地
        String code = chargeBO.applyOrderOnline(account, payGroup,
            ctqEthTransaction.getHash(), EJourBizTypeUser.AJ_CHARGE.getCode(),
            "ETH充值-来自地址：" + ctqEthTransaction.getFrom(), amount,
            EChannelType.ETH, "程序");
        // 账户加钱
        accountBO.changeAmount(account.getAccountNumber(), EChannelType.ETH,
            ctqEthTransaction.getHash(), payGroup, code,
            EJourBizTypeUser.AJ_CHARGE.getCode(), "ETH充值-来自地址："
                    + ctqEthTransaction.getFrom(), amount);
        // 落地交易记录
        ethTransactionBO.saveEthTransaction(ctqEthTransaction);
        return code;
    }

    @Override
    @Transactional
    public void withdrawNotice(CtqEthTransaction ctqEthTransaction) {
        // 根据交易hash查询取现订单
        Withdraw withdraw = withdrawBO.getWithdraw(ctqEthTransaction.getHash());
        if (withdraw == null) {
            return;
        }
        // 计算矿工费
        BigDecimal gasPrice = new BigDecimal(ctqEthTransaction.getGasPrice());
        BigDecimal gasUse = new BigDecimal(ctqEthTransaction.getGas()
            .toString());
        BigDecimal txFee = gasPrice.multiply(gasUse);
        // 取现订单更新
        withdrawBO.payOrder(withdraw, EWithdrawStatus.Pay_YES,
            ctqEthTransaction.getFrom(), "广播成功", ctqEthTransaction.getHash(),
            ctqEthTransaction.getHash(), txFee);
        Account userAccount = accountBO.getAccount(withdraw.getAccountNumber());
        // 取现金额解冻
        accountBO.unfrozenAmount(userAccount, withdraw.getAmount(),
            EJourBizTypeUser.AJ_WITHDRAW.getCode(),
            EJourBizTypeUser.AJ_WITHDRAW.getValue(), withdraw.getCode());
        if (withdraw.getFee().compareTo(BigDecimal.ZERO) > 0) {
            // 取现手续费解冻
            accountBO.unfrozenAmount(userAccount, withdraw.getFee(),
                EJourBizTypeUser.AJ_WITHDRAWFEE.getCode(),
                EJourBizTypeUser.AJ_WITHDRAWFEE.getValue(), withdraw.getCode());
        }
        // 取现金额扣减
        accountBO.changeAmount(withdraw.getAccountNumber(), EChannelType.ETH,
            ctqEthTransaction.getHash(), "ETH", withdraw.getCode(),
            EJourBizTypeUser.AJ_WITHDRAW.getCode(),
            EJourBizTypeUser.AJ_WITHDRAW.getValue(), withdraw.getAmount()
                .negate());
        if (withdraw.getFee().compareTo(BigDecimal.ZERO) > 0) {
            // 取现手续费扣减
            accountBO.changeAmount(withdraw.getAccountNumber(),
                EChannelType.ETH, ctqEthTransaction.getHash(), "ETH", withdraw
                    .getCode(), EJourBizTypeUser.AJ_WITHDRAWFEE.getCode(),
                EJourBizTypeUser.AJ_WITHDRAWFEE.getValue(), withdraw.getFee()
                    .negate());
        }
        // 平台冷钱包减钱
        accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH_COLD.getCode(),
            EChannelType.ETH, ctqEthTransaction.getHash(), "ETH", withdraw
                .getCode(), EJourBizTypeCold.AJ_PAY.getCode(), "ETH取现-外部地址："
                    + withdraw.getPayCardNo(), withdraw.getAmount().negate());
        // 平台盈亏账户记入取现手续费
        if (withdraw.getFee().compareTo(BigDecimal.ZERO) > 0) {
            accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH.getCode(),
                EChannelType.ETH, ctqEthTransaction.getHash(), "ETH",
                withdraw.getCode(), EJourBizTypePlat.AJ_WITHDRAWFEE.getCode(),
                "ETH取现-外部地址" + withdraw.getPayCardNo(), withdraw.getFee());
        }
        // 平台盈亏账户记入取现矿工费
        accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH.getCode(),
            EChannelType.ETH, ctqEthTransaction.getHash(), "ETH",
            withdraw.getCode(), EJourBizTypePlat.AJ_WFEE.getCode(),
            "ETH取现-外部地址" + withdraw.getPayCardNo(), txFee.negate());
        // 落地交易记录
        ethTransactionBO.saveEthTransaction(ctqEthTransaction);
    }

    @Override
    @Transactional
    public void collection(String address, String chargeCode) {
        // 获取地址信息
        EthAddress xEthAddress = ethAddressBO.getEthAddress(EEthAddressType.X,
            address);
        if (xEthAddress == null) {
            throw new BizException("xn625000", "该地址不能归集");
        }
        BigDecimal limit = sysConfigBO
            .getBigDecimalValue(SysConstants.COLLECTION_LIMIT);
        BigDecimal balance = ethAddressBO.getEthBalance(address);
        // 余额大于配置值时，进行归集
        if (balance.compareTo(Convert.toWei(limit, Unit.ETHER)) < 0) {
            throw new BizException("xn625000", "余额太少，无需归集");
        }
        // 获取今日归集地址
        EthAddress wEthAddress = ethAddressBO.getWEthAddressToday();
        String toAddress = wEthAddress.getAddress();
        // 预估矿工费用
        BigDecimal gasPrice = ethTransactionBO.getGasPrice();
        BigDecimal gasUse = new BigDecimal(21000);
        BigDecimal txFee = gasPrice.multiply(gasUse);
        BigDecimal value = balance.subtract(txFee);
        logger.info("地址余额=" + balance + "，以太坊平均价格=" + gasPrice + "，预计矿工费="
                + txFee + "，预计到账金额=" + value);
        if (value.compareTo(BigDecimal.ZERO) < 0
                || value.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException("xn625000", "余额不足以支付矿工费，不能归集");
        }
        // 归集广播
        String txHash = ethTransactionBO.broadcast(address,
            xEthAddress.getPassword(), toAddress, value);
        if (StringUtils.isBlank(txHash)) {
            throw new BizException("xn625000", "归集—交易广播失败");
        }
        // 归集记录落地
        ethCollectionBO.saveEthCollection(address, toAddress, value, txHash,
            chargeCode);

    }

    @Override
    @Transactional
    public void collectionNotice(CtqEthTransaction ctqEthTransaction) {
        // 根据交易hash查询归集记录
        EthCollection collection = ethCollectionBO
            .getEthCollectionByTxHash(ctqEthTransaction.getHash());
        if (!EEthCollectionStatus.Broadcast.getCode().equals(
            collection.getStatus())) {
            throw new BizException("xn625000", "交易已处理，请勿重复处理");
        }
        // 归集订单状态更新
        BigDecimal gasPrice = new BigDecimal(ctqEthTransaction.getGasPrice());
        BigDecimal gasUse = new BigDecimal(ctqEthTransaction.getGas()
            .toString());
        BigDecimal txFee = gasPrice.multiply(gasUse);
        ethCollectionBO.colectionNotice(collection, txFee,
            ctqEthTransaction.getBlockCreateDatetime());
        // 平台冷钱包加钱
        accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH_COLD.getCode(),
            EChannelType.ETH, ctqEthTransaction.getHash(), "ETH", collection
                .getCode(), EJourBizTypeCold.AJ_INCOME.getCode(), "归集-来自地址："
                    + collection.getFromAddress(), new BigDecimal(
                ctqEthTransaction.getValue()));
        // 平台盈亏账户记入矿工费
        accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH.getCode(),
            EChannelType.ETH, ctqEthTransaction.getHash(), "ETH",
            collection.getCode(), EJourBizTypePlat.AJ_MFEE.getCode(), "归集地址："
                    + collection.getFromAddress(), txFee.negate());
        // 落地交易记录
        ethTransactionBO.saveEthTransaction(ctqEthTransaction);
    }

}
