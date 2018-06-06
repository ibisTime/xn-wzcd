package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RecruitApply;
import com.cdkj.loan.dto.req.XN632840Req;

@Component
public interface IRecruitApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRecruitApply(XN632840Req req);

    public void auditRecruitApply(String code, String updater, String remark,
            String approveResult);

    public Paginable<RecruitApply> queryRecruitApplyPage(int start, int limit,
            RecruitApply condition);

    public List<RecruitApply> queryRecruitApplyList(RecruitApply condition);

    public RecruitApply getRecruitApply(String code);

}
