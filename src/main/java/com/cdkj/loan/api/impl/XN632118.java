package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632118Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 征信报告查看
 * @author: jiafr 
 * @since: 2018年5月26日 下午2:33:29 
 * @history:
 */
public class XN632118 extends AProcessor {

    private ICreditUserAO ICreditUserBO = SpringContextHolder
        .getBean(ICreditUserAO.class);

    private XN632118Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return ICreditUserBO.getCreditUserReport(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632118Req.class);
        ObjValidater.validateReq(req);

    }

}
