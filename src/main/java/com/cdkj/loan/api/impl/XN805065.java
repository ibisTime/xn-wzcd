package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805065Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * admin管理员重置密码
 * @author: xieyj 
 * @since: 2017年7月16日 下午2:19:27 
 * @history:
 */
public class XN805065 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doResetLoginPwdByOss(req.getUserId(), req.getLoginPwd(),
            req.getAdminUserId(), req.getAdminPwd());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805065Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getLoginPwd(),
            req.getAdminUserId(), req.getAdminPwd());
    }
}
