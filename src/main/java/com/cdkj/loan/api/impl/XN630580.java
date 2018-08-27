package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630580Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 执行案件：申请执行
 * @author: CYL 
 * @since: 2018年8月25日 下午5:08:49 
 * @history:
 */
public class XN630580 extends AProcessor {
    private IJudgeAO judgeAO = SpringContextHolder.getBean(IJudgeAO.class);

    private XN630580Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        judgeAO.applyImplement(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630580Req.class);
        ObjValidater.validateReq(req);
    }

}
