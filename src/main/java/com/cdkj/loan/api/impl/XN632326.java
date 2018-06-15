package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReplaceRepayApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632326Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 代偿预算单详细查
 * @author: silver 
 * @since: 2018年6月15日 上午11:14:17 
 * @history:
 */
public class XN632326 extends AProcessor {
    private IReplaceRepayApplyAO replaceRepayApplyAO = SpringContextHolder
        .getBean(IReplaceRepayApplyAO.class);

    private XN632326Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return replaceRepayApplyAO.getReplaceRepayApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632326Req.class);
        ObjValidater.validateReq(req);
    }
}
