package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IWorkExperienceBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IWorkExperienceDAO;
import com.cdkj.loan.domain.WorkExperience;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class WorkExperienceBOImpl extends PaginableBOImpl<WorkExperience>
        implements IWorkExperienceBO {

    @Autowired
    private IWorkExperienceDAO workExperienceDAO;

    @Override
    public String saveWorkExperience(WorkExperience data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.WORK_EXPERIENCE.getCode());
            data.setCode(code);
            workExperienceDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<WorkExperience> queryWorkExperienceList(
            WorkExperience condition) {
        return workExperienceDAO.selectList(condition);
    }

    @Override
    public WorkExperience getWorkExperience(String code) {
        WorkExperience data = null;
        if (StringUtils.isNotBlank(code)) {
            WorkExperience condition = new WorkExperience();
            condition.setCode(code);
            data = workExperienceDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "工作经历不存在");
            }
        }
        return data;
    }
}
