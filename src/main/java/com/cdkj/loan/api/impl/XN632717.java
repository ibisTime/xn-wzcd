package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.dto.req.XN632717Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询gps申领列表
 * @author: silver 
 * @since: 2018年5月31日 上午2:29:21 
 * @history:
 */
public class XN632717 extends AProcessor {
    private IGpsApplyAO gpsApplyAO = SpringContextHolder
        .getBean(IGpsApplyAO.class);

    private XN632717Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GpsApply condition = new GpsApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setCompanyCode(req.getCompany());
        condition.setStatus(req.getStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        return gpsApplyAO.queryGpsApplyList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632717Req.class);
        ObjValidater.validateReq(req);
    }
}
