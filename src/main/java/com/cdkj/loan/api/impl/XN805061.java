package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805061Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改手机号
 * @author: xieyj 
 * @since: 2016年12月27日 下午9:01:00 
 * @history:
 */
public class XN805061 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doChangeMoblie(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805061Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha());
    }
}
