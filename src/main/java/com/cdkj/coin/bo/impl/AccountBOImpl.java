package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.dto.req.XN002050Req;
import com.cdkj.coin.dto.req.XN002100Req;
import com.cdkj.coin.dto.req.XN002610Req;
import com.cdkj.coin.dto.res.XN002050Res;
import com.cdkj.coin.enums.EBizType;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.http.BizConnecter;
import com.cdkj.coin.http.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    public Account getRemoteAccount(String userId, ECurrency currency) {
        XN002050Req req = new XN002050Req();
        req.setUserId(userId);
        req.setCurrency(currency.getCode());
        String jsonStr = BizConnecter.getBizData("002050",
            JsonUtils.object2Json(req));
        Gson gson = new Gson();
        List<XN002050Res> list = gson.fromJson(jsonStr,
            new TypeToken<List<XN002050Res>>() {
            }.getType());
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn000000", "用户[" + userId + "]账户不存在");
        }
        XN002050Res res = list.get(0);
        Account account = new Account();
        account.setAccountNumber(res.getAccountNumber());
        account.setUserId(res.getUserId());
        account.setRealName(res.getRealName());
        account.setType(res.getType());
        account.setStatus(res.getStatus());

        account.setCurrency(res.getCurrency());
        account.setAmount(res.getAmount());
        account.setFrozenAmount(res.getFrozenAmount());
        account.setCreateDatetime(res.getCreateDatetime());
        account.setLastOrder(res.getLastOrder());

        account.setSystemCode(res.getSystemCode());
        return account;
    }

    @Override
    public void doTransferAmountRemote(String fromUserId, String toUserId,
            ECurrency currency, BigDecimal amount, EBizType bizType,
            String fromBizNote, String toBizNote, String refNo) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) != 0) {
            XN002100Req req = new XN002100Req();
            req.setFromUserId(fromUserId);
            req.setFromCurrency(currency.getCode());
            req.setToUserId(toUserId);
            req.setToCurrency(currency.getCode());
            req.setTransAmount(amount.toString());
            req.setBizType(bizType.getCode());
            req.setFromBizNote(fromBizNote);
            req.setToBizNote(toBizNote);
            req.setRefNo(refNo);
            BizConnecter.getBizData("002100", JsonUtils.object2Json(req),
                Object.class);
        }
    }

    @Override
    public void doTransferAmountRemote(String fromUserId,
            ECurrency fromCurrency, String toUserId, ECurrency toCurrency,
            Long amount, EBizType bizType, String fromBizNote,
            String toBizNote, String refNo) {
        if (amount != null && amount != 0) {
            XN002100Req req = new XN002100Req();
            req.setFromUserId(fromUserId);
            req.setFromCurrency(fromCurrency.getCode());
            req.setToUserId(toUserId);
            req.setToCurrency(toCurrency.getCode());
            req.setTransAmount(String.valueOf(amount));
            req.setBizType(bizType.getCode());
            req.setFromBizNote(fromBizNote);
            req.setToBizNote(toBizNote);
            req.setRefNo(refNo);
            BizConnecter.getBizData("002100", JsonUtils.object2Json(req),
                Object.class);
        }
    }

    @Override
    public void changeAmount(String accountNumber, String channelType,
            String channelOrder, String payGroup, String refNo, String bizType,
            String bizNote, BigInteger transAmount) {
        XN002610Req req = new XN002610Req();
        req.setAccountNumber(accountNumber);
        req.setChannelType(channelType);
        req.setChannelOrder(channelOrder);
        req.setPayGroup(payGroup);
        req.setRefNo(refNo);
        req.setBizType(bizType);
        req.setBizNote(bizNote);
        req.setTransAmount(String.valueOf(transAmount));
        BizConnecter.getBizData("002610", JsonUtils.object2Json(req),
            Object.class);
    }
}
