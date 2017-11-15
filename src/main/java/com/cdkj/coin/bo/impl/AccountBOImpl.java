package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IExchangeCurrencyBO;
import com.cdkj.coin.bo.IJourBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.common.AmountUtil;
import com.cdkj.coin.core.AccountUtil;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IAccountDAO;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.HLOrder;
import com.cdkj.coin.enums.EAccountStatus;
import com.cdkj.coin.enums.EAccountType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.enums.EJourBizType;
import com.cdkj.coin.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 下午5:24:53 
 * @history:
 */
@Component
public class AccountBOImpl extends PaginableBOImpl<Account> implements
        IAccountBO {
    @Autowired
    private IAccountDAO accountDAO;

    @Autowired
    private IJourBO jourBO;

    @Autowired
    private IExchangeCurrencyBO exchangeCurrencyBO;

    @Override
    public String distributeAccount(String userId, String realName,
            EAccountType accountType, String currency, String systemCode,
            String companyCode) {
        String accountNumber = null;
        if (StringUtils.isNotBlank(systemCode)
                && StringUtils.isNotBlank(companyCode)
                && StringUtils.isNotBlank(userId)) {
            accountNumber = OrderNoGenerater.generate(EGeneratePrefix.Account
                .getCode());
            Account data = new Account();
            data.setAccountNumber(accountNumber);
            data.setUserId(userId);
            data.setRealName(realName);

            data.setType(accountType.getCode());
            data.setCurrency(currency);
            data.setStatus(EAccountStatus.NORMAL.getCode());
            data.setAmount(BigDecimal.ZERO);
            data.setFrozenAmount(BigDecimal.ZERO);

            data.setMd5(AccountUtil.md5(data.getAmount()));
            data.setAddAmount(BigDecimal.ZERO);
            data.setInAmount(BigDecimal.ZERO);
            data.setOutAmount(BigDecimal.ZERO);
            data.setCreateDatetime(new Date());

            data.setSystemCode(systemCode);
            data.setCompanyCode(companyCode);
            accountDAO.insert(data);
        }
        return accountNumber;
    }

    @Override
    public void changeAmount(String accountNumber, EChannelType channelType,
            String channelOrder, String payGroup, String refNo, String bizType,
            String bizNote, BigDecimal transAmount) {
        Account dbAccount = this.getAccount(accountNumber);
        BigDecimal nowAmount = dbAccount.getAmount().add(transAmount);
        // 特定账户余额可为负
        if (!dbAccount.getUserId().startsWith("SYS_USER")
                && nowAmount.compareTo(BigDecimal.ZERO) == -1) {
            System.out.println("error account:" + accountNumber + " dbAmount="
                    + dbAccount.getAmount() + " transAmount=" + transAmount
                    + " nowAmount=" + nowAmount);
            throw new BizException("xn000000", "账户余额不足");
        }
        // 记录流水
        String lastOrder = jourBO.addJour(dbAccount, channelType, channelOrder,
            payGroup, refNo, bizType, bizNote, transAmount);

        // 更改余额
        Account data = new Account();
        data.setAccountNumber(accountNumber);
        data.setAmount(nowAmount);
        data.setMd5(AccountUtil.md5(dbAccount.getMd5(), dbAccount.getAmount(),
            nowAmount));
        // 统计累计增加金额
        data.setAddAmount(dbAccount.getAddAmount());
        if (transAmount.compareTo(BigDecimal.ZERO) == 1) {
            data.setAddAmount(dbAccount.getAddAmount().add(transAmount));
        }
        // 统计累计充值金额
        data.setInAmount(dbAccount.getInAmount());
        if (EJourBizType.AJ_CHARGE.getCode().equals(bizType)) {
            data.setInAmount(dbAccount.getInAmount().add(transAmount));
        }
        data.setLastOrder(lastOrder);
        accountDAO.updateAmount(data);
    }

    @Override
    public void changeAmountNotJour(String accountNumber,
            BigDecimal transAmount, String lastOrder) {
        Account dbAccount = this.getAccount(accountNumber);
        BigDecimal nowAmount = dbAccount.getAmount().add(transAmount);
        if (!dbAccount.getUserId().startsWith("SYS_USER")
                && nowAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "账户余额不足");
        }
        // 更改余额
        Account data = new Account();
        data.setAccountNumber(accountNumber);
        data.setAmount(nowAmount);
        data.setMd5(AccountUtil.md5(dbAccount.getMd5(), dbAccount.getAmount(),
            nowAmount));

        // 更新统计金额
        data.setAddAmount(dbAccount.getAddAmount());
        if (transAmount.compareTo(BigDecimal.ZERO) == 1) {
            data.setAddAmount(dbAccount.getAddAmount().add(transAmount));
        }
        data.setInAmount(dbAccount.getInAmount());
        data.setLastOrder(lastOrder);
        accountDAO.updateAmount(data);
    }

    @Override
    public void changeAmountForHL(HLOrder order) {
        Account dbAccount = this.getAccount(order.getAccountNumber());
        BigDecimal nowAmount = dbAccount.getAmount().add(order.getAmount());
        // 记录流水
        String lastOrder = jourBO.addJourForHL(dbAccount, order);
        // 更改余额
        Account data = new Account();
        data.setAccountNumber(dbAccount.getAccountNumber());
        data.setAmount(nowAmount);
        data.setMd5(AccountUtil.md5(dbAccount.getMd5(), dbAccount.getAmount(),
            nowAmount));
        // 更新统计金额
        data.setAddAmount(dbAccount.getAddAmount());
        BigDecimal amount = order.getAmount();
        if (amount.compareTo(BigDecimal.ZERO) == 1) {
            data.setAddAmount(dbAccount.getAddAmount().add(amount));
        }
        data.setInAmount(dbAccount.getInAmount());
        data.setLastOrder(lastOrder);
        accountDAO.updateAmount(data);
    }

    @Override
    public void frozenAmount(Account dbAccount, BigDecimal freezeAmount,
            String withdrawCode) {
        if (freezeAmount.compareTo(BigDecimal.ZERO) == 0
                || freezeAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "冻结金额需大于0");
        }
        BigDecimal nowAmount = dbAccount.getAmount().subtract(freezeAmount);
        if (nowAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "账户余额不足");
        }
        // 记录流水
        String lastOrder = jourBO.addJour(dbAccount, EChannelType.Offline,
            null, null, withdrawCode, EJourBizType.AJ_WITHDRAW.getCode(),
            "线下取现", freezeAmount.negate());
        BigDecimal nowFrozenAmount = dbAccount.getFrozenAmount().add(
            freezeAmount);
        Account data = new Account();
        data.setAccountNumber(dbAccount.getAccountNumber());
        data.setAmount(nowAmount);
        data.setFrozenAmount(nowFrozenAmount);
        data.setMd5(AccountUtil.md5(dbAccount.getMd5(), dbAccount.getAmount(),
            nowAmount));
        data.setLastOrder(lastOrder);
        accountDAO.frozenAmount(data);
    }

    @Override
    public void unfrozenAmount(Account dbAccount, BigDecimal freezeAmount,
            String withdrawCode) {
        if (freezeAmount.compareTo(BigDecimal.ZERO) == 0
                || freezeAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "解冻金额需大于0");
        }
        BigDecimal nowFrozenAmount = dbAccount.getFrozenAmount().add(
            freezeAmount);
        if (nowFrozenAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "本次解冻会使账户冻结金额小于0");
        }

        // 记录流水
        String lastOrder = jourBO.addJour(dbAccount, EChannelType.Offline,
            null, null, withdrawCode, EJourBizType.AJ_WITHDRAW.getCode(),
            "线下取现失败退回", freezeAmount);
        Account data = new Account();
        data.setAccountNumber(dbAccount.getAccountNumber());
        data.setAmount(dbAccount.getAmount().add(freezeAmount));
        data.setFrozenAmount(nowFrozenAmount);
        data.setMd5(AccountUtil.md5(dbAccount.getMd5(), dbAccount.getAmount(),
            dbAccount.getAmount().add(freezeAmount)));
        data.setLastOrder(lastOrder);
        accountDAO.unfrozenAmount(data);
    }

    @Override
    public void cutFrozenAmount(Account dbAccount, BigDecimal freezeAmount) {
        if (freezeAmount.compareTo(BigDecimal.ZERO) == 0
                || freezeAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "解冻金额需大于0");
        }
        BigDecimal nowFrozenAmount = dbAccount.getFrozenAmount().subtract(
            freezeAmount);
        if (nowFrozenAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException("xn000000", "本次扣减会使账户冻结金额小于0");
        }
        Account data = new Account();
        data.setAccountNumber(dbAccount.getAccountNumber());
        data.setFrozenAmount(nowFrozenAmount);
        // 统计累计取现金额
        data.setOutAmount(dbAccount.getOutAmount().add(freezeAmount));
        accountDAO.cutFrozenAmount(data);
    }

    @Override
    public void refreshStatus(String accountNumber, EAccountStatus status) {
        if (StringUtils.isNotBlank(accountNumber)) {
            Account data = new Account();
            data.setAccountNumber(accountNumber);
            data.setStatus(status.getCode());
            accountDAO.updateStatus(data);
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        Account data = null;
        if (StringUtils.isNotBlank(accountNumber)) {
            Account condition = new Account();
            condition.setAccountNumber(accountNumber);
            data = accountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn702502", "无对应账户，请检查账号正确性");
            }
        }
        return data;
    }

    @Override
    public List<Account> queryAccountList(Account data) {
        return accountDAO.selectList(data);
    }

    /** 
     * @see com.std.account.bo.IAccountBO#getAccountByUser(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Account getAccountByUser(String userId, String currency) {
        Account data = null;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(currency)) {
            Account condition = new Account();
            condition.setUserId(userId);
            condition.setCurrency(currency);
            data = accountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn802000", "用户[" + userId + ";"
                        + currency + "]无此类型账户");
            }
        }
        return data;
    }

    /** 
     * @see com.std.account.bo.IAccountBO#refreshAccountName(java.lang.String, java.lang.String)
     */
    @Override
    public void refreshAccountName(String userId, String realName) {
        Account data = new Account();
        data.setUserId(userId);
        data.setRealName(realName);
        accountDAO.updateRealName(data);
    }

    /** 
     * @see com.std.account.bo.IAccountBO#getSysAccount(java.lang.String, java.lang.String)
     */
    @Override
    public Account getSysAccountNumber(String systemCode, String companyCode,
            ECurrency currency) {
        Account condition = new Account();
        // 平台账户只有一类,类型+币种+公司+系统=唯一系统账户
        condition.setType(EAccountType.Plat.getCode());
        condition.setSystemCode(systemCode);
        condition.setCompanyCode(companyCode);
        condition.setCurrency(currency.getCode());
        return accountDAO.select(condition);
    }

    @Override
    public void transAmountCZB(String fromUserId, String fromCurrency,
            String toUserId, String toCurrency, BigDecimal transAmount,
            String fromBizType, String toBizType, String fromBizNote,
            String toBizNote, String refNo) {
        Account fromAccount = this.getAccountByUser(fromUserId, fromCurrency);
        Account toAccount = this.getAccountByUser(toUserId, toCurrency);
        transAmountCZB(fromAccount, toAccount, transAmount, fromBizType,
            toBizType, fromBizNote, toBizNote, refNo);
    }

    private void transAmountCZB(Account fromAccount, Account toAccount,
            BigDecimal transAmount, String fromBizType, String toBizType,
            String fromBizNote, String toBizNote, String refNo) {
        String fromAccountNumber = fromAccount.getAccountNumber();
        String toAccountNumber = toAccount.getAccountNumber();
        if (fromAccountNumber.equals(toAccountNumber)) {
            new BizException("XN0000", "来去双方账号一致，无需内部划转");
        }
        Double rate = exchangeCurrencyBO.getExchangeRate(
            fromAccount.getCurrency(), toAccount.getCurrency());
        this.changeAmount(fromAccountNumber, EChannelType.NBZ, null, null,
            refNo, fromBizType, fromBizNote, transAmount.negate());
        this.changeAmount(toAccountNumber, EChannelType.NBZ, null, null, refNo,
            toBizType, toBizNote, AmountUtil.mul(transAmount, rate));
    }
}
