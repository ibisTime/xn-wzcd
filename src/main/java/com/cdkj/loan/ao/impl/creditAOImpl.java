package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;

@Service
public class creditAOImpl implements ICreditAO {

    @Autowired
    private ICreditBO creditBOImpl;

    @Autowired
    private ICreditUserBO creditUserBOImpl;

    @Override
    public String addCredit(Credit data, List<CreditUser> dataList) {

        creditBOImpl.addCredit(data);

        creditUserBOImpl.addCreditList(dataList);

        return data.getCode();
    }

}
