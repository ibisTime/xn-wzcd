package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632301Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 处理逾期名单
 * @author: CYL 
 * @since: 2018年6月2日 下午11:10:37 
 * @history:
 */
public class XN632301 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632301Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        overdueMenuAO.handleOverdueMenu(req.getCode(), req.getRepayBizCode(),
            req.getRepayBizList(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632301Req.class);
        ObjValidater.validateReq(req);
    }

}
