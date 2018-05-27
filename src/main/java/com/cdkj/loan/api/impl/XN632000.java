package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增收款账号
 * @author: CYL 
 * @since: 2018年5月26日 下午4:45:30 
 * @history:
 */
public class XN632000 extends AProcessor {
    private ICollectBankcardAO collectBankcardAO = SpringContextHolder
        .getBean(ICollectBankcardAO.class);

    private XN632000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(collectBankcardAO.addCollectBankcard(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632000Req.class);
        ObjValidater.validateReq(req);
    }

}
