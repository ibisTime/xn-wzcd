package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632186Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询垫资单
 * @author: jiafr 
 * @since: 2018年6月17日 下午9:11:46 
 * @history:
 */
public class XN632186 extends AProcessor {
    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632186Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return advanceFundAO.getAdvanceFund(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632186Req.class);
        ObjValidater.validateReq(req);
    }
}
