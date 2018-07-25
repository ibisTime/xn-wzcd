package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632175Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 垫资流程确认打款给车行
 * @author: jiafr 
 * @since: 2018年6月17日 下午12:17:04 
 * @history:
 */
public class XN632175 extends AProcessor {
    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632175Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        advanceFundAO.confirmPayCarDealer(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632175Req.class);
        ObjValidater.validateReq(req);
    }

}
