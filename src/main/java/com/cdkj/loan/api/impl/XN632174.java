package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITotalAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632174Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分公司制单（批量）
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:21:48 
 * @history:
 */
public class XN632174 extends AProcessor {
    private ITotalAdvanceFundAO totalAdvanceFundAO = SpringContextHolder
        .getBean(ITotalAdvanceFundAO.class);

    private XN632174Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(totalAdvanceFundAO.addTotalAdvanceFund(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632174Req.class);
        ObjValidater.validateReq(req);
    }

}
