package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805063Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
            req.getNewLoginPwd(), req.getKind());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805063Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getKind(), req.getCompanyCode(),
            req.getSystemCode());
    }
}
