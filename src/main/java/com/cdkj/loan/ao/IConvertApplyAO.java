package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ConvertApply;
import com.cdkj.loan.dto.req.XN632870Req;

@Component
public interface IConvertApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addConvertApply(XN632870Req req);

    public int editConvertApply(ConvertApply data);

    public Paginable<ConvertApply> queryConvertApplyPage(int start, int limit,
            ConvertApply condition);

    public List<ConvertApply> queryConvertApplyList(ConvertApply condition);

    public ConvertApply getConvertApply(String code);

    public void approveConvertApply(String code, String approveResult,
            String updater, String remark);

}
