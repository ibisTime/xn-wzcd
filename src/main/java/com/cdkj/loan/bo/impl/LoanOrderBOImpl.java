package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILoanOrderDAO;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ELoanOrderStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class LoanOrderBOImpl extends PaginableBOImpl<LoanOrder>
        implements ILoanOrderBO {

    @Autowired
    private ILoanOrderDAO loanOrderDAO;

    @Override
    public boolean isLoanOrderExist(String code) {
        LoanOrder condition = new LoanOrder();
        condition.setCode(code);
        if (loanOrderDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveLoanOrder(LoanOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("LO");
            data.setCode(code);
            loanOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshLoanOrder(LoanOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = loanOrderDAO.update(data);
        }
        return count;
    }

    @Override
    public List<LoanOrder> queryLoanOrderList(LoanOrder condition) {
        return loanOrderDAO.selectList(condition);
    }

    @Override
    public LoanOrder getLoanOrder(String code) {
        LoanOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            LoanOrder condition = new LoanOrder();
            condition.setCode(code);
            data = loanOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "车贷订单" + code + "不存在");
            }
        }
        return data;
    }

    public LoanOrder checkCanAudit(String code) {
        LoanOrder data = getLoanOrder(code);
        if (!data.getStatus().equals(ELoanOrderStatus.TO_AUDIT.getCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "订单不是待审核状态！！！");
        }
        return data;
    }

    @Override
    public int approveSuccess(LoanOrder data, String repayBizCode,
            String userId, String approveUser, String approveNote) {
        data.setRepayBizCode(repayBizCode);
        data.setUserId(userId);
        data.setStatus(ELoanOrderStatus.AUDIT_PASS.getCode());
        data.setUpdater(approveUser);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);
        return loanOrderDAO.updateApproveSuccess(data);
    }

    @Override
    public int approveFailed(LoanOrder data, String approveUser,
            String approveNote) {
        data.setStatus(ELoanOrderStatus.AUDIT_NOTPASS.getCode());
        data.setUpdater(approveUser);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);
        return loanOrderDAO.updateApproveFailed(data);
    }

}
