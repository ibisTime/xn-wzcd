package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630137Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查用户
 * @author: nyc 
 * @since: 2018年4月24日 上午11:30:04 
 * @history:
 */
public class XN630137 extends AProcessor {

    private ISaleUserAO userAO = SpringContextHolder.getBean(ISaleUserAO.class);

    private XN630137Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.getSaleUser(req.getUserId());

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630137Req.class);
        ObjValidater.validateReq(req);
    }

}
