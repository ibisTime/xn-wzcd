package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.dto.req.XN632707Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询gps
 * @author: xieyj 
 * @since: 2018年5月26日 下午9:28:45 
 * @history:
 */
public class XN632707 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632707Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Gps condition = new Gps();
        condition.setGpsDevNo(req.getGpsDevNo());
        condition.setGpsType(req.getGpsType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setApplyStatus(req.getApplyStatus());
        condition.setUseStatus(req.getUseStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return gpsAO.queryGpsList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632707Req.class);
        ObjValidater.validateReq(req);
    }
}
