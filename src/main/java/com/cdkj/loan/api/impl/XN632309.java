package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOverdueRecordAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.OverdueRecord;
import com.cdkj.loan.dto.req.XN632309Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 逾期记录分页查
 * @author: CYL 
 * @since: 2018年9月14日 下午4:55:41 
 * @history:
 */
public class XN632309 extends AProcessor {
    private IOverdueRecordAO overdueRecordAO = SpringContextHolder
        .getBean(IOverdueRecordAO.class);

    private XN632309Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OverdueRecord condition = new OverdueRecord();
        condition.setCustomerName(req.getCustomerName());
        condition.setSign(req.getSign());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IOverdueRecordAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return overdueRecordAO.queryOverdueRecordPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632309Req.class);
        ObjValidater.validateReq(req);
    }

}
