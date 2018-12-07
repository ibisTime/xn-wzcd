package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行征信详情查
 * @author: CYL 
 * @since: 2018年11月30日 下午4:30:48 
 * @history:
 */
public class XN632128 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632128Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return creditAO.foundCreditIcbank(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632128Req.class);
        ObjValidater.validateReq(req);

    }

}
