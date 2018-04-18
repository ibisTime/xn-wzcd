package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805081Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 绑定邮箱
 * @author: xieyj 
 * @since: 2017年7月16日 下午3:01:12 
 * @history:
 */
public class XN805081 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805081Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doBindEmail(req.getUserId(), req.getEmail(), req.getCaptcha());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805081Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getEmail(),
            req.getCaptcha());
    }
}
