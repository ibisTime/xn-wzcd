package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN808002Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改类别
 * @author: xieyj 
 * @since: 2016年11月16日 下午5:45:12 
 * @history:
 */
public class XN808002 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        categoryAO.editCategory(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808002Req.class);
        ObjValidater.validateReq(req);
    }
}
