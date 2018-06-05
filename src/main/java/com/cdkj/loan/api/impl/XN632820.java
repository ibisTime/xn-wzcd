package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.dto.req.XN632820Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午6:50:43 
 * @history:
 */
public class XN632820 extends AProcessor {
    private IArchiveLocationAO archiveLocationAO = SpringContextHolder
        .getBean(IArchiveLocationAO.class);

    private XN632820Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ArchiveLocation data = new ArchiveLocation();
        data.setName(req.getName());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        return new PKCodeRes(archiveLocationAO.addArchiveLocation(data));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632820Req.class);
        ObjValidater.validateReq(req);
    }

}
