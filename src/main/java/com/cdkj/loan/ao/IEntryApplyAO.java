package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.EntryApply;
import com.cdkj.loan.dto.req.XN632860Req;

@Component
public interface IEntryApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请
    public String addEntryApply(XN632860Req req);

    // 审核
    public void approveEntryApply(String code, String approveResult,
            String updater, String remark);

    public Paginable<EntryApply> queryEntryApplyPage(int start, int limit,
            EntryApply condition);

    public List<EntryApply> queryEntryApplyList(EntryApply condition);

    public EntryApply getEntryApply(String code);

}
