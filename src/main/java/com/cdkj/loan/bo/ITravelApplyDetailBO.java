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

    public boolean isTravelApplyDetailExist(String code);

    public void saveTravelApplyDetail(TravelApplyDetail data);

    public int removeTravelApplyDetail(String code);

    public int refreshTravelApplyDetail(TravelApplyDetail data);

    public List<TravelApplyDetail> queryTravelApplyDetailList(
            TravelApplyDetail condition);

    public TravelApplyDetail getTravelApplyDetail(String code);

}
