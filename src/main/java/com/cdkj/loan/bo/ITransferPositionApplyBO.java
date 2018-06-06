package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TransferPositionApply;

public interface ITransferPositionApplyBO
        extends IPaginableBO<TransferPositionApply> {

    public String saveTransferPositionApply(TransferPositionApply data);

    public List<TransferPositionApply> queryTransferPositionApplyList(
            TransferPositionApply condition);

    public TransferPositionApply getTransferPositionApply(String code);

    public void updateTransferPositionApplyStatus(
            TransferPositionApply transferPositionApply);

}
