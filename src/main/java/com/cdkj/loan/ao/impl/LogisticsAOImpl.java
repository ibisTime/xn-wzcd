package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.enums.ELogisticsStatus;
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

    @Override
    public void sendLogistics(XN632150Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!(ELogisticsStatus.TO_SEND.getCode().equals(data.getStatus())
                || ELogisticsStatus.TO_SEND_AGAIN.getCode()
                    .equals(data.getStatus()))) {
            throw new BizException("xn0000", "资料不是待发货状态。");
        }

        Logistics condition = new Logistics();
        condition.setCode(req.getCode());
        condition.setSendFileList(req.getSendFileList());
        condition.setSendType(req.getSendType());
        condition.setLogisticsCompany(req.getLogisticsCompany());
        condition.setLogisticsCode(req.getLogisticsCode());

        condition.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setSendNote(req.getSendNote());
        condition.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logisticsBO.sendLogistics(condition);
    }

    @Override
    public void receiveLogistics(String code, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态。");
        }
        logisticsBO.receiveLogistics(code, remark);
    }

    @Override
    public void sendAgainLogistics(String code, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态。");
        }
        logisticsBO.sendAgainLogistics(code, remark);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        Paginable<Logistics> page = logisticsBO.getPaginable(start, limit,
            condition);
        List<Logistics> logisticsList = page.getList();
        User user = null;
        Node node = null;

        for (Logistics logistics : logisticsList) {
            user = userBO.getUser(logistics.getUserId());
            if (user != null) {
                logistics.setUserName(user.getRealName());
            }

            node = nodeBO.getNode(logistics.getBizNodeCode());
            if (node != null && node.getName() != null) {
                logistics.setNodeName(node.getName());
            }
        }
        return page;
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        List<Logistics> logisticsList = logisticsBO.getLogisticsList(condition);
        User user = null;
        Node node = null;

        for (Logistics logistics : logisticsList) {
            user = userBO.getUser(logistics.getUserId());
            if (user != null) {
                logistics.setUserName(user.getRealName());
            }

            node = nodeBO.getNode(logistics.getBizNodeCode());
            if (node != null && node.getName() != null) {
                logistics.setNodeName(node.getName());
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

        Node node = nodeBO.getNode(logistics.getBizNodeCode());
        if (node != null && node.getName() != null) {
            logistics.setNodeName(node.getName());
        }

        return logistics;
    }
}
