package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632750Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:01:00 
 * @history:
 */
public class XN632750 extends AProcessor {

    private ICompProductAO compProductAO = SpringContextHolder
        .getBean(ICompProductAO.class);

    private XN632750Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(compProductAO.addCompProduct(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632750Req.class);
        ObjValidater.validateReq(req);
    }
}
