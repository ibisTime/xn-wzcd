package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.dto.req.XN630901Req;
import com.cdkj.loan.dto.res.XN630901Res;

@Component
public interface IStatisticAO {

    // 车贷分期业务统计
    public List<XN630901Res> carLoanBizStatistic(XN630901Req req);

}
