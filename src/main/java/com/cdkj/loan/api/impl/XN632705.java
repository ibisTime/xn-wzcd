package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.dto.req.XN632705Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询gps列表
 * @author: xieyj 
 * @since: 2018年5月26日 下午9:22:19 
 * @history:
 */
public class XN632705 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632705Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Gps condition = new Gps();
        condition.setGpsDevNo(req.getGpsDevNo());
        condition.setGpsType(req.getGpsType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyApplyCode(req.getCompanyApplyCode());
        condition.setCompanyApplyStatus(req.getCompanyApplyStatus());
        condition.setApplyUser(req.getApplyUser());
        condition.setApplyStatus(req.getApplyStatus());
        condition.setUseStatus(req.getUseStatus());
        condition.setBizCode(req.getBizCode());
        condition.setSupplierCode(req.getSupplierCode());
        condition.setIsSendBack(req.getIsSendBack());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return gpsAO.queryGpsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632705Req.class);
        ObjValidater.validateReq(req);
    }

}
