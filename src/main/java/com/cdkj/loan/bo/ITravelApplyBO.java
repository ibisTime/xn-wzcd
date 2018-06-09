package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TravelApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:26:03 
 * @history:
 */
public interface ITravelApplyBO extends IPaginableBO<TravelApply> {

    public boolean isTravelApplyExist(String code);

    public String saveTravelApply(TravelApply data);

    public int removeTravelApply(String code);

    public int refreshTravelApply(TravelApply data);

    public List<TravelApply> queryTravelApplyList(TravelApply condition);

    public TravelApply getTravelApply(String code);

    public Long getTravelApplyTotalHour(String applyUser, String type,
            Date startDatetime, Date endDatetime);

}
