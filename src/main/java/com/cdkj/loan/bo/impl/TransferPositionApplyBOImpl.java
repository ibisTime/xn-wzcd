package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ITransferPositionApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ITransferPositionApplyDAO;
import com.cdkj.loan.domain.TransferPositionApply;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class TransferPositionApplyBOImpl
        extends PaginableBOImpl<TransferPositionApply>
        implements ITransferPositionApplyBO {

    @Autowired
    private ITransferPositionApplyDAO transferPositionApplyDAO;

    public String saveTransferPositionApply(TransferPositionApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.TRANSFERPOSITIONAPPLY.getCode());
            data.setCode(code);
            transferPositionApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void updateTransferPositionApplyStatus(TransferPositionApply data) {
        transferPositionApplyDAO.updateTransferPositionApplyStatus(data);
    }

    @Override
    public List<TransferPositionApply> queryTransferPositionApplyList(
            TransferPositionApply condition) {
        return transferPositionApplyDAO.selectList(condition);
    }

    @Override
    public TransferPositionApply getTransferPositionApply(String code) {
        TransferPositionApply data = null;
        if (StringUtils.isNotBlank(code)) {
            TransferPositionApply condition = new TransferPositionApply();
            condition.setCode(code);
            data = transferPositionApplyDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "申请编号不存在！");
            }
        }
        return data;
    }

}
