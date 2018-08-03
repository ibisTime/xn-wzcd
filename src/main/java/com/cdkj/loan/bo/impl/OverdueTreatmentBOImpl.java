package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IOverdueTreatmentBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IOverdueTreatmentDAO;
import com.cdkj.loan.domain.OverdueTreatment;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class OverdueTreatmentBOImpl extends PaginableBOImpl<OverdueTreatment>
        implements IOverdueTreatmentBO {

    @Autowired
    private IOverdueTreatmentDAO overdueTreatmentDAO;

    public String saveOverdueTreatment(OverdueTreatment data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.OVERDUE_TREATMENT.getCode());
            data.setCode(code);
            overdueTreatmentDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeOverdueTreatment(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            OverdueTreatment data = new OverdueTreatment();
            data.setCode(code);
            count = overdueTreatmentDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshOverdueTreatment(OverdueTreatment data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            // count = overdueTreatmentDAO.update(data);
        }
        return count;
    }

    @Override
    public List<OverdueTreatment> queryOverdueTreatmentList(
            OverdueTreatment condition) {
        return overdueTreatmentDAO.selectList(condition);
    }

    @Override
    public OverdueTreatment getOverdueTreatment(String code) {
        OverdueTreatment data = null;
        if (StringUtils.isNotBlank(code)) {
            OverdueTreatment condition = new OverdueTreatment();
            condition.setCode(code);
            data = overdueTreatmentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在！");
            }
        }
        return data;
    }
}
