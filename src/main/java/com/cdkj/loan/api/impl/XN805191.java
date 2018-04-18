package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805191Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 三方实名认证_两要素
 * @author: xieyj 
 * @since: 2016年11月22日 下午3:15:00 
 * @history:
 */
public class XN805191 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805191Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doTwoIdentify(req.getUserId(), req.getIdKind(), req.getIdNo(),
            req.getRealName());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805191Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());
    }
}
