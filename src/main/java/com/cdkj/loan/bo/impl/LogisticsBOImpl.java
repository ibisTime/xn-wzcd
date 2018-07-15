package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632152Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:40:49 
 * @history:
 */

@Component
public class LogisticsBOImpl extends PaginableBOImpl<Logistics> implements
        ILogisticsBO {
    @Autowired
    private ILogisticsDAO logisticsDAO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Override
    public String saveLogistics(String type, String bizCode, String userId,
            String fromNodeCode, String toNodeCode) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.LOGISTICS
            .getCode());
        Logistics data = new Logistics();
        data.setCode(code);
        data.setType(type);
        data.setBizCode(bizCode);
        data.setUserId(userId);
        SYSUser user = sysUserBO.getUser(userId);
        data.setLogisticsCompany(user.getCompanyCode());
        data.setFromNodeCode(fromNodeCode);
        data.setToNodeCode(toNodeCode);
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
        Logistics condition = new Logistics();
        condition.setCode(code);
        condition.setRemark(remark);
        condition.setReceiptDatetime(new Date());
        condition.setStatus(ELogisticsStatus.RECEIVED.getCode());
        logisticsDAO.updateLogisticsReceive(condition);
    }

    @Override
    @Transactional
    public void sendAgainLogistics(XN632152Req req) {
        if (null == req.getCode()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }
        Logistics data = getLogistics(req.getCode());
        data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
        data.setSupplementNote(req.getSupplementNote());
        data.setReceiptDatetime(new Date());
        data.setRemark(req.getRemark());

        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            // 补件原因
            List<SupplementReason> reasonList = req.getSupplementReasonList();
            for (SupplementReason reason : reasonList) {
                SupplementReason supplementReason = new SupplementReason();
                supplementReason.setLogisticsCode(reason.getLogisticsCode());
                supplementReason.setType(reason.getType());
                supplementReason.setReason(reason.getReason());
                supplementReasonBO.saveSupplementReason(supplementReason);
            }
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            // gps补件原因
            data.setSupplementReason(req.getSupplementReason());
        }
        logisticsDAO.updateLogisticsSendAgain(data);
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
