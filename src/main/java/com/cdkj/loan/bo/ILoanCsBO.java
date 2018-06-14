package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanCs;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:28:14 
 * @history:
 */
public interface ILoanCsBO extends IPaginableBO<LoanCs> {

    public void refreshLoanCs(LoanCs data);

    public List<LoanCs> queryLoanCsList(LoanCs condition);

    public LoanCs getLoanCs(String code);

}
