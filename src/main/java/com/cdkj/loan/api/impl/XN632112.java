package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632112Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改征信
 * @author: jiafr 
 * @since: 2018年5月25日 下午9:46:37 
 * @history:
 */
public class XN632112 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632112Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditAO.editCredit(req);
        return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632112Req.class);
        ObjValidater.validateReq(req);
    }

}
