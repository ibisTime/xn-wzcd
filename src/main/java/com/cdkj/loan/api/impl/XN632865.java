package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.ao.IEntryApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.EntryApply;
import com.cdkj.loan.dto.req.XN632865Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查入职申请
 * @author: CYL 
 * @since: 2018年6月5日 下午6:13:24 
 * @history:
 */
public class XN632865 extends AProcessor {
    private IEntryApplyAO entryApplyAO = SpringContextHolder
        .getBean(IEntryApplyAO.class);

    private XN632865Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        EntryApply condition = new EntryApply();
        condition.setPosition(req.getPosition());
        condition.setRealName(req.getRealName());
        condition.setProbationStartDatetime(DateUtil.strToDate(
            req.getCreateDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setProbationEndDatetime(DateUtil.strToDate(
            req.getCreateDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IEmployApplyAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return entryApplyAO.queryEntryApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632865Req.class);
        ObjValidater.validateReq(req);
    }

}
