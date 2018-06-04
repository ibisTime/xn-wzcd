package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632300ReqOverdue;
import com.cdkj.loan.enums.EOverdueMenuStatus;
import com.cdkj.loan.enums.ERepayPlanStatus;

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
        for (XN632300ReqOverdue req : list) {
            // 数据组装好
            // 当条数据判断是否匹配，匹配条件：
            // 姓名、证件号、贷款银行、贷款金额、总期数、放款日期查询准入单
            BudgetOrder condition = new BudgetOrder();
            condition.setApplyUserName(req.getRealName());
            condition.setIdNo(req.getIdNo());
            String bankName = bankBO.getBank(loanBankCode).getBankName();
            condition.setLoanBank(loanBankCode);

            condition
                .setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
            condition.setLoanPeriod(req.getPeriods());
            condition.setBankFkDatetime(DateUtil.strToDate(req.getFkDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            List<BudgetOrder> budgetOrderList = budgetOrderBO
                .queryBudgetOrderList(condition);

            OverdueMenu overdueMenu = new OverdueMenu();
            // 判断是否有准入单，没有，状态设置为待处理，原因是信息不匹配,
            if (CollectionUtils.isEmpty(budgetOrderList)) {
                overdueMenu.setStatus(EOverdueMenuStatus.DCL.getCode());
            } else {
                // 有,状态设置为已处理,根据准入单查询还款业务表再查最新一条还款计划,设置还款计划状态为逾期名单
                BudgetOrder budgetOrder = budgetOrderList.get(0);
                RepayPlan repayPlan = new RepayPlan();
                repayPlan.setRepayBizCode(budgetOrder.getRepayBizCode());
                RepayPlan repayPlanLast = repayPlanBO
                    .getRepayPlanLast(repayPlan);
                repayPlanLast
                    .setStatus(ERepayPlanStatus.OVERDUE_TO_HANDLE.getCode());
                repayPlanBO.refreshRepayPlanStatus(repayPlanLast);

                overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
                overdueMenu.setBudgetOrderCode(budgetOrder.getCode());
                overdueMenu.setRepayBizCode(repayPlanLast.getRepayBizCode());
                overdueMenu.setRepayPlanCode(repayPlanLast.getCode());
            }
            // 最后逾期数据填充入库
            overdueMenu.setRealName(req.getRealName());
            overdueMenu.setIdNo(req.getIdNo());
            overdueMenu
                .setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
            overdueMenu.setFkDatetime(DateUtil.strToDate(req.getFkDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            overdueMenu.setPeriods(StringValidater.toInteger(req.getPeriods()));

            overdueMenu.setOverdueAmount(
                StringValidater.toLong(req.getOverdueAmount()));
            overdueMenu.setOverdueDatetime(DateUtil.strToDate(
                req.getOverdueDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
            overdueMenu
                .setRemainAmount(StringValidater.toLong(req.getRemainAmount()));
            overdueMenu.setLoanBankCode(loanBankCode);
            overdueMenu.setLoanBankName(bankName);
            overdueMenu.setImportDatetime(new Date());

            overdueMenuBO.saveOverdueMenu(overdueMenu);
        }
    }

    @Override
    public void handleOverdueMenu(String code, String budgetOrderCode) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(budgetOrderCode);

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(budgetOrder.getRepayBizCode());
        RepayPlan repayPlanLast = repayPlanBO.getRepayPlanLast(condition);
        repayPlanLast.setStatus(ERepayPlanStatus.OVERDUE_TO_HANDLE.getCode());
        repayPlanBO.refreshRepayPlanStatus(repayPlanLast);

        OverdueMenu overdueMenu = overdueMenuBO.getOverdueMenu(code);
        User user = userBO.getUser(repayPlanLast.getUserId());
        overdueMenu.setRealName(user.getRealName());
        overdueMenu.setIdNo(user.getIdNo());
        RepayBiz repayBiz = repayBizBO
            .getRepayBiz(repayPlanLast.getRepayBizCode());
        overdueMenu.setLoanAmount(repayBiz.getLoanAmount());
        overdueMenu.setFkDatetime(budgetOrder.getBankFkDatetime());
        overdueMenu.setPeriods(repayPlanLast.getPeriods());

        overdueMenu.setOverdueAmount(repayPlanLast.getOverdueAmount());
        overdueMenu.setOverdueDatetime(repayPlanLast.getRepayDatetime());
        overdueMenu.setRemainAmount(repayPlanLast.getOverdueAmount());
        overdueMenu.setLoanBankCode(repayBiz.getLoanBank());
        overdueMenu.setImportDatetime(new Date());

        overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
        overdueMenu.setBudgetOrderCode(budgetOrderCode);
        overdueMenu.setRepayBizCode(repayPlanLast.getRepayBizCode());
        overdueMenu.setRepayPlanCode(repayPlanLast.getCode());
        overdueMenuBO.saveOverdueMenu(overdueMenu);
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
        return overdueMenuBO.getOverdueMenu(code);
    }

}
