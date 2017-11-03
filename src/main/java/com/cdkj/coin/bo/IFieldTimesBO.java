package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.FieldTimes;
import com.cdkj.coin.enums.EFieldType;

public interface IFieldTimesBO extends IPaginableBO<FieldTimes> {

    public void isFieldTimesExist(EFieldType fieldType, String userId);

    public void saveFieldTimes(EFieldType fieldType, String userId);

    public List<FieldTimes> queryFieldTimesList(FieldTimes condition);

}
