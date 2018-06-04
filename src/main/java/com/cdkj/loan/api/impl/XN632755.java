package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.ao.ICompProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.dto.req.XN632755Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:12:03 
 * @history:
 */
public class XN632755 extends AProcessor {
    private ICompProductAO compProductAO = SpringContextHolder
        .getBean(ICompProductAO.class);

    private XN632755Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CompProduct condition = new CompProduct();
        condition.setName(req.getName());
        condition.setCategoryCode(req.getCategoryCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return compProductAO.queryCompProductPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632755Req.class);
        ObjValidater.validateReq(req);
    }

}
