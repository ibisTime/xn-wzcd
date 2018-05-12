package com.cdkj.loan.bo;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Withdraw;
import com.cdkj.loan.enums.EWithdrawStatus;

public interface IWithdrawBO extends IPaginableBO<Withdraw> {

    public void doCheckTimes(Account account);

    String applyOrder(Account account, BigDecimal amount, BigDecimal fee,
            String payCardInfo, String payCardNo, String applyUser,
            String applyNote);

    void approveOrder(Withdraw data, EWithdrawStatus status, String approveUser,
            String approveNote);

    void payOrder(Withdraw data, EWithdrawStatus status, String payUser,
            String payNote, String channelOrder, String payCode,
            BigDecimal payFee);

    List<Withdraw> queryWithdrawList(Withdraw condition);

    public Withdraw getWithdraw(String code);

    public BigDecimal getTotalWithdraw();
}
