package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SupplementReason;

public interface ISupplementReasonBO extends IPaginableBO<SupplementReason> {

    public Long saveSupplementReason(SupplementReason data);

    public List<SupplementReason> querySupplementReasonList(
            SupplementReason condition);

    public SupplementReason getSupplementReason(Long id);

}
