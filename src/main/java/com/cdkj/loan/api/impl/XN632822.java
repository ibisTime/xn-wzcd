package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.dto.req.XN632822Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 角色-修改
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XN632822 extends AProcessor {
    private IArchiveLocationAO archiveLocationAO = SpringContextHolder
        .getBean(IArchiveLocationAO.class);

    private XN632822Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ArchiveLocation data = new ArchiveLocation();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        archiveLocationAO.editArchiveLocation(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632822Req.class);
        ObjValidater.validateReq(req);
    }
}
