package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.TravelApply;
import com.cdkj.loan.dto.req.XN632620Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午12:52:19 
 * @history:
 */
@Component
public interface ITravelApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addTravelApply(XN632620Req req);

    public void editTravelApply(TravelApply data);

    public Paginable<TravelApply> queryTravelApplyPage(int start, int limit,
            TravelApply condition);

    public List<TravelApply> queryTravelApplyList(TravelApply condition);

    public TravelApply getTravelApply(String code);

}
