package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 提前还款(管理端)
 * @author: CYL 
 * @since: 2018年5月8日 上午10:32:21 
 * @history:
 */
public class XN630512 extends AProcessor {
    private IRepayBizAO repayBizBO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630512Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizBO.advanceRepayOss(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630512Req.class);
        ObjValidater.validateReq(req);
    }

}
