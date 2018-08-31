package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.res.XN630172Res;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ELogisticsStatus;

@Service
public class SYSBizLogAOImpl implements ISYSBizLogAO {

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        ArrayList<SYSBizLog> returnList = new ArrayList<SYSBizLog>();
        // 征信和预算单日志（编号是同一个）
        List<SYSBizLog> bizLogList = sysBizLogBO.querySYSBizLogList(condition);
        for (SYSBizLog sysBizLog : bizLogList) {
            returnList.add(sysBizLog);
        }
        // 还款业务日志
        RepayBiz repayBiz = repayBizBO.getRepayBizByRefCode(condition
            .getRefOrder());
        if (null != repayBiz) {
            SYSBizLog queryCondition = new SYSBizLog();
            queryCondition.setRefOrder(repayBiz.getCode());
            List<SYSBizLog> repayLogList = sysBizLogBO
                .querySYSBizLogList(queryCondition);
            for (SYSBizLog sysBizLog : repayLogList) {
                returnList.add(sysBizLog);
            }
        }
        return returnList;
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
        return sysBizLogBO.getSYSBizLog(id);
    }

    @Override
    public Paginable<SYSBizLog> querySYSBizLogPage(int start, int limit,
            SYSBizLog condition) {
        return sysBizLogBO.getPaginable(start, limit, condition);
    }

    @Override
    public Object todoListAPP(SYSBizLog condition) {
        List<SYSBizLog> list = sysBizLogBO
            .querySYSBizLogListByRoleCode(condition);
        XN630172Res data = new XN630172Res(0, 0, 0, 0, 0, 0, 0);
        for (SYSBizLog sysBizLog : list) {
            if (EBizLogType.CREDIT.getCode().equals(sysBizLog.getRefType())) {
                data.setCreditTodo(data.getCreditTodo() + 1);
            }
            if (EBudgetOrderNode.START_NODE.getCode().equals(
                sysBizLog.getDealNode())
                    || EBudgetOrderNode.START_NODE.getCode().equals(
                        sysBizLog.getDealNode())
                    || EBudgetOrderNode.START_NODE.getCode().equals(
                        sysBizLog.getDealNode())) {
                data.setEntryMortgageTodo(data.getEntryMortgageTodo() + 1);
            }
            if (ELogisticsStatus.TO_SEND.getCode().equals(
                sysBizLog.getDealNode())
                    || ELogisticsStatus.TO_SEND.getCode().equals(
                        sysBizLog.getDealNode())
                    || ELogisticsStatus.TO_SEND.getCode().equals(
                        sysBizLog.getDealNode())) {
                data.setLogisticsTodo(data.getLogisticsTodo() + 1);
            }
        }
        return data;
    }

    @Override
    public Paginable<SYSBizLog> todoListOSS(int start, int limit,
            SYSBizLog condition) {
        Paginable<SYSBizLog> paginable = sysBizLogBO.getPaginableByRoleCode(
            start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        for (SYSBizLog sysBizLog : list) {
            todoThing(sysBizLog);
        }
        return paginable;
    }

    private SYSBizLog todoThing(SYSBizLog data) {
        String userName = "";
        String loanBank = "";
        String bizType = "";
        String departmentName = "";
        String bizOrderType = "";
        if ("C".equals(data.getRefOrder().substring(0, 1))) {
            Credit credit = creditBO.getCredit(data.getRefOrder());
            userName = credit.getUserName();
            loanBank = credit.getLoanBankCode();
            bizType = credit.getShopWay();
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "征信单";
        }
        if ("BO".equals(data.getRefOrder().substring(0, 2))) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                .getRefOrder());
            userName = budgetOrder.getCustomerName();
            loanBank = budgetOrder.getLoanBankCode();
            bizType = budgetOrder.getShopWay();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "准入单";
        }
        if ("RB".equals(data.getRefOrder().substring(0, 2))) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRefOrder());
            userName = repayBiz.getRealName();
            loanBank = repayBiz.getLoanBank();
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(repayBiz
                .getRefCode());
            bizType = budgetOrder.getShopWay();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "还款业务";
        }
        if ("L".equals(data.getRefOrder().substring(0, 1))) {
            Logistics logistics = logisticsBO.getLogistics(data.getRefOrder());
            SYSUser user = sysUserBO.getUser(logistics.getUserId());
            if (null != user) {
                userName = user.getRealName();
            }
            bizOrderType = "资料传递";
        }
        data.setUserName(userName);
        data.setLoanBank(loanBank);
        data.setBizType(bizType);
        data.setDepartmentName(departmentName);
        data.setBizOrderType(bizOrderType);
        return data;
    }

    private SYSBizLog init(SYSBizLog sysBizLog) {
        SYSUser user = sysUserBO.getUser(sysBizLog.getOperator());
        if (null != user) {
            sysBizLog.setOperatorName(user.getRealName());
        }
        return sysBizLog;
    }
}
