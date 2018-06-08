package com.cdkj.loan.ao;

import org.springframework.stereotype.Component;

import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.dto.req.XN632680Req;
import com.cdkj.loan.dto.res.XN632685Res;

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

    public XN632685Res queryDayRestList(DayRest condition);

    public String queryCheckingList(DayRest condition);

}
