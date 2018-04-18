package com.cdkj.loan.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802753Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * @author: haiqingzheng 
 * @since: 2017年11月8日 下午2:07:37 
 * @history:
 */
public class XN802753 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802753Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        for (String code : req.getCodeList()) {
            withdrawAO.payOrder(code, req.getPayUser(), req.getPayResult(),
                req.getPayNote(), req.getChannelOrder(), req.getSystemCode());
        }
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802753Req.class);
        if (CollectionUtils.isEmpty(req.getCodeList())) {
            throw new BizException("订单列表不能为空");
        }
        StringValidater.validateBlank(req.getPayUser(), req.getPayResult(),
            req.getPayNote(), req.getSystemCode());
    }

}
