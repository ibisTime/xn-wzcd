package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRegimeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632733Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 撤下制度
 * @author: silver 
 * @since: 2018年6月8日 上午10:38:32 
 * @history:
 */
public class XN632733 extends AProcessor {

    private IRegimeAO regimeAO = SpringContextHolder.getBean(IRegimeAO.class);

    private XN632733Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        regimeAO.removeRegime(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632733Req.class);
        ObjValidater.validateReq(req);
    }
}
