package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IHLOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN802806Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
