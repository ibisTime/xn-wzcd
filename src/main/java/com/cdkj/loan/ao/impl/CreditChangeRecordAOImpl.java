package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditChangeRecordAO;
import com.cdkj.loan.bo.ICreditChangeRecordBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditChangeRecord;

@Service
public class CreditChangeRecordAOImpl implements ICreditChangeRecordAO {

    @Autowired
    private ICreditChangeRecordBO creditChangeRecordBO;

    @Override
    public int addCreditChangeRecord(CreditChangeRecord data) {
        return creditChangeRecordBO.saveCreditChangeRecord(data);
    }

    @Override
    public Paginable<CreditChangeRecord> queryCreditChangeRecordPage(int start,
            int limit, CreditChangeRecord condition) {
        return creditChangeRecordBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CreditChangeRecord> queryCreditChangeRecordList(
            CreditChangeRecord condition) {
        return creditChangeRecordBO.queryCreditChangeRecordList(condition);
    }

    @Override
    public CreditChangeRecord getCreditChangeRecord(int id) {
        return creditChangeRecordBO.getCreditChangeRecord(id);
    }
}
