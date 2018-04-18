package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802758Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 取现对账详情
 * @author: xieyj 
 * @since: 2017年5月17日 下午6:35:28 
 * @history:
 */
public class XN802758 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802758Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return withdrawAO.getWithdrawCheckInfo(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802758Req.class);
        ObjValidater.validateReq(req);
    }

}
