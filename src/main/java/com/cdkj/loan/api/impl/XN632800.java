package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632800Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午7:36:31 
 * @history:
 */
public class XN632800 extends AProcessor {
    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632800Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(archiveAO.addArchive(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632800Req.class);
        ObjValidater.validateReq(req);
    }

}
