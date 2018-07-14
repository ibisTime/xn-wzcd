package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午2:04:01 
 * @history:
 */
@Component
public class CreditUserBOImpl extends PaginableBOImpl<CreditUser>
        implements ICreditUserBO {

    @Autowired
    private ICreditUserDAO creditUserDAO;

    @Override
    public void saveCreditUser(CreditUser creditUser) {
        String code = null;
        if (creditUser != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CREDITUSER.getCode());
            creditUser.setCode(code);
            creditUserDAO.insert(creditUser);
        }

    }

    @Override
    public CreditUser getCreditUser(String code) {

        CreditUser data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditUser creditUser = new CreditUser();
            creditUser.setCode(code);
            data = creditUserDAO.select(creditUser);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "征信人员编号不存在!");
            }
        }
        return data;
    }

    @Override
    public CreditUser getCreditUserNotNull(String code) {

        CreditUser data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditUser creditUser = new CreditUser();
            creditUser.setCode(code);
            data = creditUserDAO.select(creditUser);
        }
        return data;
    }

    @Override
    public void refreshCreditUser(CreditUser creditUser) {

        if (StringUtils.isNotBlank(creditUser.getCode())) {
            creditUserDAO.updateCreditUser(creditUser);
        }

    }

    @Override
    public void inputBankCreditResult(CreditUser creditUser) {
        if (StringUtils.isNotBlank(creditUser.getCode())) {
            creditUserDAO.inputBankCreditResult(creditUser);
        }

    }

    @Override
    public void refreshCreditUserIncome(CreditUser creditUser) {
        creditUserDAO.updateCreditUserIncome(creditUser);
    }

    @Override
    public List<CreditUser> queryCreditUserList(CreditUser condition) {

        return creditUserDAO.selectList(condition);
    }

    @Override
    public CreditUser getCreditUserByCreditCode(String creditCode,
            ELoanRole loanRole) {
        CreditUser condition = new CreditUser();
        condition.setCreditCode(creditCode);
        condition.setLoanRole(loanRole.getCode());

        return creditUserDAO.select(condition);
    }

    @Override
    public CreditUser getCreditUserByIsFirstAudit(String creditCode,
            ELoanRole loanRole) {
        CreditUser condition = new CreditUser();
        condition.setCreditCode(creditCode);
        condition.setLoanRole(loanRole.getCode());
        condition.setIsFirstAudit(EBoolean.YES.getCode());

        return creditUserDAO.select(condition);
    }

    @Override
    public List<CreditUser> getCreditUserListByCreditCode(String creditCode,
            ELoanRole loanRole) {
        CreditUser condition = new CreditUser();
        condition.setCreditCode(creditCode);
        condition.setLoanRole(loanRole.getCode());

        return creditUserDAO.selectList(condition);
    }

    @Override
    public List<CreditUser> getCreditUserListByIsFirstAudit(String creditCode,
            ELoanRole loanRole) {
        CreditUser condition = new CreditUser();
        condition.setCreditCode(creditCode);
        condition.setLoanRole(loanRole.getCode());
        condition.setIsFirstAudit(EBoolean.YES.getCode());

        return creditUserDAO.selectList(condition);
    }

    @Override
    public void refreshCourtNetworkResults(String code,
            String courtNetworkResults) {
        CreditUser creditUser = getCreditUser(code);
        creditUser.setCourtNetworkResults(courtNetworkResults);
        creditUserDAO.refreshCourtNetworkResults(creditUser);
    }

    @Override
    public void refreshCreditUserIsFirstAudit(CreditUser creditUser) {
        creditUser.setIsFirstAudit(EBoolean.YES.getCode());
        creditUserDAO.updateCreditUserIsFirstAudit(creditUser);
    }

}
