package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.exception.BizException;

@Service
public class LoanOrderAOImpl implements ILoanOrderAO {

    @Autowired
    private ILoanOrderBO loanOrderBO;

    @Override
    public String addLoanOrder(LoanOrder data) {
        return loanOrderBO.saveLoanOrder(data);
    }

    @Override
    public int editLoanOrder(LoanOrder data) {
        if (!loanOrderBO.isLoanOrderExist(data.getCode())) {
            throw new BizException("xn0000", "车贷订单编号不存在");
        }
        return loanOrderBO.refreshLoanOrder(data);
    }

    @Override
    public int dropLoanOrder(String code) {
        if (!loanOrderBO.isLoanOrderExist(code)) {
            throw new BizException("xn0000", "车贷订单编号不存在");
        }
        return loanOrderBO.removeLoanOrder(code);
    }

    @Override
    public Paginable<LoanOrder> queryLoanOrderPage(int start, int limit,
            LoanOrder condition) {
        return loanOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<LoanOrder> queryLoanOrderList(LoanOrder condition) {
        return loanOrderBO.queryLoanOrderList(condition);
    }

    @Override
    public LoanOrder getLoanOrder(String code) {
        return loanOrderBO.getLoanOrder(code);
    }
}
