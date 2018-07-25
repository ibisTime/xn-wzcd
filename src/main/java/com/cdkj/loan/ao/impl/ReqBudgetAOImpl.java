package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632100Req;
import com.cdkj.loan.dto.req.XN632101Req;
import com.cdkj.loan.dto.req.XN632102Req;
import com.cdkj.loan.dto.req.XN632103Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EReqBudgetNode;
import com.cdkj.loan.exception.BizException;

@Service
@Transactional
public class ReqBudgetAOImpl implements IReqBudgetAO {

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Override
    @Transactional
    public String addReqBudget(XN632100Req req) {

        SYSUser user = sysUserBO.getUser(req.getApplyUser());
        ReqBudget todayReqBudget = reqBudgetBO.getTodayReqBudget(user
            .getCompanyCode());
        if (null != todayReqBudget) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您今日已提交过申请！");
        }
        ReqBudget data = new ReqBudget();
        data.setCompanyCode(user.getCompanyCode());
        data.setReceiptBank(req.getReceiptBank());
        data.setReceiptAccount(req.getReceiptAccount());
        data.setBudgetAmount(StringValidater.toLong(req.getBudgetAmount()));
        data.setUseDatetime(DateUtil.strToDate(req.getUseDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setApplyUser(user.getUserId());
        data.setApplyDatetime(new Date());
        data.setCurNodeCode(EReqBudgetNode.AUDIT.getCode());
        String code = reqBudgetBO.saveReqBudget(data);
        // 日志记录
        sysBizLogBO.recordCurrentSYSBizLog(code, EBizLogType.REQ_BUDGET, code,
            EReqBudgetNode.APPLY.getCode(), null, req.getApplyUser());
        sysBizLogBO.saveSYSBizLog(code, EBizLogType.REQ_BUDGET, code,
            data.getCurNodeCode());
        return code;
    }

    // 收回预算款
    @Override
    public void collectionReqBudget(XN632103Req req) {
        ReqBudget reqBudget = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.COLLECTION.getCode().equals(
            reqBudget.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前不是财务确认收回预算款节点，不能操作");
        }
        reqBudget.setCollectionBank(req.getCollectionBank());
        reqBudget.setCollectionAmount(StringValidater.toLong(req
            .getCollectionAmount()));
        reqBudget.setCollectionDatetime(new Date());
        reqBudget.setCollectionRemark(req.getCollectionRemark());

        // 之前节点
        String preCurrentNode = reqBudget.getCurNodeCode();
        reqBudget.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            preCurrentNode).getNextNode());
        reqBudgetBO.collectionReqBudget(reqBudget);

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REQ_BUDGET,
            reqBudget.getCode(), preCurrentNode, req.getCollectionRemark(),
            req.getOperator());
    }

    // 财务经理审核
    @Override
    public void audit(XN632101Req req) {
        ReqBudget reqBudget = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.AUDIT.getCode().equals(reqBudget.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = reqBudget.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            reqBudget.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EReqBudgetNode.AUDIT.getCode()).getNextNode());
        } else {
            reqBudget.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EReqBudgetNode.AUDIT.getCode()).getBackNode());
        }
        reqBudgetBO.refreshReqBudgetNode(reqBudget);

        // 日志记录
        EReqBudgetNode currentNode = EReqBudgetNode.getMap().get(
            reqBudget.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(reqBudget.getCode(),
            EBizLogType.REQ_BUDGET, reqBudget.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    // 确认放款
    @Override
    public void loan(XN632102Req req) {
        ReqBudget reqBudget = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.LOAN.getCode().equals(reqBudget.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认放款节点，不能操作");
        }
        reqBudget.setPayAmount(StringValidater.toLong(req.getPayAmount()));

        reqBudget.setPayBank(req.getPayBank());
        reqBudget.setPayAccount(req.getPayAccount());
        reqBudget.setWaterBill(req.getWaterBill());
        reqBudget.setPayDatetime(new Date());
        reqBudget.setPayRemark(req.getPayRemark());

        String preNodeCode = reqBudget.getCurNodeCode();
        reqBudget.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EReqBudgetNode.LOAN.getCode()).getNextNode());
        reqBudgetBO.loan(reqBudget);

        // 日志记录
        EReqBudgetNode currentNode = EReqBudgetNode.getMap().get(
            reqBudget.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(reqBudget.getCode(),
            EBizLogType.REQ_BUDGET, reqBudget.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public Paginable<ReqBudget> queryReqBudgetPage(int start, int limit,
            ReqBudget condition) {
        Paginable<ReqBudget> paginable = reqBudgetBO.getPaginable(start, limit,
            condition);
        List<ReqBudget> list = paginable.getList();
        for (ReqBudget reqBudget : list) {
            init(reqBudget);
        }
        return paginable;
    }

    @Override
    public Paginable<ReqBudget> queryReqBudgetPageByRoleCode(int start,
            int limit, ReqBudget condition) {
        Paginable<ReqBudget> paginable = reqBudgetBO.getPaginableByRoleCode(
            start, limit, condition);
        List<ReqBudget> list = paginable.getList();
        for (ReqBudget reqBudget : list) {
            init(reqBudget);
        }
        return paginable;
    }

    @Override
    public List<ReqBudget> queryReqBudgetList(ReqBudget condition) {
        List<ReqBudget> list = reqBudgetBO.queryReqBudgetList(condition);
        for (ReqBudget reqBudget : list) {
            init(reqBudget);
        }
        return list;
    }

    @Override
    public ReqBudget getReqBudget(String code) {
        ReqBudget budget = reqBudgetBO.getReqBudget(code);
        init(budget);
        return budget;
    }

    private void init(ReqBudget data) {

        if (StringUtils.isNotBlank(data.getCompanyCode())) {
            Department department = departmentBO.getDepartment(data
                .getCompanyCode());
            if (null != department) {
                data.setCompanyName(department.getName());
            }
        }

        if (StringUtils.isNotBlank(data.getApplyUser())) {
            SYSUser user = sysUserBO.getUser(data.getApplyUser());
            if (null != user) {
                data.setApplyUserName(user.getRealName());
            }
        }
    }
}
