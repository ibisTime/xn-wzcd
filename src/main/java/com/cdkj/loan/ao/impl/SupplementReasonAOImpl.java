package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.enums.EBoolean;

@Service
public class SupplementReasonAOImpl implements ISupplementReasonAO {

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Override
    public Long addSupplementReason(XN632130Req req) {
        SupplementReason data = new SupplementReason();
        data.setLogisticsCode(req.getLogisticsCode());
        data.setType(req.getType());
        data.setReason(req.getReason());
        data.setIsPartSupt(EBoolean.NO.getCode());
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

    @Override
    public List<SupplementReason> querySupplementReason(
            SupplementReason condition, String logisticsCode) {
        ArrayList<SupplementReason> arrayList = new ArrayList<SupplementReason>();
        Logistics data = logisticsBO.getLogistics(logisticsCode);
        Logistics domain = new Logistics();
        domain.setBizCode(data.getBizCode());
        List<Logistics> logisticsList = logisticsBO.queryLogisticsList(domain);
        for (Logistics logistics : logisticsList) {
            condition.setLogisticsCode(logistics.getCode());
            List<SupplementReason> reasonList = supplementReasonBO
                .querySupplementReasonList(condition);
            arrayList.addAll(reasonList);
        }
        return arrayList;
    }
}
