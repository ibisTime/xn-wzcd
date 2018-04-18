package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805194Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 三方实名认证_芝麻认证查询（芝麻信用渠道）
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:15:00 
 * @history:
 */
public class XN805196 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805194Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.doZhimaQuery(req.getUserId(), req.getBizNo());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805194Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getBizNo());
    }
}
