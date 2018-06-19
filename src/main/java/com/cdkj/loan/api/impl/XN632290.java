package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632290Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:18:15 
 * @history:
 */
public class XN632290 extends AProcessor {
    private IRepointDetailAO repointDetailAO = SpringContextHolder
        .getBean(IRepointDetailAO.class);

    private XN632290Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repointDetailAO.showRepointDetail(req,
            StringValidater.toLong(req.getLoanAmount()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632290Req.class);
        ObjValidater.validateReq(req);
    }
}
