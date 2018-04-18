package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Jour;
import com.cdkj.loan.dto.req.XN802524Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 我的流水查询
 * @author: xieyj 
 * @since: 2016年12月24日 上午7:59:19 
 * @history:
 */
public class XN802524 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802524Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jour condition = new Jour();
        condition.setKind(req.getKind());
        condition.setAccountNumber(req.getAccountNumber());
        condition.setBizType(req.getBizType());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return jourAO.queryJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802524Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater.validateBlank(req.getAccountNumber());
    }
}
