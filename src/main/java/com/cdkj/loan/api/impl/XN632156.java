package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632156Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询资料传递
 * @author: silver 
 * @since: 2018年5月30日 下午5:12:49 
 * @history:
 */
public class XN632156 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN632156Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return logisticsAO.getLogistics(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632156Req.class);
        ObjValidater.validateReq(req);
    }

}
