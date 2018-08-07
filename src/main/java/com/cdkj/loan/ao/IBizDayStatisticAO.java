package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizDayStatistic;
import com.cdkj.loan.dto.req.XN630901Req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月6日 下午5:44:13 
 * @history:
 */
@Component
public interface IBizDayStatisticAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public String addBizDayStatistic(BizDayStatistic data);

    public int dropBizDayStatistic(String code);

    public int editBizDayStatistic(BizDayStatistic data);

    public Paginable<BizDayStatistic> queryBizDayStatisticPage(int start,
            int limit, BizDayStatistic condition);

    public List<BizDayStatistic> queryBizDayStatisticList(
            BizDayStatistic condition);

    public BizDayStatistic getBizDayStatistic(String code);

    // 每天凌晨定时更新车贷分期业务日计表（统计当日业务额）
    public void doBizDayStatistic();

    // 车贷分期业务日统计表
    public List<BizDayStatistic> carLoanBizStatistic(XN630901Req req);

}
