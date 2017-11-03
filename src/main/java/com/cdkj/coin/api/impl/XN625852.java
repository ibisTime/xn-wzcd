/**
 * @Title XN623800.java 
 * @Package com.cdkj.ylq.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年8月21日 下午9:19:46 
 * @version V1.0   
 */
package com.cdkj.coin.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.coin.ao.IAccountOldAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN623852Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 取现订单广播
 * @author: haiqingzheng 
 * @since: 2017年8月21日 下午9:19:46 
 * @history:
 */
public class XN625852 extends AProcessor {

    private IAccountOldAO accountAO = SpringContextHolder
        .getBean(IAccountOldAO.class);

    private XN623852Req req = null;

    /** 
     * @see com.cdkj.ylq.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        for (String code : req.getCodeList()) {
            accountAO.payOrder(code, req.getPayUser(), req.getPayResult(),
                req.getPayNote());
        }
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.ylq.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623852Req.class);
        if (CollectionUtils.isEmpty(req.getCodeList())) {
            throw new BizException("订单列表不能为空");
        }
        StringValidater.validateBlank(req.getPayUser(), req.getPayResult(),
            req.getPayNote());
    }

}
