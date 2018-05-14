package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802010Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 绑定银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午5:04:53 
 * @history:
 */
public class XN802010 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankCardAO.addBankcard(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802010Req.class);
        ObjValidater.validateReq(req);
    }
}
