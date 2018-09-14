package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OverdueRecord;

@Component
public interface IOverdueRecordAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public int addOverdueRecord(OverdueRecord data);

    public Paginable<OverdueRecord> queryOverdueRecordPage(int start, int limit,
            OverdueRecord condition);

    public List<OverdueRecord> queryOverdueRecordList(OverdueRecord condition);

    public OverdueRecord getOverdueRecord(int id);

}
