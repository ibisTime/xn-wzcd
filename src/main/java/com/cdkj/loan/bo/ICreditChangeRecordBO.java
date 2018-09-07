package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditChangeRecord;

public interface ICreditChangeRecordBO
        extends IPaginableBO<CreditChangeRecord> {

    public int saveCreditChangeRecord(CreditChangeRecord data);

    public List<CreditChangeRecord> queryCreditChangeRecordList(
            CreditChangeRecord condition);

    public CreditChangeRecord getCreditChangeRecord(int id);

}
