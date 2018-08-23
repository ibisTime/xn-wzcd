package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632188Req;
import com.cdkj.loan.dto.res.XN632188Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午8:02:51 
 * @history:
 */
public class XN632188 extends AProcessor {

    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632188Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        XN632188Res res = advanceFundAO.queryAdvanceFundListForBranch(
            req.getCompanyCode(), req.getCurNodeCode());
        return res;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632188Req.class);
        ObjValidater.validateReq(req);
    }
}
