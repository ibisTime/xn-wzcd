package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.dto.req.XN632680Req;
import com.cdkj.loan.dto.res.XN632685Res;
import com.cdkj.loan.dto.res.XN632686Res;

/**
 * 休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:50:50 
 * @history:
 */
@Component
public interface IDayRestAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addDayRest(XN632680Req req);

    public List<XN632685Res> queryDayRestList(DayRest condition);

    public Paginable<XN632686Res> queryCheckingPage(int start, int limit,
            DayRest restCondition, Archive archiveCondition);
}
