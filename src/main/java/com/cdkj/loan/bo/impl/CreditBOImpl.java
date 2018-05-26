package com.cdkj.loan.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.enums.EGeneratePrefix;

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

    @Override
    public String addCredit(Credit data) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.CREDIT
            .getCode());
        data.setCode(code);
        creditDAO.insert(data);

        return code;
    }

    // 修改征信单
    @Override
    public void updateCredit(Credit credit) {
        creditDAO.updateCredit(credit);
    }

    // 查询征信单详情
    @Override
    public Credit queryCreditDetail(String code) {

        Credit condition = new Credit();

        condition.setCode(code);

        return creditDAO.select(condition);
    }

    // 更新征信单节点
    @Override
    public void refreshCreditNode(Credit credit) {
        int count = 0;
        if (StringUtils.isNotBlank(credit.getCode())) {
            count = creditDAO.updateNode(credit);
        }

    }

}
