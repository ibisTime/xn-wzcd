package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632610Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午12:17:10 
 * @history:
 */
public class XN632610 extends AProcessor {
    private IOvertimeApplyAO overtimeApplyAO = SpringContextHolder
        .getBean(IOvertimeApplyAO.class);

    private XN632610Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(overtimeApplyAO.addOvertimeApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632610Req.class);
        ObjValidater.validateReq(req);
    }

}
