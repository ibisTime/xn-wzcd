package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805193Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 三方实名认证_芝麻认证（支付宝渠道）
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:15:00 
 * @history:
 */
public class XN805193 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805193Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.doAlipayZhimaIdentify(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805193Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());
    }
}
