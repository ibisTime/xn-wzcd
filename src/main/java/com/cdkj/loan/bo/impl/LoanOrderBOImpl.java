package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILoanOrderDAO;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.exception.BizException;

@Component
public class LoanOrderBOImpl extends PaginableBOImpl<LoanOrder>
        implements ILoanOrderBO {

    @Autowired
    private ILoanOrderDAO loanOrderDAO;

    @Override
    public boolean isLoanOrderExist(String code) {
        LoanOrder condition = new LoanOrder();
        condition.setCode(code);
        if (loanOrderDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveLoanOrder(LoanOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("LO");
            data.setCode(code);
            loanOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeLoanOrder(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            LoanOrder data = new LoanOrder();
            data.setCode(code);
            count = loanOrderDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshLoanOrder(LoanOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = loanOrderDAO.update(data);
        }
        return count;
    }

    @Override
    public List<LoanOrder> queryLoanOrderList(LoanOrder condition) {
        return loanOrderDAO.selectList(condition);
    }

    @Override
    public LoanOrder getLoanOrder(String code) {
        LoanOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            LoanOrder condition = new LoanOrder();
            condition.setCode(code);
            data = loanOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
