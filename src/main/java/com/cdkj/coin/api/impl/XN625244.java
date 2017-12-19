/**
 * @Title XN625240.java
 * @Package com.cdkj.coin.api.impl
 * @Description
 * @author leo(haiqing)
 * @date 2017年11月14日 下午12:40:28
 * @version V1.0
 */
package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.dto.req.XN625244Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 卖家释放
 * @author: haiqingzheng
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625244 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private IAdsAO adsSellAO = SpringContextHolder.getBean(IAdsAO.class);

    private XN625244Req req;

    /**
     * @see com.cdkj.coin.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        TradeOrder tradeOrder = tradeOrderAO.release(req.getCode(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);

    }

    /**
     * @see com.cdkj.coin.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625244Req.class);
        ObjValidater.validateReq(req);
    }

}
