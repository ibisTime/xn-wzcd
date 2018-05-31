package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

@Component
public class BudgetOrderBOImpl extends PaginableBOImpl<BudgetOrder> implements
        IBudgetOrderBO {

    @Autowired
    private IBudgetOrderDAO budgetOrderDAO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    public String saveBudgetOrder(BudgetOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BUDGETORDER
                .getCode());
            data.setCode(code);
            budgetOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBudgetOrder(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrder data = new BudgetOrder();
            data.setCode(code);
            count = budgetOrderDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshBudgetOrder(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.update(data);
        }
    }

    @Override
    public void refreshriskApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterIskApprove(data);
        }
    }

    @Override
    public void refreshriskChargeApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterIskChargeApprove(data);
        }
    }

    @Override
    public void interview(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterInterview(data);
        }
    }

    @Override
    public void refreshbizChargeApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterBizChargeApprove(data);
        }
    }

    @Override
    public void advancefund(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterAdvancefund(data);
        }
    }

    @Override
    public void refreshGpsManagerApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterGpsManagerApprove(data);
        }
    }

    @Override
    public void installGps(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterInstallGps(data);
        }
    }

    @Override
    public void carSettle(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterCarSettle(data);
        }
    }

    @Override
    public void refreshCommitBank(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterCommitBank(data);
        }
    }

    @Override
    public void refreshConfirmLoan(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterConfirmLoan(data);
        }
    }

    @Override
    public void refreshEntryLoan(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterEntryLoan(data);
        }
    }

    @Override
    public void entryMortgage(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterEntryMortgage(data);
        }
    }

    @Override
    public void refreshMortgageCommitBank(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterMortgageCommitBank(data);
        }
    }

    @Override
    public void refreshMortgageFinish(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterMortgageFinish(data);
        }
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition) {
        return budgetOrderDAO.selectList(condition);
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        BudgetOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrder condition = new BudgetOrder();
            condition.setCode(code);
            data = budgetOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "预算单不存在！！");
            }
        }
        return data;
    }

    @Override
    public int archiveSuccess(BudgetOrder budgetOrder, String repayBizCode,
            String userId) {

        int count = 0;

        if (budgetOrder != null) {
            budgetOrder.setRepayBizCode(repayBizCode);
            budgetOrder.setApplyUserId(userId);
            count = budgetOrderDAO.updateArchiveSuccess(budgetOrder);
        }

        return count;
    }

    /** 
     * @see com.cdkj.loan.bo.IBudgetOrderBO#logicOrder(com.cdkj.loan.domain.BudgetOrder)
     */
    @Override
    public void logicOrder(String code) {
        BudgetOrder budgetOrder = getBudgetOrder(code);
        NodeFlow currentNodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
        budgetOrder.setCurNodeCode(currentNodeFlow.getNextNode());
        if (EBudgetOrderNode.DHAPPROVEDATA.getCode().equals(
            currentNodeFlow.getNextNode())) {
            if (StringUtils.isNotBlank(currentNodeFlow.getFileList())) {
                logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                    budgetOrder.getCode(), null,
                    currentNodeFlow.getCurrentNode(),
                    currentNodeFlow.getNextNode(),
                    currentNodeFlow.getFileList());
            } else {
                throw new BizException("xn0000", "当前节点材料清单不存在");
            }
        }
        budgetOrderDAO.updaterLogicNode(budgetOrder);
    }
}
