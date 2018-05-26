package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630129Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改用户头像
 * @author: CYL 
 * @since: 2018年5月26日 上午11:12:46 
 * @history:
 */
public class XN630129 extends AProcessor {

    private ISaleUserAO userAO = SpringContextHolder.getBean(ISaleUserAO.class);

    private XN630129Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.modifyPhoto(req.getUserId(), req.getPhoto());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630129Req.class);
        ObjValidater.validateReq(req);

    }

}
