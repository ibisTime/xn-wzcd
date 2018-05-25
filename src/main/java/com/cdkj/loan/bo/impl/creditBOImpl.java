package com.cdkj.loan.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.enums.EGeneratePrefix;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:05 
 * @history:
 */
@Component
public class creditBOImpl extends PaginableBOImpl<Credit> implements ICreditBO {

    @Autowired
    private ICreditDAO creditDAO;

    @Override
    public void addCredit(Credit data) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT
            .getCode());
        data.setCode(code);
        creditDAO.insert(data);
    }

}
