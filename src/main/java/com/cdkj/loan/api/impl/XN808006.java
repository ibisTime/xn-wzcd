package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN808006Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 类别详情
 * @author: xieyj 
 * @since: 2016年10月28日 上午9:59:03 
 * @history:
 */
public class XN808006 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return categoryAO.getCategory(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808006Req.class);
        ObjValidater.validateReq(req);
    }
}
