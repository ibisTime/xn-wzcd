package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805161Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 收件地址 删除
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN805161 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN805161Req req = null;

    /**
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = addressAO.dropAddress(req.getCode());
        return new BooleanRes(count > 0 ? true : false);
    }

    /**
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805161Req.class);
        ObjValidater.validateReq(req);
    }
}
