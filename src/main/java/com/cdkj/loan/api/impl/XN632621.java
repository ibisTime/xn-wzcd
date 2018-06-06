package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.ITravelApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.TravelApply;
import com.cdkj.loan.dto.req.XN632621Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核出差申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:58:59 
 * @history:
 */
public class XN632621 extends AProcessor {
    private ITravelApplyAO travelApplyAO = SpringContextHolder
        .getBean(ITravelApplyAO.class);

    private XN632621Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        TravelApply data = new TravelApply();
        data.setCode(req.getCode());
        data.setStatus(req.getApproveResult());
        data.setRemark(req.getRemark());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        travelApplyAO.editTravelApply(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632621Req.class);
        ObjValidater.validateReq(req);
    }

}
