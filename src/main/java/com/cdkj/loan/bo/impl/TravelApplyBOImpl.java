package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ITravelApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ITravelApplyDAO;
import com.cdkj.loan.domain.TravelApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:26:12 
 * @history:
 */
@Component
public class TravelApplyBOImpl extends PaginableBOImpl<TravelApply>
        implements ITravelApplyBO {

    @Autowired
    private ITravelApplyDAO travelApplyDAO;

    @Override
    public boolean isTravelApplyExist(String code) {
        TravelApply condition = new TravelApply();
        condition.setCode(code);
        if (travelApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveTravelApply(TravelApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.TRAVEL_APPLY.getCode());
            data.setCode(code);
            travelApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeTravelApply(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            TravelApply data = new TravelApply();
            data.setCode(code);
            count = travelApplyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshTravelApply(TravelApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = travelApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<TravelApply> queryTravelApplyList(TravelApply condition) {
        return travelApplyDAO.selectList(condition);
    }

    @Override
    public TravelApply getTravelApply(String code) {
        TravelApply data = null;
        if (StringUtils.isNotBlank(code)) {
            TravelApply condition = new TravelApply();
            condition.setCode(code);
            data = travelApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "出差不存在");
            }
        }
        return data;
    }
}
