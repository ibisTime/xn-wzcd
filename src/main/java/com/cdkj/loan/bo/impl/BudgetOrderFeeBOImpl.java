package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderFeeDAO;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BudgetOrderFeeBOImpl extends PaginableBOImpl<BudgetOrderFee>
        implements IBudgetOrderFeeBO {

    @Autowired
    private IBudgetOrderFeeDAO budgetOrderFeeDAO;

    @Override
    public String saveBudgetOrderFee(BudgetOrderFee data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BUDGET_ORDER_FEE
                .getCode());
            data.setCode(code);
            budgetOrderFeeDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition) {
        return budgetOrderFeeDAO.selectList(condition);
    }

    @Override
    public BudgetOrderFee getBudgetOrderFee(String code) {
        BudgetOrderFee data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderFee condition = new BudgetOrderFee();
            condition.setCode(code);
            data = budgetOrderFeeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "手续费不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshBudgetOrderFee(BudgetOrderFee budgetOrderFee) {
        if (null != budgetOrderFee) {
            budgetOrderFeeDAO.updateBudgetOrderFeeRealAmount(budgetOrderFee);
        }
    }
}
