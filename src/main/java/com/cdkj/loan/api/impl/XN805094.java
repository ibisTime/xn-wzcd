package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805094Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 更新用户等级
 * @author: xieyj 
 * @since: 2017年4月1日 下午2:46:16 
 * @history:
 */
public class XN805094 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805094Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doUpLevel(req.getUserId(), req.getLevel());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805094Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getLevel());
    }
}
