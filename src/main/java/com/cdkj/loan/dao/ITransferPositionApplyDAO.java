package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.TransferPositionApply;

//dao层 
public interface ITransferPositionApplyDAO
        extends IBaseDAO<TransferPositionApply> {
    String NAMESPACE = ITransferPositionApplyDAO.class.getName().concat(".");

    void updateTransferPositionApplyStatus(TransferPositionApply data);
}
