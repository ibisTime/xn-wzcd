package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IEntryApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IEntryApplyDAO;
import com.cdkj.loan.domain.EntryApply;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class EntryApplyBOImpl extends PaginableBOImpl<EntryApply>
        implements IEntryApplyBO {

    @Autowired
    private IEntryApplyDAO entryApplyDAO;

    public String saveEntryApply(EntryApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.ENTRYAPPLY.getCode());
            data.setCode(code);
            entryApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void updateEntryApplyStatus(EntryApply entryApply) {
        entryApplyDAO.updateEntryApplyStatus(entryApply);
    }

    @Override
    public List<EntryApply> queryEntryApplyList(EntryApply condition) {
        return entryApplyDAO.selectList(condition);
    }

    @Override
    public EntryApply getEntryApply(String code) {
        EntryApply data = null;
        if (StringUtils.isNotBlank(code)) {
            EntryApply condition = new EntryApply();
            condition.setCode(code);
            data = entryApplyDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "入职申请不存在！");
            }
        }
        return data;
    }

}
