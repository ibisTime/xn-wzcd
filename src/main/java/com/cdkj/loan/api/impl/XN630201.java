package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630201Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除团队成员
 * @author: jiafr 
 * @since: 2018年6月8日 下午5:42:06 
 * @history:
 */
public class XN630201 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XN630201Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysUserAO.doModifyTeam(req.getUserId(), null, req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630201Req.class);
        ObjValidater.validateReq(req);
    }
}
