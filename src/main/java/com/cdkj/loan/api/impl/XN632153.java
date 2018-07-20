package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632153Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核不通过补发件
 * @author: CYL 
 * @since: 2018年7月14日 下午6:59:59 
 * @history:
 */
public class XN632153 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN632153Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        logisticsAO.supplementAndSend(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632153Req.class);
        ObjValidater.validateReq(req);
    }

}
