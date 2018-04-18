/**
 * @Title XN625200.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月8日 下午3:12:21 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEthAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625202Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 弃用
 * @author: haiqingzheng 
 * @since: 2017年11月8日 下午3:12:21 
 * @history:
 */
public class XN625202 extends AProcessor {

    private IEthAddressAO ethAddressAO = SpringContextHolder
        .getBean(IEthAddressAO.class);

    private XN625202Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        ethAddressAO.abandonAddress(req.getCode());
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625202Req.class);
        ObjValidater.validateReq(req);
    }

}
