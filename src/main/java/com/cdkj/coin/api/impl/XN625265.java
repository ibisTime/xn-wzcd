/**
 * @Title XN625240.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月14日 下午12:40:28 
 * @version V1.0   
 */
package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IArbitrateAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.Arbitrate;
import com.cdkj.coin.dto.req.XN625265Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 分页查询仲裁订单
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625265 extends AProcessor {

    private IArbitrateAO arbitrateAO = SpringContextHolder
        .getBean(IArbitrateAO.class);

    private XN625265Req req;

    /** 
     * @see com.cdkj.coin.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Arbitrate condition = new Arbitrate();
        condition.setCode(req.getCode());
        condition.setTradeOrderCode(req.getTradeOrderCode());
        condition.setYuangao(req.getYuangao());
        condition.setBeigao(req.getBeigao());
        condition.setUpdater(req.getUpdater());
        condition.setOrder("create_datetime", "desc");
        condition.setResult(req.getResult());
        condition.setStatus(req.getStatus());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return arbitrateAO.queryArbitratePage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.coin.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625265Req.class);
        ObjValidater.validateReq(req);
    }

}
