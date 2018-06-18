package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankSubbranchDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:17:01 
 * @history:
 */
@Component
public class BankSubbranchBOImpl extends PaginableBOImpl<BankSubbranch>
        implements IBankSubbranchBO {

    @Autowired
    private IBankSubbranchDAO bankSubbranchDAO;

    @Autowired
    private IBankAO bankAO;

    @Override
    public String saveBankSubbranch(BankSubbranch data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater.generate(EGeneratePrefix.BANKSUBBRANCH
                    .getCode());
                data.setCode(code);
            }
            bankSubbranchDAO.insert(data);
        }

        return code;
    }

    @Override
    public int dropBankSubbranch(BankSubbranch data) {
        return bankSubbranchDAO.delete(data);
    }

    @Override
    public BankSubbranch getBankSubbranch(BankSubbranch condition) {
        BankSubbranch select = bankSubbranchDAO.select(condition);
        Bank bank = bankAO.getBank(select.getBankCode());
        select.setBank(bank);
        return select;
    }

    @Override
    public BankSubbranch getBankSubbranch(String code) {
        BankSubbranch condition = new BankSubbranch();
        condition.setCode(code);
        BankSubbranch bankSubbranch = bankSubbranchDAO.select(condition);
        Bank bank = bankAO.getBank(bankSubbranch.getBankCode());
        bankSubbranch.setBank(bank);
        return bankSubbranch;
    }

    @Override
    public int editBankSubbranch(BankSubbranch data) {
        return bankSubbranchDAO.updateBankSubbranch(data);
    }

    @Override
    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition) {
        return bankSubbranchDAO.selectList(condition);
    }

    @Override
    public long getBankSubbranchMaxid(String bankCode) {
        if (StringUtils.isBlank(bankCode)) {
            throw new BizException("xn0000", "银行信息不存在。");
        }

        BankSubbranch condition = new BankSubbranch();
        condition.setBankCode(bankCode);
        return bankSubbranchDAO.selectBankSubbranchMaxid(condition);
    }
}
