package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632157Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询资料传递
 * @author: silver 
 * @since: 2018年5月30日 下午1:47:16 
 * @history:
 */
public class XN632157 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN632157Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Logistics condition = new Logistics();
        condition.setBizCode(req.getBizCode());
        condition.setUserId(req.getUserId());
        // condition.setBizNodeCode(req.getBizNodeCode());
        condition.setStatus(req.getStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return logisticsAO.queryLogisticsList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632157Req.class);
        ObjValidater.validateReq(req);
    }
}
