package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.dto.req.XN632320Req;

/**
 * 代偿预算单
 * @author: silver 
 * @since: 2018年6月14日 下午10:17:04 
 * @history:
 */
@Component
public interface IReplaceRepayApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addReplaceRepayApply(XN632320Req req);

    public void refreshFinanceManageApprove(String code, String approveResult,
            String updater, String remark);

    public void refreshMakeDocument(String code, String updater);

    public Paginable<ReplaceRepayApply> queryReplaceRepayApplyPage(int start,
            int limit, ReplaceRepayApply condition);

    public List<ReplaceRepayApply> queryReplaceRepayApplyList(
            ReplaceRepayApply condition);

    public ReplaceRepayApply getReplaceRepayApply(String code);

}
