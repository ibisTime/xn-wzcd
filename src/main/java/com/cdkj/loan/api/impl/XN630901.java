package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizDayStatisticAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630901Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 车贷分期业务统计
 * @author: jiafr 
 * @since: 2018年8月3日 下午7:22:46 
 * @history:
 */
public class XN630901 extends AProcessor {
    private IBizDayStatisticAO bizDayStatisticAO = SpringContextHolder
        .getBean(IBizDayStatisticAO.class);

    private XN630901Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bizDayStatisticAO.carLoanBizStatistic(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630901Req.class);
        ObjValidater.validateReq(req);
    }
}
