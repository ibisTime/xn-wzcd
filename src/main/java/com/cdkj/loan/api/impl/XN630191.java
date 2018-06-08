package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630191Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:09:24 
 * @history:
 */
public class XN630191 extends AProcessor {
    private IBizTeamAO bizTeamAO = SpringContextHolder
        .getBean(IBizTeamAO.class);

    private XN630191Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bizTeamAO.dropBizTeam(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630191Req.class);
        ObjValidater.validateReq(req);
    }
}
