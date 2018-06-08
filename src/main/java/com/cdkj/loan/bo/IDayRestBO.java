package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.DayRest;

/**
 * 休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:49:01 
 * @history:
 */
public interface IDayRestBO extends IPaginableBO<DayRest> {

    public void saveDayRest(List<DayRest> dayRestList);

    public void removeDayRest(Date operateDate);

    public List<DayRest> queryDayRestList(DayRest condition);

}
