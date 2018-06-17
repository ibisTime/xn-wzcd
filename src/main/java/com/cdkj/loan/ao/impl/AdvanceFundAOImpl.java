package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.req.XN632171Req;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.dto.req.XN632173Req;
import com.cdkj.loan.dto.req.XN632175Req;
import com.cdkj.loan.dto.req.XN632177Req;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EAdvanceType;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EIsAdvanceFund;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:37:45 
 * @history:
 */
@Service
public class AdvanceFundAOImpl implements IAdvanceFundAO {

    @Autowired
    private IAdvanceFundBO advanceFundBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    public void confirmAdvanceFund(XN632170Req req) {

        // 补充设置申请时间

        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setIsAdvanceFund(req.getIsAdvanceFund());
        String preNodeCode = data.getCurNodeCode();
        data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
            .getNextNode());
        EAdvanceFundNode currentNode = EAdvanceFundNode.getMap().get(
            data.getCurNodeCode());
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }

        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), currentNode.getCode(), currentNode.getValue(),
            req.getOperator());

        advanceFundBO.refreshConfirmAdvanceFund(data);

    }

    @Override
    public int editAdvanceFund(AdvanceFund data) {
        if (!advanceFundBO.isAdvanceFundExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return advanceFundBO.refreshAdvanceFund(data);
    }

    @Override
    public int dropAdvanceFund(String code) {
        if (!advanceFundBO.isAdvanceFundExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return advanceFundBO.removeAdvanceFund(code);
    }

    @Override
    public Paginable<AdvanceFund> queryAdvanceFundPage(int start, int limit,
            AdvanceFund condition) {
        return advanceFundBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<AdvanceFund> queryAdvanceFundList(AdvanceFund condition) {
        return advanceFundBO.queryAdvanceFundList(condition);
    }

    @Override
    public AdvanceFund getAdvanceFund(String code) {
        return advanceFundBO.getAdvanceFund(code);
    }

    @Override
    public void areaAudit(XN632171Req req) {

        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        String preNodeCode = data.getCurNodeCode();

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
        } else if (EApproveResult.NOT_PASS.getCode().equals(
            req.getApproveResult())) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EAdvanceFundNode currentNode = EAdvanceFundNode.getMap().get(
            data.getCurNodeCode());
        EBizLogType refType = null;
        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), currentNode.getCode(), req.getApproveNote(),
            req.getOperator());

        advanceFundBO.refreshAreaAudit(data);

    }

    @Override
    public void provinceAudit(XN632172Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        String preNodeCode = data.getCurNodeCode();

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {

            if (EIsAdvanceFund.NO.getCode().equals(data.getIsAdvanceFund())) {
                // 不垫资 结束垫资流程 进入银行放款流程
                BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                    .getBudgetCode());
                budgetOrder.setCurNodeCode(EBudgetOrderNode.BANK_LOAN_COMMIT
                    .getCode());
                sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                    EBizLogType.BUDGET_ORDER, budgetOrder.getCode(),
                    EBudgetOrderNode.BANK_LOAN_COMMIT.getCode(),
                    EBudgetOrderNode.BANK_LOAN_COMMIT.getValue(),
                    req.getOperator());

            } else if (EIsAdvanceFund.YES.getCode().equals(
                data.getIsAdvanceFund())) {
                // 垫资继续向下走流程
                data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preNodeCode).getNextNode());
            }

        } else if (EApproveResult.NOT_PASS.getCode().equals(
            req.getApproveResult())) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EAdvanceFundNode currentNode = EAdvanceFundNode.getMap().get(
            data.getCurNodeCode());
        EBizLogType refType = null;
        if ("1".equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_PARENT;
        } else if ("2".equals(data.getType())) {
            refType = EBizLogType.ADVANCE_FUND_BRANCH;
        }
        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), currentNode.getCode(), req.getApproveNote(),
            req.getOperator());

        advanceFundBO.refreshProvinceAudit(data);

    }

    @Override
    public void parentMakeBill(XN632173Req req) {
        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        String preNodeCode = data.getCurNodeCode();
        data.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
            .getNextNode());
        EAdvanceFundNode currentNode = EAdvanceFundNode.getMap().get(
            data.getCurNodeCode());
        EBizLogType refType = EBizLogType.ADVANCE_FUND_PARENT;
        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(), refType,
            data.getCode(), currentNode.getCode(), req.getMakeBillNote(),
            req.getOperator());

        advanceFundBO.parentMakeBill(data);
    }

    @Override
    public void confirmPayCarDealer(XN632175Req req) {

        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());

        data.setAdvanceFundAmount(req.getAdvanceFundAmount());
        data.setAdvanceFundDatetime(DateUtil.strToDate(
            req.getAdvanceFundDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setNote(req.getNote());
        data.setUpdater(req.getOperator());

        // 更改节点为银行放款流程第一步
        data.setCurNodeCode(EBudgetOrderNode.BANK_LOAN_COMMIT.getCode());

        sysBizLogBO.saveSYSBizLog(data.getBudgetCode(),
            EBizLogType.BUDGET_ORDER, data.getBudgetCode(),
            EBudgetOrderNode.BANK_LOAN_COMMIT.getCode(),
            EBudgetOrderNode.BANK_LOAN_COMMIT.getValue(), req.getOperator());

        advanceFundBO.confirmPayCarDealer(data);
    }

    @Override
    public void applyCancelAdvanceFund(XN632177Req req) {

        AdvanceFund data = advanceFundBO.getAdvanceFund(req.getCode());
        data.setCancelReason(req.getCancelReason());
        data.setUpdater(req.getOperator());

        if (EAdvanceType.PARENT_BIZ.getCode().equals(data.getType())) {
            if (EAdvanceFundNode.PARENT_CONFIRM.getCode().equals(
                data.getCurNodeCode())
                    || EAdvanceFundNode.PARENT_AREA.getCode().equals(
                        data.getCurNodeCode())
                    || EAdvanceFundNode.PARENT_PROVINCE.getCode().equals(
                        data.getCurNodeCode())) {
                data.setCurNodeCode(EAdvanceFundNode.PARENT_CONFIRM.getCode());
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不能申请撤销垫资操作，需财务审核");
            }

        } else if (EAdvanceType.BRANCH_BIZ.getCode().equals(data.getType())) {
            if (EAdvanceFundNode.BRANCH_CONFIRM.getCode().equals(
                data.getCurNodeCode())
                    || EAdvanceFundNode.BRANCH_AREA.getCode().equals(
                        data.getCurNodeCode())
                    || EAdvanceFundNode.BRANCH_PROVINCE.getCode().equals(
                        data.getCurNodeCode())) {
                data.setCurNodeCode(EAdvanceFundNode.BRANCH_CONFIRM.getCode());
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不能申请撤销垫资操作，需财务审核");
            }

        }
        advanceFundBO.applyCancelAdvanceFund(data);

    }
}
