package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.dto.req.XN630192Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:15:45 
 * @history:
 */
public class XN630192 extends AProcessor {
    private IBizTeamAO bizTeamAO = SpringContextHolder
        .getBean(IBizTeamAO.class);

    private XN630192Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BizTeam data = new BizTeam();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setCaptain(req.getCaptain());
        data.setAccountCode(req.getAccountCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        bizTeamAO.editBizTeam(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630192Req.class);
        ObjValidater.validateReq(req);
    }
}
