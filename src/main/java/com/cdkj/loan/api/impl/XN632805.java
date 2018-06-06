package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.dto.req.XN632805Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:19:10 
 * @history:
 */
public class XN632805 extends AProcessor {

    private IArchiveAO archiveAO = SpringContextHolder
        .getBean(IArchiveAO.class);

    private XN632805Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Archive condition = new Archive();
        condition.setRealName(req.getRealName());
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setPostCode(req.getPostCode());
        condition.setEntryDatetimeStart(req.getEntryDatetimeStart());
        condition.setEntryDatetimeEnd(req.getEntryDatetimeEnd());
        condition.setWorkStatus(req.getWorkStatus());
        condition.setIsDelete("1");
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IArchiveAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return archiveAO.queryArchivePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632805Req.class);
        ObjValidater.validateReq(req);
    }
}
