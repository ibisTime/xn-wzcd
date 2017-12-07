package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805063Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 重置登录密码
 * @author: xieyj 
 * @since: 2017年7月16日 下午2:03:24 
 * @history:
 */
public class XN805063 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doResetLoginPwd(req.getMobile(), req.getSmsCaptcha(),
            req.getGoogleCaptcha(), req.getNewLoginPwd(), req.getKind(),
            req.getCompanyCode(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805063Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getKind(), req.getCompanyCode(),
            req.getSystemCode());
    }
}
