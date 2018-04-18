/**
 * @Title XN625205.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月8日 下午3:16:17 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEthAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625206Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 详情查询地址
 * @author: haiqingzheng 
 * @since: 2017年11月8日 下午3:16:17 
 * @history:
 */
public class XN625206 extends AProcessor {

    private IEthAddressAO ethAddressAO = SpringContextHolder
        .getBean(IEthAddressAO.class);

    private XN625206Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return ethAddressAO.getEthAddress(req.getCode());
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625206Req.class);
        ObjValidater.validateReq(req);
    }

}
