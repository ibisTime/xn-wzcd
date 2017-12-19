package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ISmsOutAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805952Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 发送邮件验证码
 * @author: xieyj 
 * @since: 2016年10月17日 下午7:23:10 
 * @history:
 */
public class XN805952 extends AProcessor {
    private ISmsOutAO smsOutAO = SpringContextHolder.getBean(ISmsOutAO.class);

    private XN805952Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        smsOutAO.sendEmailCaptcha(req.getEmail(), req.getBizType(),
            req.getCompanyCode(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805952Req.class);
        StringValidater.validateBlank(req.getEmail(), req.getBizType(),
            req.getCompanyCode(), req.getSystemCode());
    }
}
