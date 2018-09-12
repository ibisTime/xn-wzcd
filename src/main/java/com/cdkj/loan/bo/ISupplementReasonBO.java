package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SupplementReason;

public interface ISupplementReasonBO extends IPaginableBO<SupplementReason> {

    public int saveSupplementReason(SupplementReason data);

    public List<SupplementReason> querySupplementReasonList(
            SupplementReason condition);

    public SupplementReason getSupplementReason(int id);

    // 改变是否已补件
    public void refreshSupplementReason(SupplementReason reason);

    // 通过物流单编号查询补件原因
    public List<SupplementReason> getSupplementReasonByLogisticsCode(
            String logisticsCode);

    // 改变原来的补件原因的物流单编号
    public void refreshLogisticsCode(int id, String loCode);

    // 更新补件原因状态
    public void refreshReasonStatus(SupplementReason reason);

}
