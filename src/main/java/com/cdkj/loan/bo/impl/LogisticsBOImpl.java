package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
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
    private ISYSUserBO sysUserBO;

    @Override
    public String saveLogistics(String type, String bizCode, String userId,
            String fromNodeCode, String toNodeCode, String refFileList) {
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.LOGISTICS.getCode());
        Logistics data = new Logistics();
        data.setCode(code);
        data.setType(type);
        data.setBizCode(bizCode);
        data.setUserId(userId);
        SYSUser user = sysUserBO.getUser(userId);
        data.setLogisticsCompany(user.getCompanyCode());
        data.setFromNodeCode(fromNodeCode);
        data.setToNodeCode(toNodeCode);
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
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }

        if (!ELogisticsStatus.TO_RECEIVE.getCode()
            .equals(getLogistics(code).getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待收件状态。");
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
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }

        Logistics data = new Logistics();
        data.setCode(code);
        data.setRemark(remark);
        data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
        data.setReceiptDatetime(new Date());
        logisticsDAO.updateLogisticsReceive(data);
    }

    @Override
    public Logistics getLogistics(String code) {
        if (null == code) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }

        Logistics data = new Logistics();
        data.setCode(code);
        return logisticsDAO.select(data);
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        return logisticsDAO.selectList(condition);
    }

}
