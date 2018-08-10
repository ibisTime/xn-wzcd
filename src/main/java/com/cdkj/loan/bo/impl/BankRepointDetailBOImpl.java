package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankRepointDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankRepointDetailDAO;
import com.cdkj.loan.domain.BankRepointDetail;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:30:52 
 * @history:
 */
@Component
public class BankRepointDetailBOImpl extends PaginableBOImpl<BankRepointDetail>
        implements IBankRepointDetailBO {

    @Autowired
    private IBankRepointDetailDAO bankRepointDetailDAO;

    @Override
    public boolean isBankRepointDetailExist(String code) {
        BankRepointDetail condition = new BankRepointDetail();
        condition.setCode(code);
        if (bankRepointDetailDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBankRepointDetail(BankRepointDetail data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BANK_REPOINT_DETAIL.getCode());
            data.setCode(code);
            bankRepointDetailDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBankRepointDetail(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BankRepointDetail data = new BankRepointDetail();
            data.setCode(code);
            count = bankRepointDetailDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankRepointDetail(BankRepointDetail data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankRepointDetailDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BankRepointDetail> queryBankRepointDetailList(
            BankRepointDetail condition) {
        return bankRepointDetailDAO.selectList(condition);
    }

    @Override
    public BankRepointDetail getBankRepointDetail(String code) {
        BankRepointDetail data = null;
        if (StringUtils.isNotBlank(code)) {
            BankRepointDetail condition = new BankRepointDetail();
            condition.setCode(code);
            data = bankRepointDetailDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
