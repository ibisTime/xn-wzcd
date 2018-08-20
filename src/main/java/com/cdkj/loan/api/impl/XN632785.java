package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsSupplierAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.dto.req.XN632785Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查GPS供应商
 * @author: CYL 
 * @since: 2018年8月20日 下午2:44:31 
 * @history:
 */
public class XN632785 extends AProcessor {

    private IGpsSupplierAO gpsSupplierAO = SpringContextHolder
        .getBean(IGpsSupplierAO.class);

    private XN632785Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GpsSupplier condition = new GpsSupplier();
        condition.setName(req.getName());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGpsSupplierAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return gpsSupplierAO.queryGpsSupplierPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632785Req.class);
        ObjValidater.validateReq(req);
    }
}
