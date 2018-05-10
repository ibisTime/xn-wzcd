/**
 * @Title ZC703164.java 
 * @Package com.xnjr.cpzc.service.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年8月19日 下午7:48:10 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805163Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 设置默认地址
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN805163 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN805163Req req = null;

    /**
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = addressAO.setDefaultAddress(req.getCode());
        return new Boolean(count > 0 ? true : false);
    }

    /**
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805163Req.class);
        ObjValidater.validateReq(req);
    }
}
