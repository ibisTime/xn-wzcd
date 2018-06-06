package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICarBreakAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarBreak;
import com.cdkj.loan.dto.req.XN632635Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询违章
 * @author: silver 
 * @since: 2018年6月6日 下午5:03:46 
 * @history:
 */
public class XN632635 extends AProcessor {
    private ICarBreakAO carBreakAO = SpringContextHolder
        .getBean(ICarBreakAO.class);

    private XN632635Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarBreak condition = new CarBreak();
        condition.setUserId(req.getUserId());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICarBreakAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return carBreakAO.queryCarBreakPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632635Req.class);
        ObjValidater.validateReq(req);
    }
}
