package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Jour;
import com.cdkj.loan.dto.req.XN802523Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据业务订单编号(refNo)查询所有关联流水(front/oss)
 * @author: xieyj 
 * @since: 2016年12月24日 上午8:17:00 
 * @history:
 */
public class XN802523 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802523Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jour condition = new Jour();
        condition.setRefNo(req.getRefNo());
        condition.setSystemCode(req.getSystemCode());
        return jourAO.queryJourList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802523Req.class);
        StringValidater.validateBlank(req.getRefNo(), req.getSystemCode());
    }
}
