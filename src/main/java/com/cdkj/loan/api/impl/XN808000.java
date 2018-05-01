package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN808000Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增类别，类别分为大类和小类，新增大类时，父节点填0
 * @author: xieyj 
 * @since: 2016年11月16日 下午5:18:26 
 * @history:
 */
public class XN808000 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = categoryAO.addCategory(req);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808000Req.class);
        ObjValidater.validateReq(req);
    }
}
