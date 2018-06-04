package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompCategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632746Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:16:47 
 * @history:
 */
public class XN632746 extends AProcessor {
    private ICompCategoryAO compCategoryAO = SpringContextHolder
        .getBean(ICompCategoryAO.class);

    private XN632746Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return compCategoryAO.getCompCategory(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632746Req.class);
        ObjValidater.validateReq(req);
    }
}
