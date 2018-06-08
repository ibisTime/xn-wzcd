package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630196Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业务团队详情
 * @author: jiafr 
 * @since: 2018年6月8日 下午3:25:00 
 * @history:
 */
public class XN630196 extends AProcessor {
    private IBizTeamAO bizTeamAO = SpringContextHolder
        .getBean(IBizTeamAO.class);

    private XN630196Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bizTeamAO.getBizTeam(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630196Req.class);
        ObjValidater.validateReq(req);
    }
}
