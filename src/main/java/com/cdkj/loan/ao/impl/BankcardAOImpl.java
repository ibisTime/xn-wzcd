package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IChannelBankBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN802010Req;
import com.cdkj.loan.dto.req.XN802012Req;
import com.cdkj.loan.dto.req.XN802013Req;
import com.cdkj.loan.enums.EBankcard;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * @author: asus 
 * @since: 2016年12月22日 下午5:35:09 
 * @history:
 */
@Service
public class BankcardAOImpl implements IBankcardAO {

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

    @Autowired
    private IChannelBankBO channelBankBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addBankcard(XN802010Req req) {
        // 判断卡号是否重复
        List<Bankcard> list = bankcardBO.queryBankcardList(req.getUserId());
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您已绑定银行卡,无需绑定多张");
        }

        Bankcard data = new Bankcard();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.BANKCARD.getCode());

        data.setCode(code);
        data.setUserId(req.getUserId());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());

        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBindMobile(req.getBindMobile());
        data.setCreateDatetime(new Date());
        data.setStatus(EBankcard.NORMAL.getCode());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return bankcardBO.saveBankcard(data);
    }

    @Override
    public void dropBankcard(String code) {
        bankcardBO.removeBankcard(code);
    }

    @Override
    public void editBankcard(XN802012Req req) {
        Bankcard bankcard = bankcardBO.getBankcard(req.getCode());
        if (!bankcard.getBankcardNumber().equals(req.getBankcardNumber())) { // 有修改就去判断是否唯一
            List<Bankcard> list = bankcardBO
                .queryBankcardList(bankcard.getUserId());
            for (Bankcard card : list) {
                if (req.getBankcardNumber().equals(card.getBankcardNumber())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "银行卡号已存在");
                }
            }
        }
        Bankcard data = new Bankcard();
        data.setCode(req.getCode());
        // 户名有传就修改，不传不修改
        if (StringUtils.isBlank(req.getRealName())) {
            data.setRealName(bankcard.getRealName());
        } else {
            data.setRealName(req.getRealName());
        }
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBankCode(req.getBankCode());
        String bankName = null;
        if ("C".equals(req.getType())) {
            bankName = channelBankBO.getChannelBank(req.getBankCode())
                .getBankName();
        } else {
            bankName = bankSubbranchBO.getBankSubbranch(req.getBankCode())
                .getFullName();
        }
        data.setBankName(bankName);
        data.setSubbranch(req.getSubbranch());
        data.setBindMobile(req.getBindMobile());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        bankcardBO.refreshBankcard(data);
    }

    @Override
    public void editBankcard(XN802013Req req) {
        Bankcard bankcard = bankcardBO.getBankcard(req.getCode());
        userBO.checkTradePwd(bankcard.getUserId(), req.getTradePwd());
        if (!bankcard.getBankcardNumber().equals(req.getBankcardNumber())) { // 有修改就去判断是否唯一
            List<Bankcard> list = bankcardBO
                .queryBankcardList(bankcard.getUserId());
            for (Bankcard card : list) {
                if (req.getBankcardNumber().equals(card.getBankcardNumber())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "银行卡号已存在");
                }
            }
        }
        Bankcard data = new Bankcard();
        // 户名有传就修改，不传不修改
        if (StringUtils.isBlank(req.getRealName())) {
            data.setRealName(bankcard.getRealName());
        } else {
            data.setRealName(req.getRealName());
        }
        data.setCode(req.getCode());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBankCode(req.getBankCode());
        Bank bank = bankBO.getBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBindMobile(req.getBindMobile());
        data.setRemark(req.getRemark());
        bankcardBO.refreshBankcard(data);
    }

    @Override
    public Paginable<Bankcard> queryBankcardPage(int start, int limit,
            Bankcard condition) {
        return bankcardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Bankcard> queryBankcardList(Bankcard condition) {
        return bankcardBO.queryBankcardList(condition);
    }

    @Override
    public Bankcard getBankcard(String code) {
        return bankcardBO.getBankcard(code);
    }

    @Override
    public void editBankcardNumber(Bankcard bankcard) {
        bankcardBO.refreshBankcardNumber(bankcard);
    }
}
