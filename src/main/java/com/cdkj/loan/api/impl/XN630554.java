package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630554Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业务团队解除抵押
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:05 
 * @history:
 */
public class XN630554 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630554Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.releaseMortgage(req.getCode(), DateUtil
            .strToDate(req.getReleaseDatetime(), DateUtil.DATA_TIME_PATTERN_1),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630554Req.class);
        ObjValidater.validateReq(req);
    }

}
