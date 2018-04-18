package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802756Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 取现详情
 * @author: xieyj 
 * @since: 2017年5月17日 下午6:35:28 
 * @history:
 */
public class XN802756 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802756Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return withdrawAO.getWithdraw(req.getCode(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802756Req.class);
        StringValidater.validateBlank(req.getCode(), req.getSystemCode());

    }

}
