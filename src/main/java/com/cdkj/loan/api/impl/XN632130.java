package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增补件原因
 * @author: CYL 
 * @since: 2018年7月14日 下午4:58:03 
 * @history:
 */
public class XN632130 extends AProcessor {
    private ISupplementReasonAO supplementReasonAO = SpringContextHolder
        .getBean(ISupplementReasonAO.class);

    private XN632130Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return supplementReasonAO.addSupplementReason(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632130Req.class);
        ObjValidater.validateReq(req);
    }

}
