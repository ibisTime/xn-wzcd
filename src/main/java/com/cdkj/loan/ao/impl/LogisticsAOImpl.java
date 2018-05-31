package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

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

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IGpsBO gpsBO;

    @Override
    public void sendLogistics(XN632150Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!(ELogisticsStatus.TO_SEND.getCode().equals(data.getStatus()) || ELogisticsStatus.TO_SEND_AGAIN
            .getCode().equals(data.getStatus()))) {
            throw new BizException("xn0000", "资料不是待发货状态!");
        }

        Logistics logistics = new Logistics();
        logistics.setCode(req.getCode());
        logistics.setSendFileList(req.getSendFileList());
        logistics.setSendType(req.getSendType());
        logistics.setLogisticsCompany(req.getLogisticsCompany());
        logistics.setLogisticsCode(req.getLogisticsCode());

        logistics.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        logistics.setSendNote(req.getSendNote());
        logistics.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logisticsBO.sendLogistics(logistics);
    }

    @Override
    @Transactional
    public void receiveLogistics(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }
        logisticsBO.receiveLogistics(code, remark);
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            budgetOrderBO.logicOrder(data.getBizCode(), operator);
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsBO.applyLqGps(data.getBizCode());
        }
    }

    @Override
    public void sendAgainLogistics(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }
        logisticsBO.sendAgainLogistics(code, remark);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        Paginable<Logistics> page = logisticsBO.getPaginable(start, limit,
            condition);
        List<Logistics> logisticsList = page.getList();
        for (Logistics logistics : logisticsList) {
            User user = userBO.getUser(logistics.getUserId());
            if (user != null) {
                logistics.setUserName(user.getRealName());
            }
        }
        return page;
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        List<Logistics> logisticsList = logisticsBO
            .queryLogisticsList(condition);
        for (Logistics logistics : logisticsList) {
            User user = userBO.getUser(logistics.getUserId());
            if (user != null) {
                logistics.setUserName(user.getRealName());
            }
        }
        return logisticsList;
    }

    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = logisticsBO.getLogistics(code);
        User user = userBO.getUser(logistics.getUserId());
        if (user != null) {
            logistics.setUserName(user.getRealName());
        }

        return logistics;
    }
}
