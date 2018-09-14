package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.OverdueRecord;

public interface IOverdueRecordBO extends IPaginableBO<OverdueRecord> {

    public int saveOverdueRecord(OverdueRecord data);

    public List<OverdueRecord> queryOverdueRecordList(OverdueRecord condition);

    public OverdueRecord getOverdueRecord(int id);

}
