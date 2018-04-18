package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805062Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改手机号(需支付密码)
 * @author: myb858 
 * @since: 2015年9月15日 下午2:36:27 
 * @history:
 */
public class XN805062 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doChangeMoblie(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha(), req.getTradePwd());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805062Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha(), req.getTradePwd());
    }
}
