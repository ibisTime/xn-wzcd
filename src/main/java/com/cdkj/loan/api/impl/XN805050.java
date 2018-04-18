package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805050Req;
import com.cdkj.loan.dto.res.XN805050Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 普通登录
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:39:17 
 * @history:
 */
public class XN805050 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805050Res(userAO.doLogin(req.getLoginName(),
            req.getLoginPwd(), req.getKind(), req.getCompanyCode(),
            req.getSystemCode()));
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805050Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getLoginPwd(),
            req.getKind(), req.getSystemCode());
    }
}
