package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICreditChangeRecordBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ICreditChangeRecordDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.CreditChangeRecord;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class CreditChangeRecordBOImpl extends
        PaginableBOImpl<CreditChangeRecord> implements ICreditChangeRecordBO {

    @Autowired
    private ICreditChangeRecordDAO creditChangeRecordDAO;

    @Autowired
    private IBankBO bankBO;

    public int saveCreditChangeRecord(CreditChangeRecord data) {
        int id = 0;
        if (data != null) {
            id = creditChangeRecordDAO.insert(data);
        }
        return id;
    }

    @Override
    public List<CreditChangeRecord> queryCreditChangeRecordList(
            CreditChangeRecord condition) {
        List<CreditChangeRecord> selectList = creditChangeRecordDAO
            .selectList(condition);
        for (CreditChangeRecord creditChangeRecord : selectList) {
            initCreditChangeRecord(creditChangeRecord);
        }
        return selectList;
    }

    private void initCreditChangeRecord(CreditChangeRecord creditChangeRecord) {
        // 原贷款银行名称
        if (StringUtils.isNotBlank(creditChangeRecord.getRawLoanBankCode())) {
            Bank bank = bankBO
                .getBankBySubbranch(creditChangeRecord.getRawLoanBankCode());
            creditChangeRecord.setRawLoanBankName(bank.getBankName());
        }
        // 现贷款银行名称
        if (StringUtils.isNotBlank(creditChangeRecord.getNowLoanBankCode())) {
            Bank bank = bankBO
                .getBankBySubbranch(creditChangeRecord.getNowLoanBankCode());
            creditChangeRecord.setNowLoanBankName(bank.getBankName());
        }
    }

    @Override
    public CreditChangeRecord getCreditChangeRecord(int id) {
        CreditChangeRecord data = null;
        if (id != 0) {
            CreditChangeRecord condition = new CreditChangeRecord();
            condition.setId(id);
            data = creditChangeRecordDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "征信银行卡变更记录id不存在！");
            }
        }
        return data;
    }
}
