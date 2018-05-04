package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Bankcard;

public interface IBankcardBO extends IPaginableBO<Bankcard> {

    public String saveBankcard(Bankcard data);

    public int removeBankcard(String code);

    public int refreshBankcard(Bankcard data);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

}
