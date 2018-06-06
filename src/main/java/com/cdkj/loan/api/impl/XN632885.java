package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.ao.ITransferPositionApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.TransferPositionApply;
import com.cdkj.loan.dto.req.XN632885Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查
 * @author: CYL 
 * @since: 2018年6月6日 下午1:24:58 
 * @history:
 */
public class XN632885 extends AProcessor {
    private ITransferPositionApplyAO transferPositionApplyAO = SpringContextHolder
        .getBean(ITransferPositionApplyAO.class);

    private XN632885Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        TransferPositionApply condition = new TransferPositionApply();
        condition.setArchieveCode(req.getArchieveCode());
        condition.setNewDepartment(req.getNewDepartment());
        condition.setStatus(req.getStatus());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return transferPositionApplyAO.queryTransferPositionApplyPage(start,
            limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632885Req.class);
        ObjValidater.validateReq(req);
    }

}
