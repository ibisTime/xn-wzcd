package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.dto.req.XN808067Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808067 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808067Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Order condition = new Order();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        condition.setPayGroup(req.getPayGroup());
        condition.setPayCode(req.getPayCode());
        condition.setDeliverer(req.getDeliverer());
        condition.setLogisticsCode(req.getLogisticsCode());
        condition.setLogisticsCompany(req.getLogisticsCompany());
        return orderAO.queryOrderList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808067Req.class);
    }
}
