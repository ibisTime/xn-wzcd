package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632306Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询逾期客户
 * @author: CYL 
 * @since: 2018年6月2日 下午11:10:10 
 * @history:
 */
public class XN632306 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632306Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return overdueMenuAO.getOverdueMenu(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632306Req.class);
        ObjValidater.validateReq(req);
    }

}
