package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805093Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 修改分配比例
 * @author: xieyj 
 * @since: 2017年7月16日 下午4:16:53 
 * @history:
 */
public class XN805093 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805093Req req = null;

    /** 
     * @see com.std.user.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        userAO.doModifyDivRate(req.getUserId(),
            StringValidater.toDouble(req.getDivRate1()),
            StringValidater.toDouble(req.getDivRate2()), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.std.user.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805093Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getDivRate1(),
            req.getDivRate2(), req.getUpdater());
    }

}
