package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LeaveApply;
import com.cdkj.loan.dto.req.XN632895Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午9:01:05 
 * @history:
 */
public class XN632895 extends AProcessor {
    private ILeaveApplyAO leaveApplyOutAO = SpringContextHolder
        .getBean(ILeaveApplyAO.class);

    private XN632895Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LeaveApply condition = new LeaveApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setType(req.getType());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return leaveApplyOutAO.queryLeaveApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632895Req.class);
        ObjValidater.validateReq(req);
    }
}
