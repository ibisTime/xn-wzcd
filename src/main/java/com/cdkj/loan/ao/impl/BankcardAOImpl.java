package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN630220Req;

//CHECK ��鲢��ע�� 
@Service
public class BankcardAOImpl implements IBankcardAO {

    @Autowired
    private IBankcardBO bankcardBO;

    @Override
    public String addBankcard(XN630220Req req) {
        Bankcard data = new Bankcard();
        data.setUserId(req.getUserId());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setCreateDatetime(new Date());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return bankcardBO.saveBankcard(data);
    }

    @Override
    public int editBankcard(Bankcard data) {
        return bankcardBO.refreshBankcard(data);
    }

    @Override
    public int dropBankcard(String code) {
        return bankcardBO.removeBankcard(code);
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
    public String bind(String userId, String bankcardNumber, String bankCode,
            String bankName, String subbranch) {
        String code = null;
        Bankcard data = new Bankcard();
        code = OrderNoGenerater.generate("BC");
        data.setCode(code);
        data.setUserId(userId);
        data.setBankcardNumber(bankcardNumber);
        data.setBankCode(bankCode);
        data.setBankName(bankName);
        data.setSubbranch(subbranch);
        data.setCreateDatetime(new Date());
        bankcardBO.saveBankcard(data);
        return code;
    }
}
