package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompCategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632740Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:02:20 
 * @history:
 */
public class XN632740 extends AProcessor {

    private ICompCategoryAO compCategoryAO = SpringContextHolder
        .getBean(ICompCategoryAO.class);

    private XN632740Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(compCategoryAO.addCompCategory(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632740Req.class);
        ObjValidater.validateReq(req);
    }
}
