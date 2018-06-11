package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630520Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN630520 extends AProcessor {

    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630520Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayBiz condition = new RepayBiz();
        condition.setCode(req.getCode());
        condition.setUserId(req.getUserId());
        condition.setRefType(req.getRefType());
        condition.setCurNodeCodeList(req.getCurNodeCodeList());
        condition.setCurNodeCode(req.getCurNodeCode());

        condition.setKeyWord(req.getKeyWord());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRepayBizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayBizAO.queryRepayBizPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630520Req.class);
        ObjValidater.validateReq(req);
    }
}
