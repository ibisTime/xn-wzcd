package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.ao.ITravelApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.TravelApply;
import com.cdkj.loan.dto.req.XN632625Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询出差申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午2:16:27 
 * @history:
 */
public class XN632625 extends AProcessor {

    private ITravelApplyAO travelApplyAO = SpringContextHolder
        .getBean(ITravelApplyAO.class);

    private XN632625Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        TravelApply condition = new TravelApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        condition.setStartDatetime(req.getStartDatetime());
        condition.setEndDatetime(req.getEndDatetime());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSRoleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return travelApplyAO.queryTravelApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632625Req.class);
        ObjValidater.validateReq(req);
    }
}
