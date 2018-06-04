package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.dto.req.XN632757Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:17:59 
 * @history:
 */
public class XN632757 extends AProcessor {
    private ICompProductAO compProductAO = SpringContextHolder
        .getBean(ICompProductAO.class);

    private XN632757Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CompProduct condition = new CompProduct();
        condition.setCategoryCode(req.getCategoryCode());
        return compProductAO.queryCompProductList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632757Req.class);
        ObjValidater.validateReq(req);
    }

}
