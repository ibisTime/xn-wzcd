package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.TransferPositionApply;
import com.cdkj.loan.dto.req.XN632880Req;

@Component
public interface ITransferPositionApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请
    public String addTransferPositionApply(XN632880Req req);

    // 审核
    public void approveTransferPositionApply(String code, String approveResult,
            String updater, String remark);

    public Paginable<TransferPositionApply> queryTransferPositionApplyPage(
            int start, int limit, TransferPositionApply condition);

    public List<TransferPositionApply> queryTransferPositionApplyList(
            TransferPositionApply condition);

    public TransferPositionApply getTransferPositionApply(String code);

}
