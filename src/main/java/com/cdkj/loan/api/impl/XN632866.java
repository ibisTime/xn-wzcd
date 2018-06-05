package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEntryApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632866Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查入职申请
 * @author: CYL 
 * @since: 2018年6月5日 下午6:13:24 
 * @history:
 */
public class XN632866 extends AProcessor {
    private IEntryApplyAO entryApplyAO = SpringContextHolder
        .getBean(IEntryApplyAO.class);

    private XN632866Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return entryApplyAO.getEntryApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632866Req.class);
        ObjValidater.validateReq(req);
    }

}
