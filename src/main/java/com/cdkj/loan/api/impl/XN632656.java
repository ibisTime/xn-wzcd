package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAskForApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632656Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查
 * @author: CYL 
 * @since: 2018年6月6日 下午5:36:15 
 * @history:
 */
public class XN632656 extends AProcessor {
    private IAskForApplyAO askForApplyAO = SpringContextHolder
        .getBean(IAskForApplyAO.class);

    private XN632656Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return askForApplyAO.getAskForApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632656Req.class);
        ObjValidater.validateReq(req);
    }

}
