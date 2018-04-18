package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805193Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 三方实名认证_芝麻认证（支付宝渠道）
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:15:00 
 * @history:
 */
public class XN805193 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805193Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.doAlipayZhimaIdentify(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805193Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());
    }
}
