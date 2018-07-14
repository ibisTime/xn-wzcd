package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632130Req;

@Component
public interface ISupplementReasonAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    // 新增补件原因
    public Long addSupplementReason(XN632130Req req);

    public Paginable<SupplementReason> querySupplementReasonPage(int start,
            int limit, SupplementReason condition);

    public List<SupplementReason> querySupplementReasonList(
            SupplementReason condition);

    public SupplementReason getSupplementReason(Long id);

}
