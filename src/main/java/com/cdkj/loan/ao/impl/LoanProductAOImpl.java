package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IChannelBankAO;
import com.cdkj.loan.ao.ILoanProductAO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EProductStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:59:00 
 * @history:
 */
@Service
public class LoanProductAOImpl implements ILoanProductAO {
    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private IChannelBankAO channelBankAOImpl;

    @Override
    public String saveLoanProduct(XN632170Req req) {
        ChannelBank channelBank = channelBankAOImpl
            .getChannelBank(StringValidater.toLong(req.getLoanBank()));
        if (null == channelBank) {
            throw new BizException("xn0000", "银行信息不存在。");
        }

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.LOAN_PRODUCT.getCode());
        LoanProduct data = new LoanProduct();
        data.setCode(code);
        data.setName(req.getName());
        data.setLoanBank(req.getLoanBank());
        data.setGpsFee(
            AmountUtil.mul(StringValidater.toLong(req.getGpsFee()), 1000L));
        data.setAuthFee(
            AmountUtil.mul(StringValidater.toLong(req.getAuthFee()), 1000L));

        data.setFee(
            AmountUtil.mul(StringValidater.toLong(req.getFee()), 1000L));
        data.setMonthRate(StringValidater.toDouble(req.getMonthRate()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setStatus(EProductStatus.TO_PUBLISH.getCode());
        loanProductBO.saveLoanProduct(data);

        return code;
    }

    @Override
    public void dropLoanProduct(String code) {
        loanProductBO.dropLoanProduct(code);
    }

    @Override
    public void editLoanProduct(XN632172Req req) {
        ChannelBank channelBank = channelBankAOImpl
            .getChannelBank(StringValidater.toLong(req.getLoanBank()));
        if (null == channelBank) {
            throw new BizException("xn0000", "银行信息不存在。");
        }

        LoanProduct data = new LoanProduct();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setLoanBank(req.getLoanBank());
        data.setGpsFee(
            AmountUtil.mul(StringValidater.toLong(req.getGpsFee()), 1000L));
        data.setAuthFee(
            AmountUtil.mul(StringValidater.toLong(req.getAuthFee()), 1000L));

        data.setFee(
            AmountUtil.mul(StringValidater.toLong(req.getFee()), 1000L));
        data.setMonthRate(StringValidater.toDouble(req.getMonthRate()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        loanProductBO.editLoanProduct(data);
    }

    @Override
    public void publishYesLoanProduct(String code, String updater) {
        loanProductBO.publishYesLoanProduct(code, updater);
    }

    @Override
    public void publishNoLoanProduct(String code, String updater) {
        loanProductBO.publishNoLoanProduct(code, updater);
    }

    @Override
    public Paginable<LoanProduct> queryLoanProductPage(int start, int limit,
            LoanProduct condition) {
        Paginable<LoanProduct> page = loanProductBO.getPaginable(start, limit,
            condition);
        List<LoanProduct> loanProductList = page.getList();
        ChannelBank channelBank = null;
        for (LoanProduct loanProduct : loanProductList) {
            channelBank = channelBankAOImpl.getChannelBank(
                StringValidater.toLong(loanProduct.getLoanBank()));
            loanProduct.setLoanBankName(channelBank.getBankName());
        }

        return page;
    }

    @Override
    public List<LoanProduct> queryLoanProductList(LoanProduct condition) {
        List<LoanProduct> loanProductList = loanProductBO
            .queryLoanProductList(condition);
        ChannelBank channelBank = null;

        for (LoanProduct loanProduct : loanProductList) {
            channelBank = channelBankAOImpl.getChannelBank(
                StringValidater.toLong(loanProduct.getLoanBank()));
            loanProduct.setLoanBankName(channelBank.getBankName());
        }

        return loanProductList;
    }

    @Override
    public LoanProduct getLoanProduct(String code) {
        LoanProduct loanProduct = loanProductBO.getLoanProduct(code);
        ChannelBank channelBank = channelBankAOImpl
            .getChannelBank(StringValidater.toLong(loanProduct.getLoanBank()));
        loanProduct.setLoanBankName(channelBank.getBankName());
        return loanProduct;
    }
}
