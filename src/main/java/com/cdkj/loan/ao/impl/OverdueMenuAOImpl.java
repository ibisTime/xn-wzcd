package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IOverdueMenuBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN632300ReqOverdue;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EOverdueMenuStatus;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;

@Service
public class OverdueMenuAOImpl implements IOverdueMenuAO {

    @Autowired
    private IOverdueMenuBO overdueMenuBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Override
    @Transactional
    public void importOverdueMenu(String loanBankCode,
            List<XN632300ReqOverdue> list) {
        // 遍历循环导入
        for (XN632300ReqOverdue overdue : list) {
            // 当条数据判断是否匹配，匹配条件：姓名、证件号、贷款银行、贷款金额、总期数、放款日期查询准入单
            RepayBiz condition = new RepayBiz();
            condition.setRealName(overdue.getRealName());
            condition.setIdNo(overdue.getIdNo());
            String bankName = bankBO.getBankBySubbranch(loanBankCode)
                .getBankName();
            condition.setLoanBank(loanBankCode);
            condition.setLoanAmount(StringValidater.toLong(overdue
                .getLoanAmount()));
            condition
                .setPeriods(StringValidater.toInteger(overdue.getPeriods()));
            condition.setBankFkDatetimeStart(DateUtil.getFrontDate(
                overdue.getFkDatetime(), false));
            condition.setBankFkDatetimeEnd(DateUtil.getFrontDate(
                overdue.getFkDatetime(), true));
            condition.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());
            List<RepayBiz> repayBizList = repayBizBO
                .queryRepayBizList(condition);
            OverdueMenu overdueMenu = new OverdueMenu();
            overdueMenu.setStatus(EOverdueMenuStatus.DCL.getCode());
            overdueMenu.setOverdueAmount(StringValidater.toLong(overdue
                .getOverdueAmount()));
            // 判断是否有准入单，没有，状态设置为待处理，原因是信息不匹配,
            if (CollectionUtils.isNotEmpty(repayBizList)) {
                // 有,状态设置为已处理,根据准入单查询还款业务表再查最新一条还款计划,设置还款计划状态为逾期名单
                RepayBiz repayBiz = repayBizList.get(0);
                RepayPlan overDueRepayPlan = repayPlanBO
                    .getRepayPlanCurMonth(repayBiz.getCode());
                if (!ERepayPlanNode.OVERDUE.getCode().equals(
                    overDueRepayPlan.getCurNodeCode())) {
                    repayBiz.setRestPeriods(repayBiz.getRestPeriods() - 1);
                    repayBizBO.refreshRestPeriods(repayBiz);
                }
                if (overDueRepayPlan != null
                        && overDueRepayPlan.getPeriods() == StringValidater
                            .toInteger(overdue.getPeriods())) {
                    overDueRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE
                        .getCode());

                    // 更新逾期还款信息
                    refreshRepayInfo(overdueMenu, repayBiz, overDueRepayPlan);

                    overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
                    overdueMenu.setBudgetOrderCode(repayBiz.getRefCode());
                    overdueMenu.setRepayBizCode(overDueRepayPlan
                        .getRepayBizCode());

                    overdueMenu.setRepayPlanCode(overDueRepayPlan.getCode());
                    overdueMenu.setOverdueDatetime(overDueRepayPlan
                        .getRepayDatetime());
                }
            }

            // 最后逾期数据填充入库
            overdueMenu.setBatchDatetime(DateUtil.strToDate(
                overdue.getBatchDatetime(), DateUtil.DB_DATE_FORMAT_STRING));
            overdueMenu.setRealName(overdue.getRealName());
            overdueMenu.setIdNo(overdue.getIdNo());
            overdueMenu.setLoanAmount(StringValidater.toLong(overdue
                .getLoanAmount()));
            overdueMenu.setFkDatetime(DateUtil.strToDate(
                overdue.getFkDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
            overdueMenu.setPeriods(StringValidater.toInteger(overdue
                .getPeriods()));

            overdueMenu.setRemainAmount(StringValidater.toLong(overdue
                .getRemainAmount()));
            overdueMenu.setLoanBankCode(loanBankCode);
            overdueMenu.setLoanBankName(bankName);

            overdueMenu.setImportDatetime(new Date());
            overdueMenuBO.saveOverdueMenu(overdueMenu);
        }
    }

    /** 
     * @param overdueMenu
     * @param repayBiz
     * @param overDueRepayPlan 
     * @create: 2018年6月12日 上午6:17:54 xieyj
     * @history: 
     */
    private void refreshRepayInfo(OverdueMenu overdueMenu, RepayBiz repayBiz,
            RepayPlan overDueRepayPlan) {
        overDueRepayPlan.setOverdueAmount(overdueMenu.getOverdueAmount());
        repayPlanBO.refreshRepayPlanOverdue(overDueRepayPlan);// 更新还款计划逾期金额

        // 更新还款业务逾期金额
        repayBiz.setRestOverdueAmount(repayBiz.getRestOverdueAmount()
                + overDueRepayPlan.getOverdueAmount());
        repayBiz.setTotalOverdueCount(repayBiz.getTotalOverdueCount() + 1);
        repayBiz.setCurOverdueCount(repayBiz.getCurOverdueCount() + 1);
        repayBizBO.repayOverdue(repayBiz);
    }

    // 处理逻辑
    // 1、前提条件判断
    // 2、逾期名单状态更改为已处理
    // 3、还款计划更改为已逾期
    @Override
    @Transactional
    public void handleOverdueMenu(String code, String repayBizCode,
            String operator) {
        OverdueMenu overdueMenu = overdueMenuBO.getOverdueMenu(code);
        if (EOverdueMenuStatus.YCL.getCode().equals(overdueMenu.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前逾期名单已处理");
        }

        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayBizCode);
        RepayPlan overDueRepayPlan = repayPlanBO.getRepayPlanCurMonth(repayBiz
            .getCode());
        // 还款计划状态是否更新
        overDueRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE.getCode());

        // 更新逾期还款信息
        refreshRepayInfo(overdueMenu, repayBiz, overDueRepayPlan);

        overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrderByRepayBizCode(repayBizCode);
        overdueMenu.setBudgetOrderCode(budgetOrder.getCode());
        overdueMenu.setRepayBizCode(overDueRepayPlan.getRepayBizCode());
        overdueMenu.setRepayPlanCode(overDueRepayPlan.getCode());

        overdueMenu.setHandleDatetime(new Date());
        overdueMenuBO.refreshOverdueMenu(overdueMenu);
    }

    @Override
    public Paginable<OverdueMenu> queryOverdueMenuPage(int start, int limit,
            OverdueMenu condition) {
        return overdueMenuBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<OverdueMenu> queryOverdueMenuList(OverdueMenu condition) {
        return overdueMenuBO.queryOverdueMenuList(condition);
    }

    @Override
    public OverdueMenu getOverdueMenu(String code) {
        OverdueMenu data = overdueMenuBO.getOverdueMenu(code);
        if (StringUtils.isNotBlank(data.getRepayBizCode())) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRepayBizCode());
            data.setRepayBiz(repayBiz);
        }
        return data;
    }

}
