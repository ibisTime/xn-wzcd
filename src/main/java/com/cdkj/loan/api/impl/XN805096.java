package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805096Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改交易广告费率
 * @author: xieyj 
 * @since: 2017年7月16日 下午4:16:53 
 * @history:
 */
public class XN805096 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805096Req req = null;

    /** 
     * @see com.std.user.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        userAO.doModifyTradeRate(req.getUserId(),
            StringValidater.toDouble(req.getTradeRate()), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.std.user.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805096Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradeRate(),
            req.getUpdater());
    }

}
