package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802017Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午8:10:28 
 * @history:
 */
public class XN802017 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802017Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankCardAO.getBankcard(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802017Req.class);
        ObjValidater.validateReq(req);
    }

}
