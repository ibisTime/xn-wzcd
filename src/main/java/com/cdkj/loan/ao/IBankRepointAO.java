package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankRepoint;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:20:35 
 * @history:
 */
@Component
public interface IBankRepointAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankRepoint(BankRepoint data);

    public int dropBankRepoint(String code);

    public int editBankRepoint(BankRepoint data);

    public Paginable<BankRepoint> queryBankRepointPage(int start, int limit,
            BankRepoint condition);

    public List<BankRepoint> queryBankRepointList(BankRepoint condition);

    public BankRepoint getBankRepoint(String code);

}
