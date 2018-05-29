package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.enums.ELogisticsStatus;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午11:05:24 
 * @history:
 */

@Service
public class LogisticsAOImpl implements ILogisticsAO {
    @Autowired
    private ILogisticsBO logisticsBO;

    @Override
    public void sendLogistics(XN632150Req req) {
        Logistics data = new Logistics();
        data.setSendFileList(req.getSendFileList());
        data.setSendType(req.getSendType());
        data.setLogisticsCompany(req.getLogisticsCompany());
        data.setLogisticsCode(req.getLogisticsCode());
        data.setSendDatetime(new Date());

        data.setSendNote(req.getSendNote());
        data.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logisticsBO.sendLogistics(data);
    }

    @Override
    public void receiveLogistics(String code, String remark) {
        logisticsBO.receiveLogistics(code, remark);
    }

    @Override
    public void sendAgainLogistics(String code, String remark) {
        logisticsBO.sendAgainLogistics(code, remark);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        return logisticsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Logistics> getLogisticsList(Logistics condition) {
        return logisticsBO.getLogisticsList(condition);
    }

    @Override
    public Logistics getLogistics(String code) {
        return logisticsBO.getLogistics(code);
    }

}
