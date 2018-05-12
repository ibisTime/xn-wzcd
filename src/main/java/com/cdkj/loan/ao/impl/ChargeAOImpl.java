package com.cdkj.loan.ao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IChargeAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IChargeBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Charge;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EChannelType;
import com.cdkj.loan.enums.EChargeStatus;
import com.cdkj.loan.enums.EJourBizTypeUser;
import com.cdkj.loan.exception.BizException;

@Service
public class ChargeAOImpl implements IChargeAO {
    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IChargeBO chargeBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String applyOrder(String accountNumber, BigDecimal amount,
            String payCardInfo, String payCardNo, String applyUser,
            String applyNote) {

        if (amount.compareTo(BigDecimal.ZERO) == 0
                || amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "充值金额需大于零");
        }

        Account account = accountBO.getAccount(accountNumber);

        // 生成充值订单
        String code = chargeBO.applyOrderOffline(account,
            EJourBizTypeUser.AJ_CHARGE.getCode(), amount, payCardInfo,
            payCardNo, applyUser, applyNote);

        return code;
    }

    @Override
    @Transactional
    public void payOrder(String code, String payUser, String payResult,
            String payNote) {
        Charge data = chargeBO.getCharge(code);
        if (!EChargeStatus.toPay.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "申请记录状态不是待支付状态，无法支付");
        }
        if (EBoolean.YES.getCode().equals(payResult)) {
            payOrderYES(data, payUser, payNote);
        } else {
            payOrderNO(data, payUser, payNote);
        }
    }

    private void payOrderNO(Charge data, String payUser, String payNote) {
        chargeBO.payOrder(data, false, payUser, payNote);
    }

    private void payOrderYES(Charge data, String payUser, String payNote) {

        chargeBO.payOrder(data, true, payUser, payNote);

        // 用户账户加钱
        Account userAccount = accountBO.getAccount(data.getAccountNumber());
        userAccount = accountBO.changeAmount(userAccount, data.getAmount(),
            EChannelType.Offline, null, null, data.getCode(),
            EJourBizTypeUser.AJ_CHARGE.getCode(), "线下充值");

    }

    @Override
    public Paginable<Charge> queryChargePage(int start, int limit,
            Charge condition) {
        Paginable<Charge> page = chargeBO.getPaginable(start, limit, condition);
        if (CollectionUtils.isNotEmpty(page.getList())) {
            List<Charge> list = page.getList();
            for (Charge charge : list) {
                User user = userBO.getUser(charge.getApplyUser());
                charge.setUser(user);
            }
        }
        return page;
    }

    @Override
    public List<Charge> queryChargeList(Charge condition) {
        List<Charge> list = chargeBO.queryChargeList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Charge charge : list) {
                User user = userBO.getUser(charge.getApplyUser());
                charge.setUser(user);
            }
        }
        return list;
    }

    @Override
    public Charge getCharge(String code) {
        Charge charge = chargeBO.getCharge(code);
        User user = userBO.getUser(charge.getApplyUser());
        charge.setUser(user);
        return charge;
    }
}
