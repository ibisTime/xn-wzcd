package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.dto.req.XN632152Req;
import com.cdkj.loan.dto.req.XN632153Req;
import com.cdkj.loan.enums.EBizErrorCode;
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
    private IGpsApplyBO gpsApplyBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Override
    @Transactional
    public void sendLogistics(XN632150Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!ELogisticsStatus.TO_SEND.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待发件状态!");
        }

        // 发件
        Logistics logistics = new Logistics();
        logistics.setCode(req.getCode());
        logistics.setSendType(req.getSendType());
        logistics.setLogisticsCompany(req.getLogisticsCompany());
        logistics.setLogisticsCode(req.getLogisticsCode());

        logistics.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        logistics.setSendNote(req.getSendNote());
        logistics.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logisticsBO.sendLogistics(logistics);

        if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.sendGps(data.getBizCode(), logistics.getSendDatetime());
        }
    }

    @Override
    @Transactional
    public void supplementAndSend(XN632153Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!ELogisticsStatus.TO_SEND_AGAIN.getCode()
            .equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是补件待发货状态!");
        }

        // 发件
        data.setSendType(req.getSendType());
        data.setLogisticsCompany(req.getLogisticsCompany());
        data.setLogisticsCode(req.getLogisticsCode());

        data.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setSendNote(req.getSendNote());
        data.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.sendGps(data.getBizCode(), data.getSendDatetime());
        } else if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            int size = data.getSupplementReasonList().size();
            int size2 = req.getSupplementReasonList().size();
            if (size != size2) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "补件原因未补齐，请重新补件！");
            }
        }
        logisticsBO.sendLogistics(data);
    }

    @Override
    @Transactional
    public void receiveLogistics(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待收件状态!");
        }
        logisticsBO.receiveLogistics(code, remark);
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            budgetOrderBO.logicOrder(data.getBizCode(), operator);
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.receiveGps(data.getBizCode());
        } else if (ELogisticsType.REPAY_BIZ.getCode().equals(data.getType())) {
            repayBizBO.refreshBankRecLogic(data.getBizCode(), operator);
        }
    }

    @Override
    public void sendAgainLogistics(XN632152Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待收件状态!");
        }
        logisticsBO.sendAgainLogistics(req);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        Paginable<Logistics> page = logisticsBO.getPaginable(start, limit,
            condition);
        List<Logistics> logisticsList = page.getList();
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return page;
    }

    private void initLogistics(Logistics logistics) {
        if (StringUtils.isNotBlank(logistics.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(logistics.getUserId());
            logistics.setUserName(sysUser.getRealName());
        }
        if (StringUtils.isNotBlank(logistics.getBizCode())) {
            if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())) {
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(logistics.getBizCode());
                logistics.setCustomerName(budgetOrder.getCustomerName());
            }
        }
        SupplementReason domain = new SupplementReason();
        domain.setLogisticsCode(logistics.getCode());
        List<SupplementReason> reasonList = supplementReasonBO
            .querySupplementReasonList(domain);
        if (CollectionUtils.isNotEmpty(reasonList)) {
            logistics.setSupplementReasonList(reasonList);
        }
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        List<Logistics> logisticsList = logisticsBO
            .queryLogisticsList(condition);
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return logisticsList;
    }

    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = logisticsBO.getLogistics(code);
        initLogistics(logistics);

        return logistics;
    }

}
