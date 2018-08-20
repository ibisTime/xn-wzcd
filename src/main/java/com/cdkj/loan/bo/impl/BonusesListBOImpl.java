package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBonusesListBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBonusesListDAO;
import com.cdkj.loan.domain.BonusesList;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BonusesListBOImpl extends PaginableBOImpl<BonusesList>
        implements IBonusesListBO {

    @Autowired
    private IBonusesListDAO bonusesListDAO;

    public String saveBonusesList(BonusesList data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BONUSES_LIST.getCode());
            data.setCode(code);
            bonusesListDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<BonusesList> queryBonusesListList(BonusesList condition) {
        return bonusesListDAO.selectList(condition);
    }

    @Override
    public BonusesList getBonusesList(String code) {
        BonusesList data = null;
        if (StringUtils.isNotBlank(code)) {
            BonusesList condition = new BonusesList();
            condition.setCode(code);
            data = bonusesListDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "奖金提成编号不存在！");
            }
        }
        return data;
    }
}
