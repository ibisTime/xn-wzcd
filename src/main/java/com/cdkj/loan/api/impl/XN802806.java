package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IHLOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802806Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询红冲蓝补订单
 * @author: xieyj 
 * @since: 2017年5月15日 下午4:07:42 
 * @history:
 */
public class XN802806 extends AProcessor {
    private IHLOrderAO hlOrderAO = SpringContextHolder
        .getBean(IHLOrderAO.class);

    private XN802806Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return hlOrderAO.getHLOrder(req.getCode(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802806Req.class);
        StringValidater.validateBlank(req.getCode(), req.getSystemCode());
    }
}
