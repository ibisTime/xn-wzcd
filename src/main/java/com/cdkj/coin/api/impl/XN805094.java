package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805094Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 更新用户等级
 * @author: xieyj 
 * @since: 2017年4月1日 下午2:46:16 
 * @history:
 */
public class XN805094 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805094Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doUpLevel(req.getUserId(), req.getLevel());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805094Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getLevel());
    }
}
