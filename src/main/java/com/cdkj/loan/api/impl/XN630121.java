package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630121Req;
import com.cdkj.loan.dto.res.XN805050Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 普通登录
 * @author: CYL 
 * @since: 2018年5月26日 上午10:40:03 
 * @history:
 */
public class XN630121 extends AProcessor {
    private ISaleUserAO saleUserAO = SpringContextHolder
        .getBean(ISaleUserAO.class);

    private XN630121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805050Res(saleUserAO.doLogin(req.getLoginName(),
            req.getLoginPwd(), req.getType()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630121Req.class);
        ObjValidater.validateReq(req);
    }
}
