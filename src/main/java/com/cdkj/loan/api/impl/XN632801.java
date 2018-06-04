package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632801Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午8:33:59 
 * @history:
 */
public class XN632801 extends AProcessor {
    private IArchiveAO rchiveAO = SpringContextHolder.getBean(IArchiveAO.class);

    private XN632801Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        rchiveAO.dropArchive(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632801Req.class);
        ObjValidater.validateReq(req);
    }
}
