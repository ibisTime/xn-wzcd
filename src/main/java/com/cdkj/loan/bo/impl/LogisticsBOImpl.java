package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:40:49 
 * @history:
 */

@Component
public class LogisticsBOImpl extends PaginableBOImpl<Logistics>
        implements ILogisticsBO {
    @Autowired
    private ILogisticsDAO logisticsDAO;

    @Autowired
    private IBudgetOrderAO budgetOrderAO;

    @Autowired
    private IUserAO userAO;

    @Override
    public String saveLogistics(String type, String bizCode, String userId,
            String bizNodeCode, String refFileList) {
        if (StringUtils.isBlank(type) || StringUtils.isBlank(bizCode)
                || StringUtils.isBlank(userId)
                || StringUtils.isBlank(bizNodeCode)
                || StringUtils.isBlank(refFileList)) {
            throw new BizException("xn0000", "请填写必填项。");
        }

        // 判断预算单和用户是否存在
        if (null == budgetOrderAO.getBudgetOrder(bizCode)) {
            throw new BizException("xn0000", "业务编号不存在");
        }
        if (null == userAO.getUser(userId)) {
            throw new BizException("xn0000", "用户不存在");
        }

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.LOGISTICS.getCode());
        Logistics data = new Logistics();
        data.setCode(code);
        data.setType(type);
        data.setBizCode(bizCode);
        data.setUserId(userId);
        data.setBizNodeCode(bizNodeCode);

        data.setRefFileList(refFileList);
        data.setStatus(ELogisticsStatus.TO_SEND.getCode());
        logisticsDAO.insert(data);
        return code;
    }

    @Override
    public void sendLogistics(Logistics data) {
        logisticsDAO.updateLogisticsSend(data);
    }

    @Override
    public void receiveLogistics(String code, String remark) {
        if (null == code) {
            throw new BizException("xn0000", "请填写编号");
        }

        if (!ELogisticsStatus.TO_RECEIVE.getCode()
            .equals(getLogistics(code).getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态。");
        }

        Logistics condition = new Logistics();
        condition.setCode(code);
        condition.setRemark(remark);
        condition.setReceiptDatetime(new Date());
        condition.setStatus(ELogisticsStatus.RECEIVED.getCode());
        logisticsDAO.updateLogisticsReceive(condition);
    }

    @Override
    public void sendAgainLogistics(String code, String remark) {
        if (null == code) {
            throw new BizException("xn0000", "请填写编号");
        }

        Logistics data = new Logistics();
        data.setCode(code);
        data.setRemark(remark);
        data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
        logisticsDAO.updateLogisticsReceive(data);
    }

    @Override
    public void dropLogistics(String code) {
        Logistics data = new Logistics();
        data.setCode(code);
        logisticsDAO.delete(data);
    }

    @Override
    public Logistics getLogistics(String code) {
        if (null == code) {
            throw new BizException("xn0000", "请填写编号");
        }

        Logistics data = new Logistics();
        data.setCode(code);
        return logisticsDAO.select(data);
    }

    @Override
    public List<Logistics> getLogisticsList(Logistics condition) {
        return logisticsDAO.selectList(condition);
    }

}
