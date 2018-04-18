package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.FieldTimes;
import com.cdkj.loan.enums.EFieldType;

public interface IFieldTimesBO extends IPaginableBO<FieldTimes> {

    public void isFieldTimesExist(EFieldType fieldType, String userId);

    public void saveFieldTimes(EFieldType fieldType, String userId);

    public List<FieldTimes> queryFieldTimesList(FieldTimes condition);

}
