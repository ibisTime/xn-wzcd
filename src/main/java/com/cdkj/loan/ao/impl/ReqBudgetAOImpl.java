package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632100Req;
import com.cdkj.loan.dto.req.XN632101Req;
import com.cdkj.loan.dto.req.XN632102Req;
import com.cdkj.loan.dto.req.XN632103Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.enums.EReqBudgetNode;
import com.cdkj.loan.enums.ESYSBizLogStatus;
import com.cdkj.loan.exception.BizException;

@Service
@Transactional
public class ReqBudgetAOImpl implements IReqBudgetAO {

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSRoleBO sysRoleBO;

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
            data.setCurNodeCode(
                nodeBO.getNode(EReqBudgetNode.APPLY.getCode()).getNextNode());
        }
        String code = reqBudgetBO.saveReqBudget(data);
        // 申请写入日志
        reqWriteLog(req, code);
        return code;
    }

    // 申请写入日志
    private int reqWriteLog(XN632100Req req, String code) {
        SYSBizLog data = new SYSBizLog();
        // 上级订单编号：他自己
        // TODO
        data.setParentOrder(code);
        data.setRefType("refType");
        data.setRefOrder("refOrder");
        data.setDealNote("dealNote");
        data.setOperator(req.getApplyUser());
        // 判断是否保存
        if (EButtonCode.SEND.getCode().equals(req.getButtonCode())) {
            data.setDealNode(EReqBudgetNode.APPLY.getCode());
        } else {
            data.setDealNode(EReqBudgetNode.STARTNODE.getCode());
        }
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        SYSUser user = sysUserBO.getUser(req.getApplyUser());
        String roleCode = user.getRoleCode();
        String level = sysRoleBO.getSYSRole(roleCode).getLevel();
        data.setOperateRole(level);
        data.setOperator(req.getApplyUser());

        data.setOperatorName(user.getLoginName());
        data.setOperatorMobile(user.getMobile());
        data.setStartDatetime(new Date());

        return sysBizLogBO.saveSYSBizLog(data);
    }

    // 收回预算款
    @Override
    public int collectionReqBudget(XN632103Req req) {
        ReqBudget data = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.ALREADY_CREDIT.getCode()
            .equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是已放款节点，不能操作");
        }
        data.setCollectionBank(req.getCollectionBank());
        data.setCollectionAmount(
            StringValidater.toLong(req.getCollectionAmount()));
        data.setCollectionDatetime(new Date());
        data.setCollectionRemark(req.getCollectionRemark());
        data.setCurNodeCode(nodeBO
            .getNode(EReqBudgetNode.ALREADY_CREDIT.getCode()).getNextNode());
        // 收回预算款写入日志
        collectionWriteLog(req);
        // 修改结束时间和花费时间
        updateDatetime(data);
        return reqBudgetBO.collectionReqBudget(data);
    }

    // TODO 收回预算款写入日志
    private void collectionWriteLog(XN632103Req req) {
        SYSBizLog data = new SYSBizLog();
        // TODO
        data.setParentOrder("parentOrder");
        data.setRefType("refType");
        data.setRefOrder("refOrder");
        data.setDealNode(EReqBudgetNode.COLLECTION.getCode());
        data.setDealNote(req.getCollectionRemark());
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        SYSUser user = sysUserBO.getUser(req.getOperator());
        String roleCode = user.getRoleCode();
        String level = sysRoleBO.getSYSRole(roleCode).getLevel();
        data.setOperateRole(level);
        data.setOperator(req.getOperator());
        data.setOperatorName(user.getLoginName());

        data.setOperatorMobile(user.getMobile());
        data.setStartDatetime(new Date());
        sysBizLogBO.saveSYSBizLog(data);
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

    // 财务经理审核
    @Override
    public int audit(XN632101Req req) {
        ReqBudget reqBudget = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.AUDIT.getCode()
            .equals(reqBudget.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是审核节点，不能操作");
        }

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 审核通过，改变节点
            reqBudget.setCurNodeCode(
                nodeBO.getNode(EReqBudgetNode.AUDIT.getCode()).getNextNode());
        } else {
            reqBudget.setCurNodeCode(
                nodeBO.getNode(EReqBudgetNode.AUDIT.getCode()).getBackNode());
        }
        // 审核写入日志
        auditWriteLog(req);
        // 修改结束时间和花费时间
        updateDatetime(reqBudget);
        return reqBudgetBO.refreshReqBudgetNode(reqBudget);
    }

    // TODO 审核写入日志
    private void auditWriteLog(XN632101Req req) {
        SYSBizLog data = new SYSBizLog();
        // TODO
        data.setParentOrder("parentOrder");
        data.setRefType("refType");
        data.setRefOrder("refOrder");
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            data.setDealNode(EReqBudgetNode.AUDIT.getCode());
        } else {
            data.setDealNode(EReqBudgetNode.REFILL.getCode());
        }
        data.setDealNote(req.getFinanceCheckNote());
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        SYSUser user = sysUserBO.getUser(req.getOperator());
        String roleCode = user.getRoleCode();
        String level = sysRoleBO.getSYSRole(roleCode).getLevel();
        data.setOperateRole(level);
        data.setOperator(req.getOperator());
        data.setOperatorName(user.getLoginName());

        data.setOperatorMobile(user.getMobile());
        data.setStartDatetime(new Date());
        sysBizLogBO.saveSYSBizLog(data);

    }

    // 确认放款
    @Override
    public int loan(XN632102Req req) {
        ReqBudget condition = reqBudgetBO.getReqBudget(req.getCode());
        if (!EReqBudgetNode.LOAN.getCode().equals(condition.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认放款节点，不能操作");
        }
        condition.setPayAmount(StringValidater.toLong(req.getPayAmount()));

        condition.setPayBank(req.getPayBank());
        condition.setPayAccount(req.getPayAccount());
        condition.setWaterBill(req.getWaterBill());
        condition.setPayRemark(req.getPayRemark());
        condition.setCurNodeCode(
            nodeBO.getNode(EReqBudgetNode.LOAN.getCode()).getNextNode());

        // 放款写入日志
        loanWriteLog(req);
        // 修改结束时间和花费时间
        updateDatetime(condition);
        return reqBudgetBO.loan(condition);
    }

    // TODO 放款写入日志
    private void loanWriteLog(XN632102Req req) {
        SYSBizLog data = new SYSBizLog();
        // TODO
        data.setParentOrder("parentOrder");
        data.setRefType("refType");
        data.setRefOrder("refOrder");
        data.setDealNode(EReqBudgetNode.LOAN.getCode());
        data.setDealNote(req.getPayRemark());
        data.setStatus(ESYSBizLogStatus.ALREADY_HANDLE.getCode());
        SYSUser user = sysUserBO.getUser(req.getOperator());
        String roleCode = user.getRoleCode();
        String level = sysRoleBO.getSYSRole(roleCode).getLevel();
        data.setOperateRole(level);
        data.setOperator(req.getOperator());
        data.setOperatorName(user.getLoginName());

        data.setOperatorMobile(user.getMobile());
        data.setStartDatetime(new Date());
        sysBizLogBO.saveSYSBizLog(data);
    }

    // 修改结束时间和花费时间
    private void updateDatetime(ReqBudget reqBudget) {
        SYSBizLog sysBizLog = new SYSBizLog();
        sysBizLog.setRefOrder(reqBudget.getCode());
        sysBizLog.setDealNode(reqBudget.getCurNodeCode());
        int id = (int) sysBizLogBO.getSYSBizLoglatest(sysBizLog);
        SYSBizLog bizLog = sysBizLogBO.getSYSBizLog(id);
        bizLog.setEndDatetime(new Date());
        sysBizLogBO.refreshSYSBizLog(bizLog);
    }
}
