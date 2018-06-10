package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.dto.req.XN632310Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认返点支付
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:13:26 
 * @history:
 */
public class XN632310 extends AProcessor {
    private IRepointAO repointAO = SpringContextHolder
        .getBean(IRepointAO.class);

    private XN632310Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Repoint data = new Repoint();
        data.setTeamCode(req.getTeamCode());
        data.setBizCode(req.getBizCode());
        data.setShouldAmount(StringValidater.toLong(req.getShouldAmount()));
        data.setActualAmount(StringValidater.toLong(req.getActualAmount()));
        data.setWaterBill(req.getWaterBill());
        data.setRemark(req.getRemark());
        data.setStatus("1");
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setCode(req.getCode());
        repointAO.editRepoint(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632310Req.class);
        ObjValidater.validateReq(req);
    }

}
