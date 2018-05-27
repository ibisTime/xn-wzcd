package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankRateBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IBankRateDAO;
import com.cdkj.loan.domain.BankRate;
import com.cdkj.loan.dto.req.XN632030ReqRate;
import com.cdkj.loan.exception.BizException;

@Component
public class BankRateBOImpl extends PaginableBOImpl<BankRate>
        implements IBankRateBO {
    @Autowired
    private IBankRateDAO bankRateDAO;

    @Override
    public int saveBankRate(List<XN632030ReqRate> req, String bankCode) {
        if (CollectionUtils.isNotEmpty(req)) {
            BankRate data = new BankRate();
            for (XN632030ReqRate bankRate : req) {
                data.setBankCode(bankCode);
                if (StringUtils.isNotBlank(bankRate.getPeriod())) {
                    data.setPeriod(
                        StringValidater.toInteger(bankRate.getPeriod()));
                }
                if (StringUtils.isNotBlank(bankRate.getRate())) {
                    data.setRate(StringValidater.toDouble(bankRate.getRate()));
                }
                data.setRemark(bankRate.getRemark());
                bankRateDAO.insert(data);
            }
        } else {
            throw new BizException("xn0000", "请添加利率明细。");
        }
        return 1;
    }

    @Override
    public int dropBankRate(BankRate data) {
        return bankRateDAO.delete(data);
    }

    @Override
    public BankRate getBankRate(BankRate condition) {
        return bankRateDAO.select(condition);
    }

    @Override
    public int editBankRate(BankRate data) {
        return bankRateDAO.updateBankRate(data);
    }

    @Override
    public List<BankRate> queryBankRateList(BankRate condition) {
        return bankRateDAO.selectList(condition);
    }
}
