package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITotalAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632176Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认打款给分公司
 * @author: jiafr 
 * @since: 2018年6月17日 下午3:00:21 
 * @history:
 */
public class XN632176 extends AProcessor {
    private ITotalAdvanceFundAO totalAdvanceFundAO = SpringContextHolder
        .getBean(ITotalAdvanceFundAO.class);

    private XN632176Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        totalAdvanceFundAO.confirmPayBranchCompany(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632176Req.class);
        ObjValidater.validateReq(req);
    }
}
