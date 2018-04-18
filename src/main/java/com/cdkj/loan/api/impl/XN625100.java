/**
 * @Title XN625100.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月9日 下午7:00:49 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.cdkj.loan.ao.IEthCollectionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN625100Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 手动归集
 * @author: haiqingzheng 
 * @since: 2017年11月9日 下午7:00:49 
 * @history:
 */
public class XN625100 extends AProcessor {

    private IEthCollectionAO ethCollectionAO = SpringContextHolder
        .getBean(IEthCollectionAO.class);

    private XN625100Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BigDecimal balanceStart = Convert.toWei(
            StringValidater.toBigDecimal(req.getBalanceStart()), Unit.ETHER);
        ethCollectionAO.collectionManual(balanceStart);
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625100Req.class);
        ObjValidater.validateReq(req);
    }

}
