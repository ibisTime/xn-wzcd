package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.OvertimeApply;
import com.cdkj.loan.dto.req.XN632611Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:46:36 
 * @history:
 */
public class XN632611 extends AProcessor {
    private IOvertimeApplyAO overtimeApplyAO = SpringContextHolder
        .getBean(IOvertimeApplyAO.class);

    private XN632611Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OvertimeApply data = new OvertimeApply();
        data.setCode(req.getCode());
        data.setRemark(req.getRemark());
        data.setStatus(req.getApproveResult());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        overtimeApplyAO.editOvertimeApply(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632611Req.class);
        ObjValidater.validateReq(req);
    }

}
