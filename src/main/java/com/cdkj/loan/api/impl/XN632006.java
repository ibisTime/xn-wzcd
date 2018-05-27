package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632006Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询收款账号
 * @author: CYL 
 * @since: 2018年5月25日 下午4:48:11 
 * @history:
 */
public class XN632006 extends AProcessor {
    private ICollectBankcardAO collectBankcardAO = SpringContextHolder
        .getBean(ICollectBankcardAO.class);

    private XN632006Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return collectBankcardAO.getCollectBankcard(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632006Req.class);
        ObjValidater.validateReq(req);
    }

}
