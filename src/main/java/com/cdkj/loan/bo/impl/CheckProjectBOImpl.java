package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICheckProjectBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICheckProjectDAO;
import com.cdkj.loan.domain.CheckProject;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CheckProjectBOImpl extends PaginableBOImpl<CheckProject>
        implements ICheckProjectBO {

    @Autowired
    private ICheckProjectDAO checkProjectDAO;

    @Override
    public String saveCheckProject(CheckProject data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CHECK_PROJECT.getCode());
            data.setCode(code);
            checkProjectDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<CheckProject> queryCheckProjectList(CheckProject condition) {
        return checkProjectDAO.selectList(condition);
    }

    @Override
    public CheckProject getCheckProject(String code) {
        CheckProject data = null;
        if (StringUtils.isNotBlank(code)) {
            CheckProject condition = new CheckProject();
            condition.setCode(code);
            data = checkProjectDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "考核项目不存在");
            }
        }
        return data;
    }
}
