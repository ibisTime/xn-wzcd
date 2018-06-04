package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632756Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:20:41 
 * @history:
 */
public class XN632756 extends AProcessor {
    private ICompProductAO compProductAO = SpringContextHolder
        .getBean(ICompProductAO.class);

    private XN632756Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return compProductAO.getCompProduct(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632756Req.class);
        ObjValidater.validateReq(req);
    }
}
