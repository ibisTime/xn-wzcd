package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IConvertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632870Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 转正申请
 * @author: CYL 
 * @since: 2018年6月5日 下午9:50:31 
 * @history:
 */
public class XN632870 extends AProcessor {
    private IConvertApplyAO convertApplyAO = SpringContextHolder
        .getBean(IConvertApplyAO.class);

    private XN632870Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(convertApplyAO.addConvertApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632870Req.class);
        ObjValidater.validateReq(req);
    }

}
