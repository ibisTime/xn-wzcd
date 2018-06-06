package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IFeeAdvanceApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IFeeAdvanceApplyDAO;
import com.cdkj.loan.domain.FeeAdvanceApply;
import com.cdkj.loan.exception.BizException;

@Component
public class FeeAdvanceApplyBOImpl extends PaginableBOImpl<FeeAdvanceApply>
        implements IFeeAdvanceApplyBO {

    @Autowired
    private IFeeAdvanceApplyDAO feeAdvanceApplyDAO;

    @Override
    public void saveFeeAdvanceApply(FeeAdvanceApply data) {
        if (data != null) {
            feeAdvanceApplyDAO.insert(data);
        }
    }

    @Override
    public void refreshFeeAdvanceApplyApprove(FeeAdvanceApply data,
            String status, String updater, String remark) {
        if (null != data) {
            data.setStatus(status);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            feeAdvanceApplyDAO.updateApprove(data);
        }
    }

    @Override
    public void refreshFeeAdvanceApplyFinanceApprove(FeeAdvanceApply data,
            String status, String updater, String remark) {
        if (null != data) {
            data.setStatus(status);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            feeAdvanceApplyDAO.updateApprove(data);
        }
    }

    @Override
    public void sureFk(FeeAdvanceApply data) {
        if (null != data) {
            feeAdvanceApplyDAO.updateFk(data);
        }
    }

    @Override
    public List<FeeAdvanceApply> queryFeeAdvanceApplyList(
            FeeAdvanceApply condition) {
        return feeAdvanceApplyDAO.selectList(condition);
    }

    @Override
    public FeeAdvanceApply getFeeAdvanceApply(String code) {
        FeeAdvanceApply data = null;
        if (StringUtils.isNotBlank(code)) {
            FeeAdvanceApply condition = new FeeAdvanceApply();
            condition.setCode(code);
            data = feeAdvanceApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "费用预支申请不存在");
            }
        }
        return data;
    }
}
