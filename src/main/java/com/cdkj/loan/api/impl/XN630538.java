package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOverdueTreatmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.OverdueTreatment;
import com.cdkj.loan.dto.req.XN630538Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查逾期处理
 * @author: CYL 
 * @since: 2018年8月2日 下午8:19:36 
 * @history:
 */
public class XN630538 extends AProcessor {

    private IOverdueTreatmentAO overdueTreatmentAO = SpringContextHolder
        .getBean(IOverdueTreatmentAO.class);

    private XN630538Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OverdueTreatment condition = new OverdueTreatment();
        condition.setRepayPlanCode(req.getRepayPlanCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IOverdueTreatmentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return overdueTreatmentAO.queryOverdueTreatmentPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630538Req.class);
        ObjValidater.validateReq(req);
    }

}
