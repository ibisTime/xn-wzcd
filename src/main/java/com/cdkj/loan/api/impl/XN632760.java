package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IStorageInAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632760Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 入库
 * @author: silver 
 * @since: 2018年6月5日 下午2:29:14 
 * @history:
 */
public class XN632760 extends AProcessor {

    private IStorageInAO storageInAO = SpringContextHolder
        .getBean(IStorageInAO.class);

    private XN632760Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(storageInAO.addStorageIn(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632760Req.class);
        ObjValidater.validateReq(req);
    }
}
