package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AskForApply;
import com.cdkj.loan.dto.req.XN632650Req;

@Component
public interface IAskForApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请
    public String addAskForApply(XN632650Req req);

    public Paginable<AskForApply> queryAskForApplyPage(int start, int limit,
            AskForApply condition);

    public List<AskForApply> queryAskForApplyList(AskForApply condition);

    public AskForApply getAskForApply(String code);

    // 审核
    public void approveAskForApply(String code, String approveResult,
            String updater, String remark);

}
