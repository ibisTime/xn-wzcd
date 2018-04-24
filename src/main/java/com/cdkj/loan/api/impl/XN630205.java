package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CUser;
import com.cdkj.loan.dto.req.XN630205Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN630205 extends AProcessor {

    private ICUserAO cuserAO = SpringContextHolder.getBean(ICUserAO.class);

    private XN630205Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CUser condition = new CUser();
        condition.setLoginName(req.getLoginName());
        condition.setMobile(req.getMobile());
        condition.setUserReferee(req.getUserReferee());
        condition.setIdKind(req.getIdKind());
        condition.setIdNo(StringValidater.toLong(req.getIdNo()));
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return cuserAO.queryCUserPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630205Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
