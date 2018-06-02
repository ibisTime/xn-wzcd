package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632300Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 处理逾期客户
 * @author: CYL 
 * @since: 2018年6月2日 下午11:10:37 
 * @history:
 */
public class XN632301 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632300Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632300Req.class);
        ObjValidater.validateReq(req);
    }

}
