package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISysBonusesAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632402Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改奖金提成配置
 * @author: CYL 
 * @since: 2018年8月20日 下午7:14:46 
 * @history:
 */
public class XN632402 extends AProcessor {
    private ISysBonusesAO sysBonusesAO = SpringContextHolder
        .getBean(ISysBonusesAO.class);

    private XN632402Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysBonusesAO.editSysBonuses(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632402Req.class);
        ObjValidater.validateReq(req);
    }

}
