package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Withdraw;
import com.cdkj.loan.dto.req.XN802757Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 取现列表查询
 * @author: xieyj 
 * @since: 2017年5月18日 下午4:26:11 
 * @history:
 */
public class XN802757 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802757Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Withdraw condition = new Withdraw();

        condition.setAccountNumber(req.getAccountNumber());
        condition.setAccountName(req.getAccountName());
        condition.setType(req.getType());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());

        condition.setApplyUser(req.getApplyUser());
        condition.setApproveUser(req.getApproveUser());
        condition.setPayUser(req.getPayUser());
        condition.setPayGroup(req.getPayGroup());
        condition.setChannelOrder(req.getChannelOrder());

        condition.setApplyDatetimeStart(
            DateUtil.getFrontDate(req.getApplyDateStart(), false));
        condition.setApplyDatetimeEnd(
            DateUtil.getFrontDate(req.getApplyDateEnd(), true));
        condition.setApproveDatetimeStart(
            DateUtil.getFrontDate(req.getApproveDateStart(), false));
        condition.setApproveDatetimeEnd(
            DateUtil.getFrontDate(req.getApproveDateEnd(), true));
        condition.setPayDatetimeStart(
            DateUtil.getFrontDate(req.getPayDateStart(), false));
        condition.setPayDatetimeEnd(
            DateUtil.getFrontDate(req.getPayDateEnd(), true));
        return withdrawAO.queryWithdrawList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802757Req.class);
        ObjValidater.validateReq(req);
    }
}
