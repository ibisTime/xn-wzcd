package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RecruitApply;

@Component
public interface IRecruitApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRecruitApply(RecruitApply data);

    public int dropRecruitApply(String code);

    public int editRecruitApply(RecruitApply data);

    public Paginable<RecruitApply> queryRecruitApplyPage(int start, int limit,
            RecruitApply condition);

    public List<RecruitApply> queryRecruitApplyList(RecruitApply condition);

    public RecruitApply getRecruitApply(String code);

}
