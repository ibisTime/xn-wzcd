package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630437Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询
 * @author: CYL 
 * @since: 2018年4月24日 下午5:40:53 
 * @history:
 */
public class XN630437 extends AProcessor {

    private ICarOrderAO carOderAO = SpringContextHolder
        .getBean(ICarOrderAO.class);

    private XN630437Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carOderAO.getCarOrder(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630437Req.class);
        ObjValidater.validateReq(req);
    }

}
