package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.dto.req.XN630436Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*分页查询*/

public class XN630436 extends AProcessor {

    private ICarOrderAO carOrderAO = SpringContextHolder
        .getBean(ICarOrderAO.class);

    private XN630436Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarOrder condition = new CarOrder();
        condition.setBrandCode(req.getBrandCode());
        condition.setBrandName(req.getBrandName());
        condition.setSeriesCode(req.getSeriesCode());
        condition.setSeriesName(req.getSeriesName());
        condition.setSfRate(req.getSfRate());
        condition.setSfAmount(req.getSfAmount());
        condition.setPeriods(req.getPeriods());
        condition.setStatus(req.getStatus());
        condition.setHandler(req.getHandler());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICarOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return carOrderAO.queryCarOrderList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630436Req.class);
    }

}
