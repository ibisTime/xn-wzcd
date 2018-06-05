package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632856Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询应聘登记
 * @author: CYL 
 * @since: 2018年6月5日 下午3:45:08 
 * @history:
 */
public class XN632856 extends AProcessor {
    private IEmployApplyAO employApplyAO = SpringContextHolder
        .getBean(IEmployApplyAO.class);

    private XN632856Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return employApplyAO.getEmployApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632856Req.class);
        ObjValidater.validateReq(req);
    }

}
