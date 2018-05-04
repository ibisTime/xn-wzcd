package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankcardDAO;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BankcardBOImpl extends PaginableBOImpl<Bankcard>
        implements IBankcardBO {

    @Autowired
    private IBankcardDAO bankcardDAO;

    public String saveBankcard(Bankcard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BANKCARD.getCode());
            data.setCode(code);
            bankcardDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBankcard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Bankcard data = new Bankcard();
            data.setCode(code);
            count = bankcardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankcard(Bankcard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankcardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Bankcard> queryBankcardList(Bankcard condition) {
        return bankcardDAO.selectList(condition);
    }

    @Override
    public Bankcard getBankcard(String code) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(code)) {
            Bankcard condition = new Bankcard();
            condition.setCode(code);
            data = bankcardDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在！！！！");
            }
        }
        return data;
    }
}
