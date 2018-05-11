package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISmsOutAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630090Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 发送短信验证码
 * @author: xieyj 
 * @since: 2016年10月17日 下午7:23:10 
 * @history:
 */
public class XN630090 extends AProcessor {
    private ISmsOutAO smsOutAO = SpringContextHolder.getBean(ISmsOutAO.class);

    private XN630090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        smsOutAO.sendSmsCaptcha(req.getMobile(), req.getBizType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630090Req.class);
        ObjValidater.validateReq(req);
        PhoneUtil.checkMobile(req.getMobile(), "请输入正确的手机号码");
    }
}
