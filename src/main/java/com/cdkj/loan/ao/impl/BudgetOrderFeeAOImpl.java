package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderFeeAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.exception.BizException;

/**
 * 准入单手续费
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:46:40 
 * @history:
 */
@Service
public class BudgetOrderFeeAOImpl implements IBudgetOrderFeeAO {

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private IBudgetOrderFeeDetailBO budgetOrderFeeDetailBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IBankBO bankBO;

    @Override
    public Paginable<BudgetOrderFee> queryBudgetOrderFeePage(int start,
            int limit, BudgetOrderFee condition) {

        Paginable<BudgetOrderFee> paginable = budgetOrderFeeBO
            .getPaginable(start, limit, condition);

        List<BudgetOrderFee> list = paginable.getList();

        for (BudgetOrderFee budgetOrderFee : list) {
            String companyCode = budgetOrderFee.getCompanyCode();
            Department department = departmentBO.getDepartment(companyCode);
            if (null != department) {
                budgetOrderFee.setCompanyName(department.getName());
            }
            SYSUser user = sysUserBO.getUser(budgetOrderFee.getUpdater());
            if (null != user) {
                budgetOrderFee.setUpdater(user.getRealName());
            }

            SYSUser saleUser = sysUserBO.getUser(budgetOrderFee.getUserId());
            budgetOrderFee.setUserName(saleUser.getRealName());
        }

        return paginable;
    }

    @Override
    public List<BudgetOrderFee> queryBudgetOrderFeeList(
            BudgetOrderFee condition) {
        return budgetOrderFeeBO.queryBudgetOrderFeeList(condition);
    }

    @Override
    public BudgetOrderFee getBudgetOrderFee(String code) {
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO
            .getBudgetOrderFee(code);
        if (null == budgetOrderFee) {
            throw new BizException("xn0000", "手续费不存在");
        }

        // 设置操作人真实姓名
        SYSUser user = sysUserBO.getUser(budgetOrderFee.getUpdater());
        if (null != user) {
            budgetOrderFee.setUpdaterRealName(user.getRealName());
        }

        // 设置业务公司真实姓名
        Department department = departmentBO
            .getDepartment(budgetOrderFee.getCompanyCode());
        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrder(budgetOrderFee.getBudgetOrder());
        SYSUser saleUser = sysUserBO.getUser(budgetOrderFee.getUserId());
        budgetOrderFee.setUserName(saleUser.getRealName());

        // 设置贷款银行和贷款金额
        if (null != budgetOrder) {

            Bank bank = bankBO.getBank(budgetOrder.getLoanBank());
            if (null != bank) {
                budgetOrderFee.setLoanBankName(bank.getBankName());
            }
            budgetOrderFee.setLoanAmount(budgetOrder.getLoanAmount());
        }

        BudgetOrderFeeDetail condition = new BudgetOrderFeeDetail();
        condition.setFeeCode(code);
        List<BudgetOrderFeeDetail> list = budgetOrderFeeDetailBO
            .queryBudgetOrderFeeDetailList(condition);
        budgetOrderFee.setCompanyName(department.getName());
        // 设置银行对象（汇入我司账号和银行名）
        for (BudgetOrderFeeDetail budgetOrderFeeDetail : list) {
            String platBankcard = budgetOrderFeeDetail.getPlatBankcard();
            CollectBankcard collectBankcard = collectBankcardBO
                .getCollectBankcard(platBankcard);
            budgetOrderFeeDetail.setCollectBankcard(collectBankcard);
            SYSUser updateUser = sysUserBO
                .getUser(budgetOrderFeeDetail.getUpdater());
            if (null != updateUser) {
                budgetOrderFeeDetail.setUpdater(updateUser.getRealName());
            }

        }

        budgetOrderFee.setBudgetOrderFeeDetailList(list);

        return budgetOrderFee;
    }
}
