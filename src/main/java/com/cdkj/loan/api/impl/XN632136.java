package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 补件原因详情查
 * @author: CYL 
 * @since: 2018年7月14日 下午4:58:03 
 * @history:
 */
public class XN632136 extends AProcessor {
    private ISupplementReasonAO supplementReasonAO = SpringContextHolder
        .getBean(ISupplementReasonAO.class);

    private XN632135Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return supplementReasonAO.getSupplementReason(req.getId());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632135Req.class);
        ObjValidater.validateReq(req);
    }

}
