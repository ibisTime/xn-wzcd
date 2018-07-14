package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632130Req;

@Service
public class SupplementReasonAOImpl implements ISupplementReasonAO {

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Override
    public Long addSupplementReason(XN632130Req req) {
        SupplementReason data = new SupplementReason();
        data.setLogisticsCode(req.getLogisticsCode());
        data.setType(req.getType());
        data.setReason(req.getReason());
        return supplementReasonBO.saveSupplementReason(data);
    }

    @Override
    public Paginable<SupplementReason> querySupplementReasonPage(int start,
            int limit, SupplementReason condition) {
        return supplementReasonBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SupplementReason> querySupplementReasonList(
            SupplementReason condition) {
        return supplementReasonBO.querySupplementReasonList(condition);
    }

    @Override
    public SupplementReason getSupplementReason(Long id) {
        return supplementReasonBO.getSupplementReason(id);
    }
}
