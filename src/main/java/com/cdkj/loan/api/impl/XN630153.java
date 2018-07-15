package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INodeFlowAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630153Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改材料清单
 * @author: xieyj 
 * @since: 2018年5月31日 上午12:54:10 
 * @history:
 */
public class XN630153 extends AProcessor {
    private INodeFlowAO nodeFlowAO = SpringContextHolder
        .getBean(INodeFlowAO.class);

    private XN630153Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630153Req.class);
        ObjValidater.validateReq(req);
    }

}
