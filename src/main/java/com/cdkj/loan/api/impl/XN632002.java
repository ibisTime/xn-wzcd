package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632002Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改收款账号
 * @author: CYL 
 * @since: 2018年5月26日 下午4:45:30 
 * @history:
 */
public class XN632002 extends AProcessor {
    private ICollectBankcardAO collectBankcardAO = SpringContextHolder
        .getBean(ICollectBankcardAO.class);

    private XN632002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        collectBankcardAO.editCollectBankcard(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632002Req.class);
        ObjValidater.validateReq(req);
    }

}
