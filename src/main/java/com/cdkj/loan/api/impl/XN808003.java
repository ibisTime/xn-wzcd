package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN808003Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 上架
 * @author: myb858 
 * @since: 2017年3月25日 下午3:25:13 
 * @history:
 */
public class XN808003 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        categoryAO.putOn(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808003Req.class);
        ObjValidater.validateReq(req);
    }

}
