package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630200Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * C端用户注册
 * @author: CYL 
 * @since: 2018年4月24日 下午5:32:02 
 * @history:
 */
public class XN630200 extends AProcessor {

    private ICUserAO cuserAO = SpringContextHolder.getBean(ICUserAO.class);

    private XN630200Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return cuserAO.doCaptchaLoginReg(req.getMobile(), req.getSmsCaptcha());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630200Req.class);
        ObjValidater.validateReq(req);
    }

}
