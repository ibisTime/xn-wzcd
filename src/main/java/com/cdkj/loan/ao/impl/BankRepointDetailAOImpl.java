package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankRepointDetailAO;
import com.cdkj.loan.bo.IBankRepointDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BankRepointDetail;
import com.cdkj.loan.exception.BizException;

@Service
public class BankRepointDetailAOImpl implements IBankRepointDetailAO {

    @Autowired
    private IBankRepointDetailBO bankRepointDetailBO;

    @Override
    public String addBankRepointDetail(BankRepointDetail data) {
        return bankRepointDetailBO.saveBankRepointDetail(data);
    }

    @Override
    public int editBankRepointDetail(BankRepointDetail data) {
        if (!bankRepointDetailBO.isBankRepointDetailExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankRepointDetailBO.refreshBankRepointDetail(data);
    }

    @Override
    public int dropBankRepointDetail(String code) {
        if (!bankRepointDetailBO.isBankRepointDetailExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankRepointDetailBO.removeBankRepointDetail(code);
    }

    @Override
    public Paginable<BankRepointDetail> queryBankRepointDetailPage(int start,
            int limit, BankRepointDetail condition) {
        return bankRepointDetailBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BankRepointDetail> queryBankRepointDetailList(
            BankRepointDetail condition) {
        return bankRepointDetailBO.queryBankRepointDetailList(condition);
    }

    @Override
    public BankRepointDetail getBankRepointDetail(String code) {
        return bankRepointDetailBO.getBankRepointDetail(code);
    }

    @Override
    public void entryRepointAmount(String code, String amount, String billPdf,
            String operator) {
        BankRepointDetail data = new BankRepointDetail();
        data.setBankRepointCode(code);
        data.setAmount(StringValidater.toLong(amount));
        data.setSettleDatetime(new Date());// 前端没有填写 所以获取当前系统当前时间作为到账时间
        data.setBillPdf(billPdf);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        bankRepointDetailBO.saveBankRepointDetail(data);
        // 日志待定
    }
}
