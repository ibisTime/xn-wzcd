package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.enums.ECreditUserRelation;
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

    @Autowired
    private ICreditUserDAO creditUserDAO;

    // 修改征信人员
    @Override
    public void updateCreditUser(CreditUser creditUser) {
        creditUserDAO.updateCreditUser(creditUser);
    }

    // 录入银行征信结果
    @Override
    public void inputBankCreditResult(CreditUser creditUser) {
        creditUserDAO.inputBankCreditResult(creditUser);

    }

    // 新增征信人员
    @Override
    public void addCreditUser(CreditUser creditUser) {
        String code = null;
        if (creditUser != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.CREDITUSER
                .getCode());
            creditUser.setCode(code);
            creditUserDAO.insert(creditUser);
        }

    }

    // 批量查询征信人员 根据征信单编号
    @Override
    public List<CreditUser> queryCreditUserListByCreditCode(String creditCode) {

        CreditUser creditUser = new CreditUser();
        creditUser.setCreditCode(creditCode);

        return creditUserDAO.selectList(creditUser);
    }

    // 根据征信单编号和征信人员关系获取对应信息
    @Override
    public CreditUser getCreditUserByCreditCode(String creditCode,
            ECreditUserRelation creditUserRelation) {
        CreditUser condition = new CreditUser();
        condition.setCreditCode(creditCode);
        condition.setRelation(creditUserRelation.getCode());

        return creditUserDAO.select(condition);
    }

    // 查看征信报告详情
    @Override
    public CreditUser queryCreditReportDetail(String code) {

        CreditUser creditUser = new CreditUser();
        creditUser.setCode(code);
        return creditUserDAO.select(creditUser);
    }

    // 修改征信人员收入
    @Override
    public void refreshCreditUserIncome(CreditUser creditUser) {
        creditUserDAO.updateCreditUserIncome(creditUser);
    }

}
