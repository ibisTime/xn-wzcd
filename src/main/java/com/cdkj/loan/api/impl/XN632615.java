package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.OvertimeApply;
import com.cdkj.loan.dto.req.XN632615Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午9:28:58 
 * @history:
 */
public class XN632615 extends AProcessor {

    private IOvertimeApplyAO overtimeApplyAO = SpringContextHolder
        .getBean(IOvertimeApplyAO.class);

    private XN632615Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OvertimeApply condition = new OvertimeApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        condition.setStartApplyDatetime(req.getStartApplyDatetime());
        condition.setEndApplyDatetime(req.getEndApplyDatetime());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSRoleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return overtimeApplyAO.queryOvertimeApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632615Req.class);
        ObjValidater.validateReq(req);
    }
}
