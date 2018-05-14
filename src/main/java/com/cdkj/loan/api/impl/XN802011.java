package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802011Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午5:54:08 
 * @history:
 */
public class XN802011 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankCardAO.dropBankcard(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802011Req.class);
        ObjValidater.validateReq(req);
    }

}
