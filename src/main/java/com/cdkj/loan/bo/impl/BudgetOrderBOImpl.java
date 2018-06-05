package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EIDKind;
import com.cdkj.loan.enums.ELoanRole;
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

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public String saveBudgetOrder(Credit credit) {
        List<CreditUser> creditUserList = credit.getCreditUserList();
        CreditUser applyCreditUser = null;
        CreditUser ghrCreditUser = null;
        CreditUser guaCreditUser = null;
        for (CreditUser creditUser : creditUserList) {
            if (applyCreditUser == null
                    && ELoanRole.APPLY_USER.getCode().equals(
                        creditUser.getLoanRole())) {
                applyCreditUser = creditUser;
            }
            if (ghrCreditUser == null
                    && ELoanRole.GHR.getCode().equals(creditUser.getLoanRole())) {
                ghrCreditUser = creditUser;
            }
            if (guaCreditUser == null
                    && ELoanRole.GUARANTOR.getCode().equals(
                        creditUser.getLoanRole())) {
                guaCreditUser = creditUser;
            }
        }

        String code = null;
        if (credit != null) {
            BudgetOrder data = new BudgetOrder();
            code = OrderNoGenerater.generate(EGeneratePrefix.BUDGETORDER
                .getCode());
            data.setCode(code);
            data.setCreditCode(credit.getCode());
            data.setBizType(credit.getBizType());
            data.setLoanAmount(credit.getLoanAmount());
            data.setApplyUserName(applyCreditUser.getUserName());
            data.setMobile(applyCreditUser.getMobile());
            data.setIdNo(applyCreditUser.getIdNo());
            data.setIdKind(EIDKind.IDCard.getCode());

            // 共还人=配偶
            if (ghrCreditUser != null) {
                data.setMateName(ghrCreditUser.getUserName());
                data.setMateMobile(ghrCreditUser.getMobile());
                data.setMateIdNo(ghrCreditUser.getIdNo());
            }

            if (guaCreditUser != null) {
                data.setApplyUserName(guaCreditUser.getUserName());
                data.setMobile(guaCreditUser.getMobile());
                data.setIdNo(guaCreditUser.getIdNo());
            }

            data.setApplyDatetime(new Date());
            data.setCompanyCode(credit.getCompanyCode());
            data.setSaleUserId(credit.getSaleUserId());
            data.setCurNodeCode(EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode());
            budgetOrderDAO.insert(data);
        }
        return code;
    }

    @Override
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
    public void refreshEntryFk(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterEntryFk(data);
        }
    }

    @Override
    public void refreshConfirmReceipt(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterConfirmReceipt(data);
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
    public void logicOrder(String code, String operator) {
        BudgetOrder budgetOrder = getBudgetOrder(code);
        // String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(budgetOrder
            .getCurNodeCode());
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());

        if (EBudgetOrderNode.DHAPPROVEDATA.getCode().equals(
            nodeFlow.getCurrentNode())) {
            if (StringUtils.isNotBlank(nodeFlow.getFileList())) {
                logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                    budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                    nodeFlow.getCurrentNode(), nodeFlow.getNextNode(),
                    nodeFlow.getFileList());
            } else {
                throw new BizException("xn0000", "当前节点材料清单不存在");
            }
        }
        budgetOrderDAO.updaterLogicNode(budgetOrder);
        // 日志记录
        // EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
        // budgetOrder.getCurNodeCode());
        // sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
        // EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
        // currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public Paginable<BudgetOrder> getPaginableByRoleCode(int start,
            int pageSize, BudgetOrder condition) {
        prepare(condition);
        long totalCount = budgetOrderDAO.selectTotalCountByRoleCode(condition);
        Paginable<BudgetOrder> page = new Page<BudgetOrder>(start, pageSize,
            totalCount);
        List<BudgetOrder> dataList = budgetOrderDAO
            .selectBudgetOrderByRoleCodeList(condition, page.getStart(),
                page.getPageSize());
        page.setList(dataList);
        return page;
    }
}
