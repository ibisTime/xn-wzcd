package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IConvertApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IConvertApplyDAO;
import com.cdkj.loan.domain.ConvertApply;
import com.cdkj.loan.exception.BizException;

@Component
public class ConvertApplyBOImpl extends PaginableBOImpl<ConvertApply>
        implements IConvertApplyBO {

    @Autowired
    private IConvertApplyDAO convertApplyDAO;

    public void saveConvertApply(ConvertApply data) {
        if (data != null) {
            convertApplyDAO.insert(data);
        }
    }

    @Override
    public void updateConvertApplyStatus(ConvertApply data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            convertApplyDAO.updateConvertApplyStatus(data);
        }
    }

    @Override
    public int refreshConvertApply(ConvertApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = convertApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ConvertApply> queryConvertApplyList(ConvertApply condition) {
        return convertApplyDAO.selectList(condition);
    }

    @Override
    public ConvertApply getConvertApply(String code) {
        ConvertApply data = null;
        if (StringUtils.isNotBlank(code)) {
            ConvertApply condition = new ConvertApply();
            condition.setCode(code);
            data = convertApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "转正申请不存在！");
            }
        }
        return data;
    }

}
