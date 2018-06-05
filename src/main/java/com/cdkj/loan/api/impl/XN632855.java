package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.EmployApply;
import com.cdkj.loan.dto.req.XN632855Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询应聘登记
 * @author: CYL 
 * @since: 2018年6月5日 下午3:45:08 
 * @history:
 */
public class XN632855 extends AProcessor {
    private IEmployApplyAO employApplyAO = SpringContextHolder
        .getBean(IEmployApplyAO.class);

    private XN632855Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        EmployApply condition = new EmployApply();
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IEmployApplyAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return employApplyAO.queryEmployApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632855Req.class);
        ObjValidater.validateReq(req);
    }

}
