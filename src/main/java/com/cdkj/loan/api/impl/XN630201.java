package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630201Req;
import com.cdkj.loan.dto.res.XN630201Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * C端用户登录
 * @author: CYL 
 * @since: 2018年4月24日 下午5:32:31 
 * @history:
 */
public class XN630201 extends AProcessor {

    private ICUserAO cuserAO = SpringContextHolder.getBean(ICUserAO.class);

    private XN630201Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN630201Res(
            cuserAO.doCaptchaLoginReg(req.getLoginName(), req.getLoginPwd()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630201Req.class);
        ObjValidater.validateReq(req);
    }

}
