package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632178Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预打款统计
 * @author: jiafr 
 * @since: 2018年8月20日 下午5:54:58 
 * @history:
 */
public class XN632178 extends AProcessor {
    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632178Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return advanceFundAO.expectPayStatistics(req.getCompanyCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632178Req.class);
        ObjValidater.validateReq(req);
    }
}
