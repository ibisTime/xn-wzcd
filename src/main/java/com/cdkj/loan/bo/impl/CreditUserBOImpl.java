package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.enums.EGeneratePrefix;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午2:04:01 
 * @history:
 */
@Component
public class CreditUserBOImpl extends PaginableBOImpl<CreditUser> implements
        ICreditUserBO {

    private ICreditUserDAO creditUserDAO;

    @Override
    public long getTotalCount(CreditUser condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Paginable<CreditUser> getPaginable(int start, CreditUser condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paginable<CreditUser> getPaginable(int start, int pageSize,
            CreditUser condition) {
        // TODO Auto-generated method stub
        return null;
    }

    // 批量新增征信人员列表
    @Override
    public void addCreditList(List<CreditUser> dataList) {

        for (CreditUser creditUser : dataList) {
            String code = OrderNoGenerater.generate(EGeneratePrefix.CREDITUSER
                .getCode());
            creditUser.setCode(code);
        }

        creditUserDAO.insertCreditUserList(dataList);
    }

}
