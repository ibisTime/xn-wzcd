package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632302Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除逾期名单
 * @author: CYL 
 * @since: 2018年6月2日 下午11:10:37 
 * @history:
 */
public class XN632302 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632302Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        overdueMenuAO.deleteOverdueMenu(req.getCodeList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632302Req.class);
        ObjValidater.validateReq(req);
    }

}
