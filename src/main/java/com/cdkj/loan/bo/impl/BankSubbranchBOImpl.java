package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankSubbranchDAO;
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

    @Override
    public String saveBankSubbranch(BankSubbranch data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater
                    .generate(EGeneratePrefix.BANKSUBBRANCH.getCode());
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
        return bankSubbranchDAO.select(condition);
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
