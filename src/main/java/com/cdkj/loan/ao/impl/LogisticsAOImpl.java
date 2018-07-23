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
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.NodeFlow;
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
        List<String> codeList = req.getCodeList();
        for (String code : codeList) {
            Logistics data = logisticsBO.getLogistics(code);
            if (!ELogisticsStatus.TO_SEND.getCode().equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "业务编号" + data.getBizCode() + "的资料不是待发件状态!");
            }
        }
        for (String code : codeList) {
            // 发件
            Logistics logistics = logisticsBO.getLogistics(code);
            logistics.setCode(code);
            logistics.setSendType(req.getSendType());
            logistics.setLogisticsCompany(req.getLogisticsCompany());
            logistics.setLogisticsCode(req.getLogisticsCode());
            logistics.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
            logistics.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
                DateUtil.DATA_TIME_PATTERN_1));
            logistics.setSendNote(req.getSendNote());
            logisticsBO.sendLogistics(logistics);
            if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
                gpsApplyBO.sendGps(logistics.getBizCode(),
                    logistics.getSendDatetime());
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
                "资料不是补件待发件状态!");
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
            // 判断补件原因是否补全
            SupplementReason supplementReason = new SupplementReason();
            supplementReason.setLogisticsCode(req.getCode());
            List<SupplementReason> reasonList = supplementReasonBO
                .querySupplementReasonList(supplementReason);
            int size = reasonList.size();// 要补件的条数
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
    public void receiveLogistics(List<String> list, String operator,
            String remark) {
        for (String code : list) {
            Logistics data = logisticsBO.getLogistics(code);
            if (!ELogisticsStatus.TO_RECEIVE.getCode()
                .equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待收件状态!");
            }
            data.setReceiptDatetime(new Date());
            data.setRemark(remark);

            // 预算单
            if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
                data.setStatus(ELogisticsStatus.RECEIVED.getCode());// 普通物流改为待审核
                // 无需审核，直接到下一节点
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(data.getBizCode());
                // 银行放款
                // 当前节点
                String curNodeCode = budgetOrder.getCurNodeCode();
                NodeFlow nodeFlow = nodeFlowBO
                    .getNodeFlowByCurrentNode(curNodeCode);
                if (EBudgetOrderNode.LOAN_PRINT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                        || EBudgetOrderNode.BANK_LOAN_COLLATEPOST_COLLATE
                            .getCode().equals(budgetOrder.getCurNodeCode())) {
                    budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
                    budgetOrderBO.updateCurNodeCode(budgetOrder);
                    data.setStatus(
                        ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                    // 准入单改回不在物流传递中
                    budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                    budgetOrderBO.updateIsLogistics(budgetOrder);
                }
                // 车辆抵押
                String pledgeCurNodeCode = budgetOrder.getPledgeCurNodeCode();
                NodeFlow pledgeNodeFlow = nodeFlowBO
                    .getNodeFlowByCurrentNode(pledgeCurNodeCode);
                if (EBudgetOrderNode.LOCAL_PRINTPOST_PRINT.getCode()
                    .equals(budgetOrder.getPledgeCurNodeCode())
                        || EBudgetOrderNode.LOCAL_COLLATEPOST_COLLATE.getCode()
                            .equals(budgetOrder.getPledgeCurNodeCode())
                        || EBudgetOrderNode.OUT_COLLATEPOST_COLLATE.getCode()
                            .equals(budgetOrder.getPledgeCurNodeCode())) {
                    budgetOrder
                        .setPledgeCurNodeCode(pledgeNodeFlow.getNextNode());
                    budgetOrderBO.collateAchieve(budgetOrder);
                    data.setStatus(
                        ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                    // 准入单改回不在物流传递中
                    budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                    budgetOrderBO.updateIsLogistics(budgetOrder);
                }

                // 日志记录 主流程
                EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
                    .get(budgetOrder.getCurNodeCode());
                sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                    EBizLogType.BUDGET_ORDER, budgetOrder.getCode(),
                    budgetOrder.getCurNodeCode(), currentNode.getCode(),
                    currentNode.getValue(), operator);

            } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
                data.setStatus(ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());// gps物流改为已收件
                gpsApplyBO.receiveGps(data.getBizCode());
            } else if (ELogisticsType.REPAY_BIZ.getCode()
                .equals(data.getType())) {
                repayBizBO.refreshBankRecLogic(data.getBizCode(), operator);
            }
            logisticsBO.receiveLogistics(data);
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
            budgetOrderBO.logicOrder(data.getBizCode(), code, operator);
        }
    }

    @Override
    public void backPiece(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待审核状态!");
        }
        data.setStatus(ELogisticsStatus.BACK_PIECE.getCode());
        data.setRemark(remark);
        logisticsBO.backPieceLogistics(data);

        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrder(data.getBizCode());
        budgetOrder.setCurNodeCode(EBudgetOrderNode.CANCEL_APPLY_END.getCode());
        budgetOrderBO.updateCurNodeCode(budgetOrder);
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
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是收件待审核状态!");
            }
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            if (!ELogisticsStatus.TO_RECEIVE.getCode()
                .equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待收件状态!");
            }
        } else if (ELogisticsType.REPAY_BIZ.getCode().equals(data.getType())) {
            repayBizBO.refreshBankRecLogic(data.getBizCode(),
                req.getOperater());
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
