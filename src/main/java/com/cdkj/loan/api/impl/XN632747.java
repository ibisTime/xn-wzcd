package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompCategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.dto.req.XN632747Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:14:34 
 * @history:
 */
public class XN632747 extends AProcessor {
    private ICompCategoryAO compCategoryAO = SpringContextHolder
        .getBean(ICompCategoryAO.class);

    private XN632747Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CompCategory condition = new CompCategory();
        condition.setName(req.getName());
        return compCategoryAO.queryCompCategoryList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632747Req.class);
        ObjValidater.validateReq(req);
    }

}
