package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630052Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改手机号
 * @author: CYL 
 * @since: 2018年5月26日 上午11:02:33 
 * @history:
 */
public class XN630122 extends AProcessor {

    private ISaleUserAO saleUserAO = SpringContextHolder
        .getBean(ISaleUserAO.class);

    private XN630052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        saleUserAO.doChangeMoblie(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630052Req.class);
        ObjValidater.validateReq(req);

    }

}
