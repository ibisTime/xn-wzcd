package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630904Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 逾期客户清收进度表
 * @author: CYL 
 * @since: 2018年8月8日 上午11:35:18 
 * @history:
 */
public class XN630904 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630904Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayBiz condition = new RepayBiz();
        condition.setCode(req.getCode());
        condition.setRealName(req.getRealName());
        condition.setLoanBank(req.getLoanBankCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IRepayBizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return repayBizAO.queryRepayBizByOverdue(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630904Req.class);
        ObjValidater.validateReq(req);
    }

}
