package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBudgetOrderFeeDetailDAO;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:15:17 
 * @history:
 */
@Component
public class BudgetOrderFeeDetailBOImpl extends
        PaginableBOImpl<BudgetOrderFeeDetail> implements
        IBudgetOrderFeeDetailBO {

    @Autowired
    private IBudgetOrderFeeDetailDAO budgetOrderFeeDetailDAO;

    @Override
    public String saveBudgetOrderFeeDetail(BudgetOrderFeeDetail data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BUDGET_ORDER_FEE_DETAIL.getCode());
            data.setCode(code);
            budgetOrderFeeDetailDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailDAO.selectList(condition);
    }

    @Override
    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code) {
        BudgetOrderFeeDetail data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderFeeDetail condition = new BudgetOrderFeeDetail();
            condition.setCode(code);
            data = budgetOrderFeeDetailDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "手续费明细不存在");
            }
        }
        return data;
    }
}
