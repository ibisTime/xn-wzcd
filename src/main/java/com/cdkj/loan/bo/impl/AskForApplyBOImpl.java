package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAskForApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAskForApplyDAO;
import com.cdkj.loan.domain.AskForApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class AskForApplyBOImpl extends PaginableBOImpl<AskForApply>
        implements IAskForApplyBO {

    @Autowired
    private IAskForApplyDAO askForApplyDAO;

    public String saveAskForApply(AskForApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.ASKFORAPPLY.getCode());
            data.setCode(code);
            askForApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void updateAskForApplyStatus(AskForApply askForApply) {
        askForApplyDAO.updateAskForApplyStatus(askForApply);
    }

    @Override
    public List<AskForApply> queryAskForApplyList(AskForApply condition) {
        return askForApplyDAO.selectList(condition);
    }

    @Override
    public AskForApply getAskForApply(String code) {
        AskForApply data = null;
        if (StringUtils.isNotBlank(code)) {
            AskForApply condition = new AskForApply();
            condition.setCode(code);
            data = askForApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

}
