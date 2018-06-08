package com.cdkj.loan.bo.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IDayRestBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.dao.IDayRestDAO;
import com.cdkj.loan.domain.DayRest;

/**
 * 休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:49:39 
 * @history:
 */
@Component
public class DayRestBOImpl extends PaginableBOImpl<DayRest>
        implements IDayRestBO {

    @Autowired
    private IDayRestDAO dayRestDAO;

    @Override
    public void saveDayRest(List<DayRest> dayRestList) {
        dayRestDAO.insertDayRestList(dayRestList);
    }

    @Override
    public void removeDayRest(Date operateDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(operateDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        DayRest dayRest = new DayRest();
        dayRest.setStartDatetime(DateUtil.getBeginTime(year, month));
        dayRest.setEndDatetime(DateUtil.getEndTime(year, month));
        dayRestDAO.delete(dayRest);
    }

    @Override
    public List<DayRest> queryDayRestList(DayRest condition) {
        return dayRestDAO.selectList(condition);
    }

}
