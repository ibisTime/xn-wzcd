package com.cdkj.loan.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IChargeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IChargeDAO;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Charge;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EChannelType;
import com.cdkj.loan.enums.EChargeStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class ChargeBOImpl extends PaginableBOImpl<Charge> implements IChargeBO {
    @Autowired
    private IChargeDAO chargeDAO;

    @Override
    public String applyOrderOffline(Account account, String bizType,
            BigDecimal amount, String payCardInfo, String payCardNo,
            String applyUser, String applyNote) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "充值金额不能为0");
        }
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.Charge.getCode());
        Charge data = new Charge();
        data.setCode(code);
        data.setPayGroup(null);
        data.setRefNo(null);
        data.setAccountNumber(account.getAccountNumber());
        data.setAmount(amount);

        data.setAccountName(account.getRealName());
        data.setType(account.getType());
        data.setCurrency(account.getCurrency());
        data.setBizType(bizType);
        data.setPayCardInfo(payCardInfo);
        data.setPayCardNo(payCardNo);

        data.setStatus(EChargeStatus.toPay.getCode());
        data.setApplyUser(applyUser);
        data.setApplyDatetime(new Date());
        data.setApplyNote(applyNote);
        data.setChannelType(EChannelType.Offline.getCode());
        chargeDAO.insert(data);
        return code;
    }

    @Override
    public String applyOrderOnline(Account account, String payGroup,
            String refNo, String bizType, String bizNote,
            BigDecimal transAmount, EChannelType channelType, String applyUser,
            String fromAddress) {
        if (transAmount.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException("xn000000", "充值金额不能为0");
        }
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.Charge.getCode());
        Charge data = new Charge();
        data.setCode(code);
        data.setPayGroup(payGroup);
        data.setRefNo(refNo);
        data.setAccountNumber(account.getAccountNumber());
        data.setAmount(transAmount);

        data.setAccountName(account.getRealName());
        data.setType(account.getType());
        data.setCurrency(account.getCurrency());
        data.setBizType(bizType);
        data.setBizNote(bizNote);
        data.setPayCardInfo("ETH");
        data.setPayCardNo(fromAddress);

        data.setStatus(EChargeStatus.Pay_YES.getCode());
        data.setApplyUser(applyUser);
        data.setApplyDatetime(new Date());
        data.setChannelType(channelType.getCode());
        chargeDAO.insert(data);
        return code;
    }

    @Override
    public void payOrder(Charge data, boolean booleanFlag, String payUser,
            String payNote) {
        if (booleanFlag) {
            data.setStatus(EChargeStatus.Pay_YES.getCode());
        } else {
            data.setStatus(EChargeStatus.Pay_NO.getCode());
        }
        data.setPayUser(payUser);
        data.setPayNote(payNote);
        data.setPayDatetime(new Date());
        chargeDAO.payOrder(data);
    }

    @Override
    public void callBackChange(Charge dbCharge, boolean booleanFlag) {
        if (booleanFlag) {
            dbCharge.setStatus(EChargeStatus.Pay_YES.getCode());
        } else {
            dbCharge.setStatus(EChargeStatus.Pay_NO.getCode());
        }
        dbCharge.setPayUser(null);
        dbCharge.setPayNote("在线充值自动回调");
        dbCharge.setPayDatetime(new Date());
        chargeDAO.payOrder(dbCharge);

    }

    @Override
    public List<Charge> queryChargeList(Charge condition) {
        return chargeDAO.selectList(condition);
    }

    @Override
    public Charge getCharge(String code) {
        Charge order = null;
        if (StringUtils.isNotBlank(code)) {
            Charge condition = new Charge();
            condition.setCode(code);
            order = chargeDAO.select(condition);
            if (null == order) {
                throw new BizException("xn000000", "订单号[" + code + "]不存在");
            }
        }
        return order;
    }
}
