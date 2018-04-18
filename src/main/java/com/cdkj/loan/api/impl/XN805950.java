package com.cdkj.loan.api.impl;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805950Req;
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
public class XN805950 extends AProcessor {
    private ISmsOutAO smsOutAO = SpringContextHolder.getBean(ISmsOutAO.class);

    private XN805950Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        smsOutAO.sendSmsCaptcha(req.getMobile(), req.getBizType(),
            req.getCompanyCode(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805950Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getBizType(),
            req.getCompanyCode(), req.getSystemCode());
        PhoneUtil.checkMobile(req.getMobile(), "请输入正确的手机号码");
    }
}
