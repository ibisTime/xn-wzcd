package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELoanRole;

/**
 * 征信单
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:40:05 
 * @history:
 */
@Component
public class CreditBOImpl extends PaginableBOImpl<Credit> implements ICreditBO {

    @Autowired
    private ICreditDAO creditDAO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Override
    public String saveCredit(Credit data) {
        String code = null;
        if (null != data) {
            code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT.getCode());
            data.setCode(code);
            creditDAO.insert(data);
        }

        return code;
    }

    @Override
    public Credit getCredit(String code) {

        Credit condition = new Credit();
        condition.setCode(code);
        Credit credit = creditDAO.select(condition);
        CreditUser applyUser = creditUserBO.getCreditUserByCreditCode(code,
            ELoanRole.APPLY_USER);
        credit.setCreditUser(applyUser);
        return credit;
    }

    @Override
    public void refreshCredit(Credit data) {
        creditDAO.updateCredit(data);
    }

    @Override
    public Paginable<Credit> getPaginableByRoleCode(int start, int limit,
            Credit condition) {
        prepare(condition);

        long totalCount = creditDAO.selectTotalCountByRoleCode(condition);

        Paginable<Credit> page = new Page<Credit>(start, limit, totalCount);

        List<Credit> dataList = creditDAO.selectReqBudgetByRoleCodeList(
            condition, page.getStart(), page.getPageSize());

        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshCreditNode(Credit credit) {

        creditDAO.updateNode(credit);

    }

}
