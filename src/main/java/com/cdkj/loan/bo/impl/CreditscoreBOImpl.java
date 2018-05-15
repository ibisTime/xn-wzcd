package com.cdkj.loan.bo.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.User;

@Component
public class CreditscoreBOImpl extends PaginableBOImpl<User>
        implements ICreditscoreBO {

    @Autowired
    IAccountBO accountBO;

    @Override
    public void changeCreditscore(Account account, BigDecimal changeScore,
            String refNo, String bizNote) {

        accountBO.changeAmount(account, changeScore, null, null, null, refNo,
            null, bizNote);

    }

}
