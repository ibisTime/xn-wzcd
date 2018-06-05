package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.EntryApply;

@Component
public interface IEntryApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addEntryApply(EntryApply data);

    public Paginable<EntryApply> queryEntryApplyPage(int start, int limit,
            EntryApply condition);

    public List<EntryApply> queryEntryApplyList(EntryApply condition);

    public EntryApply getEntryApply(String code);

}
