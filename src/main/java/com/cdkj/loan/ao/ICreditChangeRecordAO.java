package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditChangeRecord;

@Component
public interface ICreditChangeRecordAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int addCreditChangeRecord(CreditChangeRecord data);

    public Paginable<CreditChangeRecord> queryCreditChangeRecordPage(int start,
            int limit, CreditChangeRecord condition);

    public List<CreditChangeRecord> queryCreditChangeRecordList(
            CreditChangeRecord condition);

    public CreditChangeRecord getCreditChangeRecord(int id);

}
