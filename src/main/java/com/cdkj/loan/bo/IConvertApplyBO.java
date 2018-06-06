package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ConvertApply;

public interface IConvertApplyBO extends IPaginableBO<ConvertApply> {

    public void saveConvertApply(ConvertApply data);

    public void updateConvertApplyStatus(ConvertApply convertApply);

    public int refreshConvertApply(ConvertApply data);

    public List<ConvertApply> queryConvertApplyList(ConvertApply condition);

    public ConvertApply getConvertApply(String code);

}
