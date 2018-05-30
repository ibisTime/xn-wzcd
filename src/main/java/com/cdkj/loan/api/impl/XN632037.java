package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.dto.req.XN632037Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午5:41:47 
 * @history:
 */
public class XN632037 extends AProcessor {

    private IBankAO bankAO = SpringContextHolder.getBean(IBankAO.class);

    private XN632037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bank condition = new Bank();
        condition.setBankCode(req.getBankCode());
        condition.setBankName(req.getBankName());
        condition.setSubbranch(req.getSubbranch());
        condition.setStatus(req.getStatus());
        return bankAO.queryBankList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632037Req.class);
        ObjValidater.validateReq(req);
    }

}
