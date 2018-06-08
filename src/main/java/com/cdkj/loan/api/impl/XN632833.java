package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632833Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 合同到期预警
 * @author: CYL 
 * @since: 2018年6月8日 下午1:09:21 
 * @history:
 */
public class XN632833 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632833Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return contractAO.getEarlyWarning(req.getYear(), req.getMonth());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632833Req.class);
        ObjValidater.validateReq(req);
    }
}
