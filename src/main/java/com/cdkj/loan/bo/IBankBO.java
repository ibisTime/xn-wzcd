package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Bank;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:34:57 
 * @history:
 */
public interface IBankBO extends IPaginableBO<Bank> {
    public String saveBank(Bank data);

    public int dropBank(Bank data);

    public Bank getBank(Bank condition);

    public int editBank(Bank data);

    public List<Bank> queryBankList(Bank condition);
}
