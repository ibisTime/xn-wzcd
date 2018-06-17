package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 执行结果录入
 * @author: silver 
 * @since: 2018年6月16日 下午8:44:47 
 * @history:
 */
public class XN630562 extends AProcessor {
    private IJudgeAO judgeAO = SpringContextHolder.getBean(IJudgeAO.class);

    private XN630562Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        judgeAO.judgeResultInput(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630562Req.class);
        ObjValidater.validateReq(req);
    }

}
