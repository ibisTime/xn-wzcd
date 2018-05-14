package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.dto.req.XN802016Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午7:36:42 
 * @history:
 */
public class XN802016 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802016Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bankcard condition = new Bankcard();
        condition.setUserId(req.getUserId());
        condition.setBankName(req.getBankName());
        condition.setBankcardNumber(req.getBankcardNumber());
        condition.setStatus(req.getStatus());
        return bankCardAO.queryBankcardList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802016Req.class);
        ObjValidater.validateReq(req);
    }

}
