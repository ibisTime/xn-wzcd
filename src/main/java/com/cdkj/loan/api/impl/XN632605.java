package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISuppleSignApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SuppleSignApply;
import com.cdkj.loan.dto.req.XN632605Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询补签
 * @author: silver 
 * @since: 2018年6月6日 下午12:30:02 
 * @history:
 */
public class XN632605 extends AProcessor {
    private ISuppleSignApplyAO suppleSignApplyAO = SpringContextHolder
        .getBean(ISuppleSignApplyAO.class);

    private XN632605Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SuppleSignApply condition = new SuppleSignApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISuppleSignApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return suppleSignApplyAO.querySuppleSignApplyPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632605Req.class);
        ObjValidater.validateReq(req);
    }
}
