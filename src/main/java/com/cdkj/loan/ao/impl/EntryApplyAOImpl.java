package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IEntryApplyAO;
import com.cdkj.loan.bo.IEntryApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.EntryApply;

@Service
public class EntryApplyAOImpl implements IEntryApplyAO {

    @Autowired
    private IEntryApplyBO entryApplyBO;

    @Override
    public String addEntryApply(EntryApply data) {
        return entryApplyBO.saveEntryApply(data);
    }

    @Override
    public Paginable<EntryApply> queryEntryApplyPage(int start, int limit,
            EntryApply condition) {
        return entryApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<EntryApply> queryEntryApplyList(EntryApply condition) {
        return entryApplyBO.queryEntryApplyList(condition);
    }

    @Override
    public EntryApply getEntryApply(String code) {
        return entryApplyBO.getEntryApply(code);
    }
}
