package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSConfigAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632789Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * GPS个人申领上限
 * @author: CYL 
 * @since: 2018年8月20日 下午2:44:31 
 * @history:
 */
public class XN632789 extends AProcessor {

    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN632789Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysConfigAO.editGpsLimitNumber(req.getNumber(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632789Req.class);
        ObjValidater.validateReq(req);
    }
}
