package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805195Req;
import com.cdkj.coin.enums.EIDKind;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 三方实名认证_芝麻认证（芝麻信用渠道）
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:15:00 
 * @history:
 */
public class XN805195 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805195Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.doZhimaIdentify(req.getUserId(),
            EIDKind.IDCard.getCode(), req.getIdNo(), req.getRealName(),
            req.getReturnUrl(), req.getLocalCheck());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805195Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdNo(),
            req.getRealName());
    }
}
