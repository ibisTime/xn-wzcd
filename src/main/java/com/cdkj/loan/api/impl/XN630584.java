package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630584Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 执行案件：录入查封裁定到期时间
 * @author: CYL 
 * @since: 2018年8月25日 下午5:08:49 
 * @history:
 */
public class XN630584 extends AProcessor {
    private IJudgeAO judgeAO = SpringContextHolder.getBean(IJudgeAO.class);

    private XN630584Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        judgeAO.inputVerdict(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630584Req.class);
        ObjValidater.validateReq(req);
    }

}
