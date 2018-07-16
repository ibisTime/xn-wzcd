package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IProvinceBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.Province;
import com.cdkj.loan.enums.EBankType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EBudgetOrderShopWay;
import com.cdkj.loan.enums.EEnterFileStatus;
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
    private IDepartmentBO departmentBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private IProvinceBO provinceBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    public String saveBudgetOrder(BudgetOrder data) {
        String code = null;
        if (data != null) {
            Bank bank = bankBO.getBankBySubbranch(data.getLoanBankCode());
            // 业务归属公司
            String bizCompany = "H";
            if (EBankType.ZH.getCode().equals(bank.getBankCode())) {
                bizCompany = "B";
            }
            // 新车二手车
            String shopWay = "X";
            if (EBudgetOrderShopWay.OLD.getCode().equals(data.getShopWay())) {
                shopWay = "R";
            }
            Department company = departmentBO.getDepartment(data
                .getCompanyCode());
            Province provinceCondition = new Province();
            provinceCondition.setName(company.getProvinceNo());
            Province province = provinceBO.getProvince(provinceCondition);
            // 省份编号
            String provinceNo = "33";
            if (null != province) {
                provinceNo = province.getProvinceNo();
            }

            String today = DateUtil.getToday(DateUtil.DB_DATE_FORMAT_STRING);// yyyyMMdd
            String year = today.substring(2, 4);
            String month = today.substring(4, 6);
            String day = today.substring(6);

            Archive condition = new Archive();
            condition.setUserId(data.getSaleUserId());
            List<Archive> archiveList = archiveBO.queryArchiveList(condition);
            String jobNo = "000";
            if (!archiveList.isEmpty()) {
                jobNo = archiveList.get(0).getJobNo();// TODO
            }

            BudgetOrder budgetOrderCondition = new BudgetOrder();
            budgetOrderCondition.setCreateDatetimeStart(DateUtil
                .getTodayStart());
            budgetOrderCondition.setCreateDatetimeEnd(DateUtil.getTodayEnd());
            long count = budgetOrderDAO.selectTotalCount(budgetOrderCondition) + 1;
            String bizNO = String.valueOf(count);
            if (bizNO.length() == 1) {
                bizNO = "00" + bizNO;
            } else if (bizNO.length() == 2) {
                bizNO = "0" + bizNO;
            }
            code = bizCompany + shopWay + provinceNo + year + month + day
                    + jobNo + bizNO;
            data.setCode(code);
            budgetOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refresh(BudgetOrder data) {
        if (data != null) {
            budgetOrderDAO.update(data);
        }

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
        String preCurrentNode = budgetOrder.getCurNodeCode();// 主流程当前节点
        if (StringUtils.isNotBlank(budgetOrder.getPledgeCurNodeCode())) {
            String pledgeCurNodeCode = budgetOrder.getPledgeCurNodeCode();// 抵押流程当前节点
            if (EBudgetOrderNode.OUT_BRANCH_SEND_PARENT.getCode().equals(
                pledgeCurNodeCode)) {
                // 当前抵押流程节点如果是车辆抵押流程 外地 009_05分公司寄送抵押材料给总公司
                // 收件并审核通过后 改预算单入档状态为待入档
                budgetOrder.setEnterFileStatus(EEnterFileStatus.TODO.getCode());
                budgetOrderBO.updateEnterFileStatus(budgetOrder);
            }
            if (EBudgetOrderNode.LOCAL_SENDPOST_SEND_BANK.getCode().equals(
                pledgeCurNodeCode)) {
                // 抵押流程本地 寄件岗寄送银行 收件并审核通过 更新抵押流程节点 到下一个 提交银行
                budgetOrder.setPledgeCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(pledgeCurNodeCode).getNextNode());
            }
        }
        if (EBudgetOrderNode.HEADQUARTERS_SEND_PRINT.getCode().equals(
            preCurrentNode)) {
            // 当前主流程节点如果是银行放款流程 007_02 总公司寄送银行材料给打印岗
            // 收件审核并通过后 抵押流程本地开始（主流程外的）
            // 设置抵押流程节点为车辆抵押本地第一步008_01打印岗打印
            budgetOrder
                .setPledgeCurNodeCode(EBudgetOrderNode.LOCAL_PRINTPOST_PRINT
                    .getCode());
        }
        if (EBudgetOrderNode.SEND_BANK_MATERIALS.getCode().equals(
            preCurrentNode)) {
            // 当前主流程节点是银行放款流程 007_05 总公司寄送银行材料给银行驻点
            // 收件并审核通过后 抵押流程外地开始（主流程外的）
            // 设置抵押流程节点为车辆抵押外地第一步009_01银行驻点发送抵押合同给总公司
            budgetOrder
                .setPledgeCurNodeCode(EBudgetOrderNode.OUT_BANKPOINT_SEND_PARENT
                    .getCode());
            // 获取当前抵押流程节点
            NodeFlow pledgeNodeFlow = nodeFlowBO
                .getNodeFlowByCurrentNode(budgetOrder.getPledgeCurNodeCode());
            // 生成资料传递
            logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                pledgeNodeFlow.getCurrentNode(), pledgeNodeFlow.getNextNode());
        }
        // 获取当前主流程节点
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        budgetOrder.setOperator(operator);
        budgetOrder.setOperateDatetime(new Date());
        if (EBudgetOrderNode.HEADQUARTERS_SEND_PRINT.getCode().equals(
            budgetOrder.getCurNodeCode())
                || EBudgetOrderNode.OUT_PARENT_SEND_BRANCH.getCode().equals(
                    budgetOrder.getPledgeCurNodeCode())) {// 连续发件情况 再生成一条资料传递
            NodeFlow nodeFlowNext = nodeFlowBO
                .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());// 获取当前节点的下一个节点
            // 生成资料传递
            logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                nodeFlowNext.getCurrentNode(), nodeFlowNext.getNextNode());
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点材料清单不存在");
        }
        budgetOrderDAO.updaterLogicNode(budgetOrder);

        // 日志记录 主流程
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);

        // 日志记录 抵押流程 TODO
        /*
         * EBudgetOrderNode pledgeCurrentCurNode = EBudgetOrderNode.getMap()
         * .get(budgetOrder.getPledgeCurNodeCode());
         * sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
         * EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), pledgeCurNodeCode,
         * pledgeCurrentCurNode.getCode(), pledgeCurrentCurNode.getValue(),
         * operator);
         */

    }

    @Override
    public void updateCurNodeCode(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateCurNodeCode(budgetOrder);
    }

    @Override
    public Paginable<BudgetOrder> getPaginableByRoleCode(int start, int limit,
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

    @Override
    public void refreshCardMaking(BudgetOrder condition) {
        budgetOrderDAO.refreshCardMaking(condition);
    }

    @Override
    public void entryPreservation(BudgetOrder budgetOrder) {
        budgetOrderDAO.entryPreservation(budgetOrder);
    }

    @Override
    public void invoiceMismatchApply(BudgetOrder budgetOrder) {
        budgetOrderDAO.invoiceMismatchApply(budgetOrder);
    }

    @Override
    public void invoiceMismatchApprove(BudgetOrder budgetOrder) {
        budgetOrderDAO.invoiceMismatchApprove(budgetOrder);
    }

    @Override
    public void twoApproveYes(BudgetOrder budgetOrder) {
        budgetOrderDAO.twoApproveYes(budgetOrder);
    }

    @Override
    public void twoApproveNo(BudgetOrder budgetOrder) {
        budgetOrderDAO.twoApproveNo(budgetOrder);
    }

    @Override
    public void mortgageRefund(BudgetOrder budgetOrder) {
        budgetOrderDAO.mortgageRefund(budgetOrder);
    }

    @Override
    public void applyCancel(BudgetOrder budgetOrder) {
        budgetOrderDAO.applyCancel(budgetOrder);
    }

    @Override
    public void cancelBizAudit(BudgetOrder budgetOrder) {
        budgetOrderDAO.cancelBizAudit(budgetOrder);
    }

    @Override
    public void financeConfirm(BudgetOrder budgetOrder) {
        budgetOrderDAO.financeConfirm(budgetOrder);
    }

    @Override
    public void approveMakeCard(BudgetOrder budgetOrder) {
        budgetOrderDAO.approveMakeCard(budgetOrder);
    }

    @Override
    public void receiptAndReturn(BudgetOrder budgetOrder) {
        budgetOrderDAO.receiptAndReturn(budgetOrder);
    }

    @Override
    public void remindingProcess(BudgetOrder budgetOrder) {
        budgetOrderDAO.remindingProcess(budgetOrder);
    }

    @Override
    public void canceOrder(BudgetOrder budgetOrder) {
        budgetOrderDAO.canceOrder(budgetOrder);
    }

    @Override
    public void renewInsuranceRemind(String code, int insuranceRemindCount) {
        BudgetOrder budgetOrder = new BudgetOrder();
        budgetOrder.setCode(code);
        budgetOrder.setInsuranceRemindCount(insuranceRemindCount);
        budgetOrderDAO.updateRenewInsuranceRemind(budgetOrder);
    }

    @Override
    public void renewInsurance(BudgetOrder data) {
        budgetOrderDAO.updateRenewInsurance(data);
    }

    @Override
    public void bankLoanConfirmSubmitBank(BudgetOrder budgetOrder) {
        budgetOrderDAO.bankLoanConfirmSubmitBank(budgetOrder);
    }

    @Override
    public void refreshCurNodeCode(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateCurNodeCode(budgetOrder);

    }

    @Override
    public void updateRepayBizCode(String code, String repayBizCode,
            String userId) {
        BudgetOrder budgetOrder = getBudgetOrder(code);
        budgetOrder.setRepayBizCode(repayBizCode);
        budgetOrder.setApplyUserId(userId);
        budgetOrderDAO.updateRepayBizCode(budgetOrder);
    }

    @Override
    public void applyInvoiceMismatch(BudgetOrder budgetOrder) {
        budgetOrderDAO.applyInvoiceMismatch(budgetOrder);
    }

    public void loanContractPrint(BudgetOrder budgetOrder) {
        budgetOrderDAO.loanContractPrint(budgetOrder);

    }

    @Override
    public void pledgeContractPrint(BudgetOrder budgetOrder) {
        budgetOrderDAO.pledgeContractPrint(budgetOrder);

    }

    @Override
    public void collateAchieve(BudgetOrder budgetOrder) {
        budgetOrderDAO.collateAchieve(budgetOrder);
    }

    @Override
    public void updateEnterFileStatus(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateEnterFileStatus(budgetOrder);
    }

    @Override
    public void loanBankCollateAchieve(BudgetOrder budgetOrder) {
        budgetOrderDAO.loanBankCollateAchieve(budgetOrder);
    }

}
