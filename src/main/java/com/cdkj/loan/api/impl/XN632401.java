package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISysBonusesAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632401Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除奖金提成配置
 * @author: CYL 
 * @since: 2018年8月20日 下午7:14:46 
 * @history:
 */
public class XN632401 extends AProcessor {
    private ISysBonusesAO sysBonusesAO = SpringContextHolder
        .getBean(ISysBonusesAO.class);

    private XN632401Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysBonusesAO.dropSysBonuses(StringValidater.toInteger(req.getId()));
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632401Req.class);
        ObjValidater.validateReq(req);
    }

}
