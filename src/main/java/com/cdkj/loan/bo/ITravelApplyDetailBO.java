package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TravelApplyDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:29:49 
 * @history:
 */
public interface ITravelApplyDetailBO extends IPaginableBO<TravelApplyDetail> {

    public void saveTravelApplyDetail(TravelApplyDetail data);

    public List<TravelApplyDetail> queryTravelApplyDetailList(
            TravelApplyDetail condition);

    public List<TravelApplyDetail> queryTravelApplyDetailList(
            String travelApplyCode);
}
