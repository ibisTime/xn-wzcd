package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ICNavigateAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.CNavigate;
import com.cdkj.coin.dto.req.XN805800Req;
import com.cdkj.coin.dto.res.PKCodeRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 新增导航
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN805800 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805800Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CNavigate result = new CNavigate();
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
        result.setSystemCode(req.getSystemCode());
        String code = cNavigateAO.addCNavigate(result);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805800Req.class);
        StringValidater.validateBlank(req.getName(), req.getType(),
            req.getStatus(), req.getLocation(), req.getOrderNo(),
            req.getBelong(), req.getCompanyCode(), req.getSystemCode());
    }
}
