package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632109Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 征信查询请求接口
 * @author: CYL 
 * @since: 2018年11月30日 下午4:30:48 
 * @history:
 */
public class XN632109 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632109Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return creditAO.foundReasult(req.getCode(), req.getSystemCode(),
            req.getCompanyCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632109Req.class);
        ObjValidater.validateReq(req);

    }

}
