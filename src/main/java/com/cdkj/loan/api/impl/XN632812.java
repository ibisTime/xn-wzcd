package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.dto.req.XN632812Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增离职档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:51:37 
 * @history:
 */
public class XN632812 extends AProcessor {
    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632812Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Archive data = new Archive();
        data.setCode(req.getCode());
        data.setRealName(req.getRealName());
        data.setLeaveDatetime(DateUtil.strToDate(req.getLeaveDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setHeirPeople(req.getHeirPeople());
        data.setLeaveReason(req.getLeaveReason());
        data.setRemark(req.getRemark());
        archiveAO.editLeaveArchive(data);

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632812Req.class);
        ObjValidater.validateReq(req);
    }
}
