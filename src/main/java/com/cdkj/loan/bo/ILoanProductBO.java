package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanProduct;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:33:47 
 * @history:
 */
public interface ILoanProductBO extends IPaginableBO<LoanProduct> {
    public void saveLoanProduct(LoanProduct data);

    public void dropLoanProduct(String code);

    public void editLoanProduct(LoanProduct data);

    public void publishYesLoanProduct(String code, String updater);

    public void publishNoLoanProduct(String code, String updater);

    public LoanProduct getLoanProduct(String code);

    public List<LoanProduct> queryLoanProductList(LoanProduct condition);
}
