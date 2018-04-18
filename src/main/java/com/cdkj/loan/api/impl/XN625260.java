/**
 * @Title XN625240.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月14日 下午12:40:28 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArbitrateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625260Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 处理仲裁订单
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625260 extends AProcessor {

    private IArbitrateAO arbitrateAO = SpringContextHolder
        .getBean(IArbitrateAO.class);

    private XN625260Req req;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        arbitrateAO.handle(req.getCode(), req.getResult(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625260Req.class);
        ObjValidater.validateReq(req);
    }

}
