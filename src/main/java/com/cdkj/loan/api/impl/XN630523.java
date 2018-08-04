package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630523Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 逾期客户汇总分页查
 * @author: CYL 
 * @since: 2018年7月23日 下午5:32:32 
 * @history:
 */
public class XN630523 extends AProcessor {

    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630523Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayBiz condition = new RepayBiz();
        condition.setCode(req.getCode());
        condition.setUserId(req.getUserId());
        condition.setLoanBank(req.getLoanBank());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRepayBizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayBizAO.queryRepayBizByTotalOverdueCount(start, limit,
            condition, req.getCurOverdueCount());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630523Req.class);
        ObjValidater.validateReq(req);
    }
}
