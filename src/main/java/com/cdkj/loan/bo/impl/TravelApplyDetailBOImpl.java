package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
    public boolean isTravelApplyDetailExist(String code) {

        return false;
    }

    @Override
    public void saveTravelApplyDetail(TravelApplyDetail data) {

        if (data != null) {
            travelApplyDetailDAO.insert(data);
        }
    }

    @Override
    public int removeTravelApplyDetail(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            TravelApplyDetail data = new TravelApplyDetail();
            data.setTravelApplyCode(code);
            count = travelApplyDetailDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<TravelApplyDetail> queryTravelApplyDetailList(
            TravelApplyDetail condition) {
        return travelApplyDetailDAO.selectList(condition);
    }

    @Override
    public int refreshTravelApplyDetail(TravelApplyDetail data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TravelApplyDetail getTravelApplyDetail(String code) {
        // TODO Auto-generated method stub
        return null;
    }

}
