package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632802Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午8:53:50 
 * @history:
 */
public class XN632802 extends AProcessor {
    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632802Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        archiveAO.editArchive(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632802Req.class);
        ObjValidater.validateReq(req);
    }
}
