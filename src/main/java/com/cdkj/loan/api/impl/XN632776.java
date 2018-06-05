package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IStorageOutAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632776Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细传出库
 * @author: silver 
 * @since: 2018年6月5日 下午2:49:10 
 * @history:
 */
public class XN632776 extends AProcessor {
    private IStorageOutAO storageOutAO = SpringContextHolder
        .getBean(IStorageOutAO.class);

    private XN632776Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return storageOutAO.getStorageOut(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632776Req.class);
        ObjValidater.validateReq(req);
    }
}
