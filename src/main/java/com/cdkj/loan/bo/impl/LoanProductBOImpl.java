package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ILoanProductDAO;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:40:05 
 * @history:
 */
@Component
public class LoanProductBOImpl extends PaginableBOImpl<LoanProduct> implements
        ILoanProductBO {

    @Autowired
    private ILoanProductDAO loanProductDAO;

    @Override
    public void saveLoanProduct(LoanProduct data) {
        loanProductDAO.insert(data);
    }

    @Override
    public void dropLoanProduct(String code) {
        if (null == code) {
            throw new BizException("xn0000", "产品编号不能为空");
        }
        LoanProduct condition = new LoanProduct();
        condition.setCode(code);
        loanProductDAO.delete(condition);
    }

    @Override
    public void editLoanProduct(LoanProduct data) {
        loanProductDAO.updateLoanProduct(data);
    }

    @Override
    public void publishYesLoanProduct(String code, String updater) {
        if (null == code) {
            throw new BizException("xn0000", "产品编号不能为空");
        }

        LoanProduct condition = new LoanProduct();
        condition.setCode(code);
        condition.setStatus(ELoanProductStatus.PUBLISH_YES.getCode());
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        loanProductDAO.updateLoanProductPublish(condition);
    }

    @Override
    public void publishNoLoanProduct(String code, String updater) {
        if (null == code) {
            throw new BizException("xn0000", "产品编号不能为空");
        }

        LoanProduct condition = new LoanProduct();
        condition.setCode(code);
        condition.setStatus(ELoanProductStatus.PUBLISH_NO.getCode());
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        loanProductDAO.updateLoanProductPublish(condition);
    }

    @Override
    public LoanProduct getLoanProduct(String code) {
        if (null == code) {
            throw new BizException("xn0000", "产品编号不能为空");
        }

        LoanProduct condition = new LoanProduct();
        condition.setCode(code);
        return loanProductDAO.select(condition);
    }

    @Override
    public List<LoanProduct> queryLoanProductList(LoanProduct condition) {
        return loanProductDAO.selectList(condition);
    }
}
