package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankRepointBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankRepointDAO;
import com.cdkj.loan.domain.BankRepoint;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:20:51 
 * @history:
 */
@Component
public class BankRepointBOImpl extends PaginableBOImpl<BankRepoint> implements
        IBankRepointBO {

    @Autowired
    private IBankRepointDAO bankRepointDAO;

    @Override
    public boolean isBankRepointExist(String code) {
        BankRepoint condition = new BankRepoint();
        condition.setCode(code);
        if (bankRepointDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBankRepoint(BankRepoint data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BANK_REPOINT
                .getCode());
            data.setCode(code);
            bankRepointDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBankRepoint(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BankRepoint data = new BankRepoint();
            data.setCode(code);
            count = bankRepointDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankRepoint(BankRepoint data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankRepointDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BankRepoint> queryBankRepointList(BankRepoint condition) {
        return bankRepointDAO.selectList(condition);
    }

    @Override
    public BankRepoint getBankRepoint(String code) {
        BankRepoint data = null;
        if (StringUtils.isNotBlank(code)) {
            BankRepoint condition = new BankRepoint();
            condition.setCode(code);
            data = bankRepointDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
