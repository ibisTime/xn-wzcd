package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.dto.req.XN808068Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 我的订单分页查询（前端）
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808068 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN808068Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        if ("repaying".equals(req.getStatus())) {

        }
        if ("repayed".equals(req.getStatus)) {

        }

        Order condition = new Order();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatusList(req.getStatusList());
        condition.setFrontStatus("1");// 前端过滤已删除订单
        condition.setPayType(req.getPayType());
        condition.setPayGroup(req.getPayGroup());
        condition.setPayCode(req.getPayCode());
        condition.setDeliverer(req.getDeliverer());
        condition.setLogisticsCode(req.getLogisticsCode());
        condition.setLogisticsCompany(req.getLogisticsCompany());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getCreateDatetimeStart(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getCreateDatetimeEnd(), DateUtil.DATA_TIME_PATTERN_1));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return orderAO.queryMyOrderPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808068Req.class);
        StringValidater.validateBlank(req.getApplyUser());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
