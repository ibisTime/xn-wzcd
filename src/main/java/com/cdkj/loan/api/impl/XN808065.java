package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.dto.req.XN808065Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808065 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808065Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Order condition = new Order();
        condition.setCodeQuery(req.getCode());
        condition.setReceiver(req.getReceiver());
        condition.setReMobile(req.getReMobile());
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        condition.setPayType(req.getPayType());
        condition.setPayGroup(req.getPayGroup());
        condition.setPayCode(req.getPayCode());
        condition.setDeliverer(req.getDeliverer());
        condition.setLogisticsCode(req.getLogisticsCode());
        condition.setLogisticsCompany(req.getLogisticsCompany());
        condition.setApplyDatetimeStart(
            DateUtil.getFrontDate(req.getDateStart(), false));
        condition
            .setApplyDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(), true));
        condition.setPayDatetimeStart(
            DateUtil.getFrontDate(req.getPayDatetimeStart(), false));
        condition.setPayDatetimeEnd(
            DateUtil.getFrontDate(req.getPayDatetimeEnd(), true));
        condition.setStatusList(req.getStatusList());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return orderAO.queryOrderPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808065Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
