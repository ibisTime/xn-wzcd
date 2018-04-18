package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805066Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 设置支付密码
 * @author: xieyj 
 * @since: 2017年7月16日 下午2:41:15 
 * @history:
 */
public class XN805066 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805066Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doSetTradePwd(req.getUserId(), req.getTradePwd(),
            req.getSmsCaptcha(), req.getGoogleCaptcha());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805066Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradePwd(),
            req.getSmsCaptcha());
    }

}
