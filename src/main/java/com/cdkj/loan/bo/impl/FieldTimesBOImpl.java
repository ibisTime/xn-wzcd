package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IFieldTimesBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IFieldTimesDAO;
import com.cdkj.loan.domain.FieldTimes;
import com.cdkj.loan.enums.EFieldType;
import com.cdkj.loan.exception.BizException;

@Component
public class FieldTimesBOImpl extends PaginableBOImpl<FieldTimes> implements
        IFieldTimesBO {

    @Autowired
    private IFieldTimesDAO fieldTimesDAO;

    /** 
     * @see com.std.user.bo.IFieldTimesBO#isFieldTimesExist(java.lang.String, java.lang.String)
     */
    @Override
    public void isFieldTimesExist(EFieldType fieldType, String userId) {
        FieldTimes condition = new FieldTimes();
        condition.setType(fieldType.getCode());
        condition.setUserId(userId);
        List<FieldTimes> list = fieldTimesDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException("xn000000", fieldType.getValue()
                    + "已修改一次，无法再次修改");
        }
    }

    @Override
    public void saveFieldTimes(EFieldType fieldType, String userId) {
        if (StringUtils.isNotBlank(userId)) {
            FieldTimes data = new FieldTimes();
            data.setType(fieldType.getCode());
            data.setUserId(userId);
            data.setTimes(1);
            fieldTimesDAO.insert(data);
        }
    }

    @Override
    public List<FieldTimes> queryFieldTimesList(FieldTimes condition) {
        return fieldTimesDAO.selectList(condition);
    }
}
