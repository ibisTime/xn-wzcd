package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ITravelApplyDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ITravelApplyDetailDAO;
import com.cdkj.loan.domain.TravelApplyDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:31:07 
 * @history:
 */
@Component
public class TravelApplyDetailBOImpl extends PaginableBOImpl<TravelApplyDetail>
        implements ITravelApplyDetailBO {

    @Autowired
    private ITravelApplyDetailDAO travelApplyDetailDAO;

    @Override
    public void saveTravelApplyDetail(TravelApplyDetail data) {
        if (data != null) {
            travelApplyDetailDAO.insert(data);
        }
    }

    @Override
    public List<TravelApplyDetail> queryTravelApplyDetailList(
            TravelApplyDetail condition) {
        return travelApplyDetailDAO.selectList(condition);
    }

    @Override
    public List<TravelApplyDetail> queryTravelApplyDetailList(
            String travelApplyCode) {
        TravelApplyDetail condition = new TravelApplyDetail();
        condition.setTravelApplyCode(travelApplyCode);
        return travelApplyDetailDAO.selectList(condition);
    }

}
