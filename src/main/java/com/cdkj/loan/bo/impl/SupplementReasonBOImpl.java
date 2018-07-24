package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ISupplementReasonDAO;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.exception.BizException;

@Component
public class SupplementReasonBOImpl extends PaginableBOImpl<SupplementReason>
        implements ISupplementReasonBO {

    @Autowired
    private ISupplementReasonDAO supplementReasonDAO;

    public Long saveSupplementReason(SupplementReason data) {
        Long id = null;
        supplementReasonDAO.insert(data);
        id = data.getId();
        return id;
    }

    @Override
    public List<SupplementReason> querySupplementReasonList(
            SupplementReason condition) {
        return supplementReasonDAO.selectList(condition);
    }

    @Override
    public SupplementReason getSupplementReason(Long id) {
        SupplementReason data = null;
        if (id != 0) {
            SupplementReason condition = new SupplementReason();
            condition.setId(id);
            data = supplementReasonDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在！");
            }
        }
        return data;
    }

    @Override
    public void refreshSupplementReason(SupplementReason reason) {
        supplementReasonDAO.updateSupplementReason(reason);
    }

    @Override
    public List<SupplementReason> getSupplementReasonByLogisticsCode(
            String logisticsCode) {
        SupplementReason supplementReason = new SupplementReason();
        supplementReason.setLogisticsCode(logisticsCode);
        return supplementReasonDAO.selectList(supplementReason);
    }

    @Override
    public void refreshLogisticsCode(Long id, String loCode) {
        SupplementReason reason = getSupplementReason(id);
        reason.setLogisticsCode(loCode);
        supplementReasonDAO.updateLogisticsCode(reason);
    }
}
