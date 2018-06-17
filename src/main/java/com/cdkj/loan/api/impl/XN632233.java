package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITotalAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632233Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 发票不匹配财务审核
 * @author: jiafr 
 * @since: 2018年6月18日 上午12:45:00 
 * @history:
 */
public class XN632233 extends AProcessor {
    private ITotalAdvanceFundAO totalAdvanceFundAO = SpringContextHolder
        .getBean(ITotalAdvanceFundAO.class);

    private XN632233Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        totalAdvanceFundAO.financeConfirm(req);

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632233Req.class);
        ObjValidater.validateReq(req);
    }

}
