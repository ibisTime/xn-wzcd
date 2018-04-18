package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICNavigateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CNavigate;
import com.cdkj.loan.dto.req.XN805802Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 修改导航
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN805802 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805802Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CNavigate result = new CNavigate();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setType(req.getType());
        result.setUrl(req.getUrl());
        result.setPic(req.getPic());
        result.setStatus(req.getStatus());
        result.setLocation(req.getLocation());
        result.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
        result.setBelong(req.getBelong());
        result.setParentCode(req.getParentCode());
        result.setRemark(req.getRemark());
        result.setContentType(req.getContentType());
        result.setCompanyCode(req.getCompanyCode());
        cNavigateAO.editCNavigate(result);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805802Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getType(), req.getStatus(), req.getLocation(),
            req.getOrderNo(), req.getBelong(), req.getCompanyCode());
    }
}
