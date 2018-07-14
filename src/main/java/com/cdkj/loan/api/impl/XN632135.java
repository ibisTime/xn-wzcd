package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 补件原因分页查
 * @author: CYL 
 * @since: 2018年7月14日 下午4:58:03 
 * @history:
 */
public class XN632135 extends AProcessor {
    private ISupplementReasonAO supplementReasonAO = SpringContextHolder
        .getBean(ISupplementReasonAO.class);

    private XN632135Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SupplementReason condition = new SupplementReason();
        condition.setType(req.getType());
        condition.setLogisticsCode(req.getLogisticsCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISupplementReasonAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return supplementReasonAO.querySupplementReasonPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632135Req.class);
        ObjValidater.validateReq(req);
    }

}
