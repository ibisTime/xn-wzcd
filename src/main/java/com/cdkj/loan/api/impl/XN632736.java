package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRegimeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632736Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:56:48 
 * @history:
 */
public class XN632736 extends AProcessor {

    private IRegimeAO regimeAO = SpringContextHolder.getBean(IRegimeAO.class);

    private XN632736Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return regimeAO.getRegime(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632736Req.class);
        ObjValidater.validateReq(req);
    }
}
