package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632616Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午11:40:42 
 * @history:
 */
public class XN632616 extends AProcessor {
    private IOvertimeApplyAO overtimeApplyAO = SpringContextHolder
        .getBean(IOvertimeApplyAO.class);

    private XN632616Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return overtimeApplyAO.getOvertimeApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632616Req.class);
        ObjValidater.validateReq(req);
    }
}
