package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.EntryApply;

public interface IEntryApplyBO extends IPaginableBO<EntryApply> {

    public String saveEntryApply(EntryApply data);

    public List<EntryApply> queryEntryApplyList(EntryApply condition);

    public EntryApply getEntryApply(String code);

}
