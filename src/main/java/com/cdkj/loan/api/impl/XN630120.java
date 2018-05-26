package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630120Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业务员普通注册
 * @author: CYL 
 * @since: 2018年5月26日 上午10:30:47 
 * @history:
 */
public class XN630120 extends AProcessor {
    private ISaleUserAO saleUserAO = SpringContextHolder
        .getBean(ISaleUserAO.class);

    private XN630120Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        synchronized (XN630120.class) {
            String userId = saleUserAO.doRegister(req.getMobile(),
                req.getLoginPwd(), req.getSmsCaptcha(), req.getType());

            return new PKCodeRes(userId);
        }

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630120Req.class);
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
        ObjValidater.validateReq(req);
    }
}
