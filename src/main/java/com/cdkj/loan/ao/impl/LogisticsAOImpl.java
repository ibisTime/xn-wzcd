package com.cdkj.loan.ao.impl;

import java.util.Date;
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
import com.cdkj.loan.bo.ISYSBizLogBO;
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
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ESupplementReasonType;
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

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    @Transactional
    public void sendLogistics(XN632150Req req) {
        for (String code : req.getCodeList()) {
            Logistics data = logisticsBO.getLogistics(code);
            if (!ELogisticsStatus.TO_SEND.getCode().equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待发件状态!");
            }

            // 发件
            data.setSendType(req.getSendType());
            data.setLogisticsCompany(req.getLogisticsCompany());
            data.setLogisticsCode(req.getLogisticsCode());

            data.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
                DateUtil.DATA_TIME_PATTERN_1));
            data.setSendNote(req.getSendNote());
            data.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
            logisticsBO.sendLogistics(data);

            if (ELogisticsType.GPS.getCode().equals(data.getType())) {
                gpsApplyBO.sendGps(data.getBizCode(), data.getSendDatetime());
            }
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
            DateUtil.DATA_TIME_PATTERN_1));
        data.setSendNote(req.getSendNote());
        data.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.sendGps(data.getBizCode(), data.getSendDatetime());
        } else if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            // 判断紧急的补件原因是否补全
            SupplementReason supplementReason = new SupplementReason();
            supplementReason.setLogisticsCode(req.getCode());
            supplementReason.setType(ESupplementReasonType.URGENT.getCode());
            List<SupplementReason> reasonList = supplementReasonBO
                .querySupplementReasonList(supplementReason);
            int size = reasonList.size();// 要补件的紧急的补件条数
            int sizeJJ = 0;// 补件时紧急的补件条数
            int sizeBJJ = 0;// 补件时不紧急的补件条数
            for (SupplementReason reqSR : req.getSupplementReasonList()) {
                if (ESupplementReasonType.URGENT.getCode()
                    .equals(reqSR.getType())) {
                    sizeJJ++;
                } else {
                    sizeBJJ++;
                }
                // 已补件的原因改为已补件
                SupplementReason reason = supplementReasonBO
                    .getSupplementReason(reqSR.getId());
                reason.setIsPartSupt(EBoolean.YES.getCode());
                supplementReasonBO.refreshSupplementReason(reason);
            }
            if (size != sizeJJ) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "紧急类型的补件原因未补齐，请重新补件！");
            }
            supplementReason.setType(ESupplementReasonType.URGENT.getCode());
            List<SupplementReason> list = supplementReasonBO
                .querySupplementReasonList(supplementReason);
            int size2 = list.size();// 要补件的不紧急的补件条数
            // 不紧急的补件原因不全时
            if (size2 != sizeBJJ) {
                // 产生物流单
                logisticsBO.saveLogisticsToSupplement(data.getType(),
                    data.getBizCode(), data.getUserId(), data.getFromNodeCode(),
                    data.getToNodeCode());
            }
        }
        logisticsBO.sendLogistics(data);
    }

    @Override
    @Transactional
    public void receiveLogistics(List<String> list, String operator,
            String remark) {
        for (String code : list) {
            Logistics data = logisticsBO.getLogistics(code);
            if (!ELogisticsStatus.TO_RECEIVE.getCode()
                .equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待收件状态!");
            }
            data.setStatus(ELogisticsStatus.RECEIVED.getCode());
            data.setReceiptDatetime(new Date());
            data.setRemark(remark);
            logisticsBO.receiveLogistics(data);

            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(data.getBizCode());
            // 日志记录 主流程
            EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
                .get(budgetOrder.getCurNodeCode());
            sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(),
                budgetOrder.getCurNodeCode(), currentNode.getCode(),
                currentNode.getValue(), operator);
        }
    }

    @Override
    @Transactional
    public void auditePassLogistics(String code, String operator,
            String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待审核状态!");
        }
        logisticsBO.auditePassLogistics(code, remark);
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            budgetOrderBO.logicOrder(data.getBizCode(), operator);
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.receiveGps(data.getBizCode());
        } else if (ELogisticsType.REPAY_BIZ.getCode().equals(data.getType())) {
            repayBizBO.refreshBankRecLogic(data.getBizCode(), operator);
        }
    }

    @Override
    public void backPiece(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待审核状态!");
        }
        data.setStatus(ELogisticsStatus.RECEIVED.getCode());
        data.setRemark(remark);
        logisticsBO.backPieceLogistics(data);

        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrder(data.getBizCode());
        // 日志记录 主流程
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(),
            budgetOrder.getCurNodeCode(), currentNode.getCode(),
            currentNode.getValue(), operator);
    }

    @Override
    public void sendAgainLogistics(XN632152Req req) {
        Logistics data = logisticsBO.getLogistics(req.getCode());
        if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是收件待审核状态!");
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
