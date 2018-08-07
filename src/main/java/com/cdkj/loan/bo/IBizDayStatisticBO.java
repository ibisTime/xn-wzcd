package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizDayStatistic;

public interface IBizDayStatisticBO extends IPaginableBO<BizDayStatistic> {

    public boolean isBizDayStatisticExist(String id);

    public String saveBizDayStatistic(BizDayStatistic data);

    public int removeBizDayStatistic(String id);

    public int refreshBizDayStatistic(BizDayStatistic data);

    public List<BizDayStatistic> queryBizDayStatisticList(
            BizDayStatistic condition);

    public BizDayStatistic getBizDayStatistic(String id);

    public BizDayStatistic getBizDayStatisticByDate(Date date);

}
