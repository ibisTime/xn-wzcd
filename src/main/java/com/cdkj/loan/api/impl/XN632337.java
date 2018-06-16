package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.dto.req.XN632337Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 代偿审核详细查
 * @author: silver 
 * @since: 2018年6月16日 上午10:22:24 
 * @history:
 */
public class XN632337 extends AProcessor {
    private IReplaceRepayPlanAO replaceRepayPlanAO = SpringContextHolder
        .getBean(IReplaceRepayPlanAO.class);

    private XN632337Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return replaceRepayPlanAO.getReplaceRepayPlan(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632337Req.class);
        ObjValidater.validateReq(req);
    }
}
