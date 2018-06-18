package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.req.XN632002Req;

@Service
public class CollectBankcardAOImpl implements ICollectBankcardAO {

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public String addCollectBankcard(XN632000Req req) {
        CollectBankcard data = new CollectBankcard();
        data.setType(req.getType());
        data.setCompanyCode(req.getCompanyCode());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());
        // 获取银行名称
        BankSubbranch subbranch = bankSubbranchBO
            .getBankSubbranch(req.getBankCode());
        Bank bank = bankBO.getBank(subbranch.getBankCode());
        data.setBankName(bank.getBankName());

        data.setBankcardNumber(req.getBankcardNumber());
        data.setRemark(req.getRemark());
        return collectBankcardBO.saveCollectBankcard(data);
    }

    @Override
    public int editCollectBankcard(XN632002Req req) {
        CollectBankcard data = collectBankcardBO
            .getCollectBankcard(req.getCode());
        data.setType(req.getType());
        data.setCompanyCode(req.getCompanyCode());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());
        // 获取银行名称
        BankSubbranch subbranch = bankSubbranchBO
            .getBankSubbranch(req.getBankCode());
        Bank bank = bankBO.getBank(subbranch.getBankCode());
        data.setBankName(bank.getBankName());

        data.setBankcardNumber(req.getBankcardNumber());
        data.setRemark(req.getRemark());
        return collectBankcardBO.refreshCollectBankcard(data);
    }

    @Override
    public int dropCollectBankcard(String code) {
        return collectBankcardBO.removeCollectBankcard(code);
    }

    @Override
    public Paginable<CollectBankcard> queryCollectBankcardPage(int start,
            int limit, CollectBankcard condition) {
        return collectBankcardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition) {
        return collectBankcardBO.queryCollectBankcardList(condition);
    }

    @Override
    public CollectBankcard getCollectBankcard(String code) {
        return collectBankcardBO.getCollectBankcard(code);
    }
}
