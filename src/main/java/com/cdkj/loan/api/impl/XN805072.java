package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805072Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 关闭谷歌验证
 * @author: haiqingzheng 
 * @since: 2017年12月6日 下午4:10:53 
 * @history:
 */
public class XN805072 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805072Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.closeGoogleAuth(req.getUserId(), req.getSmsCaptcha(),
            req.getGoogleCaptcha());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805072Req.class);
        ObjValidater.validateReq(req);
    }

}
