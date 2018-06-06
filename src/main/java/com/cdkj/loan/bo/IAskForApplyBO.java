package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.AskForApply;

public interface IAskForApplyBO extends IPaginableBO<AskForApply> {

    public String saveAskForApply(AskForApply data);

    public List<AskForApply> queryAskForApplyList(AskForApply condition);

    public AskForApply getAskForApply(String code);

    public void updateAskForApplyStatus(AskForApply askForApply);

}
