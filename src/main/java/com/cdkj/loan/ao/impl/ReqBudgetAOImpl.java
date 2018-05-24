package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.dto.req.XN632100Req;
import com.cdkj.loan.dto.req.XN632101Req;
import com.cdkj.loan.dto.req.XN632102Req;
import com.cdkj.loan.dto.req.XN632103Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.enums.EReqBudgetNode;
import com.cdkj.loan.exception.BizException;

@Service
public class ReqBudgetAOImpl implements IReqBudgetAO {

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Autowired
    private INodeBO nodeBO;

    @Override
    public String addReqBudget(XN632100Req req) {
        ReqBudget data = new ReqBudget();
        data.setReceiptBank(req.getReceiptBank());
        data.setReceiptAccount(req.getReceiptAccount());
        data.setBudgetAmount(StringValidater.toLong(req.getBudgetAmount()));
        data.setUseDatetime(DateUtil.strToDate(req.getUseDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setBudgetAmount(StringValidater.toLong(req.getButtonCode()));
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setCurNodeCode(EReqBudgetNode.STARTNODE.getCode());
        if (EButtonCode.SEND.getCode().equals(req.getButtonCode())) {
            // 发送申请
            data.setCurNodeCode(nodeBO.getNode(EReqBudgetNode.APPLY.getCode())
                .getNextNode());
        }
        return reqBudgetBO.saveReqBudget(data);
    }

    @Override
    public int editReqBudget(XN632103Req req) {
        ReqBudget data = reqBudgetBO.getReqBudget(req.getCode());
        data.setCollectionBank(req.getCollectionBank());
        data.setCollectionAmount(StringValidater.toLong(req
            .getCollectionAmount()));
        data.setCollectionDatetime(new Date());
        data.setCollectionRemark(req.getCollectionRemark());
        data.setCurNodeCode(nodeBO.getNode(
            EReqBudgetNode.ALREADY_CREDIT.getCode()).getNextNode());
        return reqBudgetBO.refreshReqBudgetCollection(data);
    }

    @Override
    public int dropReqBudget(String code) {
        return reqBudgetBO.removeReqBudget(code);
    }

    @Override
    public Paginable<ReqBudget> queryReqBudgetPage(int start, int limit,
            ReqBudget condition) {
        return reqBudgetBO.getPaginable(start, limit, condition);
    }

    @Override
    public Paginable<ReqBudget> queryReqBudgetPageByRoleCode(int start,
            int limit, ReqBudget condition) {
        return reqBudgetBO.getPaginableByRoleCode(start, limit, condition);
    }

    @Override
    public List<ReqBudget> queryReqBudgetList(ReqBudget condition) {
        return reqBudgetBO.queryReqBudgetList(condition);
    }

    @Override
    public ReqBudget getReqBudget(String code) {
        return reqBudgetBO.getReqBudget(code);
    }

    @Override
    public int audit(XN632101Req req) {
        ReqBudget reqBudget = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.AUDIT.getCode().equals(reqBudget.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是审核节点，不能操作");
        }

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            reqBudget.setCurNodeCode(nodeBO.getNode(
                EReqBudgetNode.AUDIT.getCode()).getNextNode());
        } else {
            reqBudget.setCurNodeCode(nodeBO.getNode(
                EReqBudgetNode.AUDIT.getCode()).getBackNode());
        }

        return reqBudgetBO.refreshReqBudgetNode(reqBudget);
    }

    @Override
    public int credit(XN632102Req req) {
        ReqBudget condition = reqBudgetBO.getReqBudget(req.getCode());
        condition.setPayAmount(StringValidater.toLong(req.getPayAmount()));

        condition.setPayBank(req.getPayBank());
        condition.setPayAccount(req.getPayAccount());
        condition.setWaterBill(req.getWaterBill());
        condition.setPayRemark(req.getPayRemark());
        condition.setCurNodeCode(nodeBO.getNode(EReqBudgetNode.LOAN.getCode())
            .getNextNode());

        return reqBudgetBO.credit(condition);
    }
}
