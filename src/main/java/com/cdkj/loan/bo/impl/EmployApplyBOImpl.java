package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IEmployApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IEmployApplyDAO;
import com.cdkj.loan.domain.EmployApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class EmployApplyBOImpl extends PaginableBOImpl<EmployApply>
        implements IEmployApplyBO {

    @Autowired
    private IEmployApplyDAO employApplyDAO;

    @Override
    public String saveEmployApply(EmployApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.EmployApply.getCode());
            data.setCode(code);
            employApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void interview(EmployApply data) {
        if (data != null) {
            employApplyDAO.updateInterview(data);
        }
    }

    @Override
    public List<EmployApply> queryEmployApplyList(EmployApply condition) {
        return employApplyDAO.selectList(condition);
    }

    @Override
    public EmployApply getEmployApply(String code) {
        EmployApply data = null;
        if (StringUtils.isNotBlank(code)) {
            EmployApply condition = new EmployApply();
            condition.setCode(code);
            data = employApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "应聘申请不存在");
            }
        }
        return data;
    }
}
