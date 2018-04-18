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
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Arbitrate;
import com.cdkj.loan.dto.req.XN625265Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
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
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625265Req.class);
        ObjValidater.validateReq(req);
    }

}
