package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632246Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询返点
 * @author: jiafr 
 * @since: 2018年6月18日 下午3:33:52 
 * @history:
 */
public class XN632246 extends AProcessor {

    private IRepointAO repointAO = SpringContextHolder
        .getBean(IRepointAO.class);

    private XN632246Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repointAO.getRepoint(req.getCode());

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632246Req.class);
        ObjValidater.validateReq(req);
    }

}
