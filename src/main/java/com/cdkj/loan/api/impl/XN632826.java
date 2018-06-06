package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632826Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询档案存放位置
 * @author: jiafr 
 * @since: 2018年6月6日 下午9:21:04 
 * @history:
 */
public class XN632826 extends AProcessor {
    private IArchiveLocationAO archiveLocationAO = SpringContextHolder
        .getBean(IArchiveLocationAO.class);

    private XN632826Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return archiveLocationAO.getArchiveLocation(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632826Req.class);
        ObjValidater.validateReq(req);
    }
}
