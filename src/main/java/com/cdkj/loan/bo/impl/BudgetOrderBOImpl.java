package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BudgetOrderBOImpl extends PaginableBOImpl<BudgetOrder>
        implements IBudgetOrderBO {

    @Autowired
    private IBudgetOrderDAO budgetOrderDAO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public String saveBudgetOrder(BudgetOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BUDGET.getCode());
            data.setCode(code);
            budgetOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshAreaManagerApprove(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateAreaManagerApprove(data);
        }
    }

    @Override
    public void refreshBranchCompanyApprove(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateBranchCompanyApprove(data);
        }
    }

    @Override
    public void refreshGlobalManagerApprove(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateGlobalManagerApprove(data);
        }
    }

    @Override
    public void refreshCanceOrder(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateCancelOrder(data);
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
                    "预订单编号不存在");
            }
        }
        return data;
    }

    @Override
    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode) {
        BudgetOrder data = null;
        if (StringUtils.isNotBlank(repayBizCode)) {
            BudgetOrder condition = new BudgetOrder();
            condition.setRepayBizCode(repayBizCode);
            data = budgetOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "预算单不存在！！");
            }
        }
        return data;
    }

    @Override
    public void refreshBankLoanCommit(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateBankLoanCommit(data);
        }
    }

    @Override
    public void refreshBankLoanConfirm(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateBankLoanConfirm(data);
        }
    }

    @Override
    public void refreshCarPledgeCommit(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateCarPledgeCommit(data);
        }
    }

    @Override
    public void refreshCarPledgeConfirm(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateCarPledgeConfirm(data);
        }
    }

    @Override
    public void refreshCarLoanArchive(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.updateCarLoanArchive(data);
        }
    }

    /** 
     * @see com.cdkj.loan.bo.IBudgetOrderBO#logicOrder(com.cdkj.loan.domain.BudgetOrder)
     */
    @Override
    public void logicOrder(String code, String operator) {
        BudgetOrder budgetOrder = getBudgetOrder(code);
        // String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        budgetOrder.setOperator(operator);
        budgetOrder.setOperateDatetime(new Date());
        // if (EBudgetOrderNode.DHAPPROVEDATA.getCode().equals(
        // nodeFlow.getCurrentNode())) {
        // if (StringUtils.isNotBlank(nodeFlow.getFileList())) {
        // logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
        // budgetOrder.getCode(), budgetOrder.getSaleUserId(),
        // nodeFlow.getCurrentNode(), nodeFlow.getNextNode(),
        // nodeFlow.getFileList());
        // } else {
        // throw new BizException("xn0000", "当前节点材料清单不存在");
        // }
        // }
        budgetOrderDAO.updaterLogicNode(budgetOrder);
        // 日志记录
        // EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
        // budgetOrder.getCurNodeCode());
        // sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
        // EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
        // currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void updateCurNodeCode(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateCurNodeCode(budgetOrder);
    }

    @Override
    public Object getPaginableByRoleCode(int start, int limit,
            BudgetOrder condition) {
        prepare(condition);

        long totalCount = budgetOrderDAO.selectTotalCountByRoleCode(condition);

        Paginable<BudgetOrder> page = new Page<BudgetOrder>(start, limit,
            totalCount);

        List<BudgetOrder> dataList = budgetOrderDAO
            .selectBudgetOrderByRoleCodeList(condition, page.getStart(),
                page.getPageSize());

        page.setList(dataList);
        return page;
    }

}
