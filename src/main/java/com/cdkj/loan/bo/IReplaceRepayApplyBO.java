package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ReplaceRepayApply;

/**
 * 代偿预算单
 * @author: silver 
 * @since: 2018年6月14日 下午9:34:45 
 * @history:
 */
public interface IReplaceRepayApplyBO extends IPaginableBO<ReplaceRepayApply> {

    public boolean isReplaceRepayApplyExist(String code);

    public String saveReplaceRepayApply(ReplaceRepayApply data);

    public void refreshFinanceManageApprove(String code, String approveResult,
            String updater, String remark);

    public void refreshMakeDocument(String code, String updater);

    public List<ReplaceRepayApply> queryReplaceRepayApplyList(
            ReplaceRepayApply condition);

    public ReplaceRepayApply getReplaceRepayApply(String code);

    public void refreshReplaceRepayStatus(ReplaceRepayApply replaceRepayApply);

}
