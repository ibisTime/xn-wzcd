package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankRate;
import com.cdkj.loan.dto.req.XN632030ReqRate;

/**
 * 利率明细
 * @author: silver 
 * @since: 2018年5月27日 下午7:46:15 
 * @history:
 */
public interface IBankRateBO extends IPaginableBO<BankRate> {
    public int saveBankRate(List<XN632030ReqRate> req, String bankCode);

    public int dropBankRate(BankRate data);

    public BankRate getBankRate(BankRate condition);

    public int editBankRate(BankRate data);

    public List<BankRate> queryBankRateList(BankRate condition);
}
