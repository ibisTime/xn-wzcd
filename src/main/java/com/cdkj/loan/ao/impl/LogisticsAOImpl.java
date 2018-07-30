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
import com.cdkj.loan.bo.IDepartmentBO;
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
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
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
import com.cdkj.loan.enums.ERepayBizNode;
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

    @Autowired
    private IDepartmentBO departmentBO;

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
                String fromNodeCode = data.getFromNodeCode();
                String string = fromNodeCode.substring(0, 3);
                data.setStatus(ELogisticsStatus.RECEIVED.getCode());// 普通物流改为待审核
                // 无需审核，直接到下一节点
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(data.getBizCode());
                String pledgeCurNodeCode = budgetOrder.getPledgeCurNodeCode();// 车辆抵押节点
                if (string.equals("007")) {
                    // 银行放款
                    // 当前节点
                    String curNodeCode = budgetOrder.getCurNodeCode();
                    NodeFlow nodeFlow = nodeFlowBO
                        .getNodeFlowByCurrentNode(curNodeCode);
                    NodeFlow nodeFlow2 = nodeFlowBO
                        .getNodeFlowByCurrentNode(nodeFlow.getNextNode());
                    if (EBudgetOrderNode.HEADQUARTERS_SEND_PRINT.getCode()
                        .equals(budgetOrder.getCurNodeCode())) {
                        Logistics logistics = logisticsBO.getLogistics(code);
                        if (StringUtils
                            .isNotBlank(logistics.getIsBankPointPartSupt())
                                && EBoolean.YES.getCode().equals(
                                    logistics.getIsBankPointPartSupt())) {
                            // 如果是补件，跳过打印岗
                            budgetOrder.setCurNodeCode(nodeFlow2.getNextNode());
                        } else {
                            // 走正常流程
                            budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
                        }
                        budgetOrderBO.updateCurNodeCode(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 准入单改回不在物流传递中
                        budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                        budgetOrderBO.updateIsLogistics(budgetOrder);

                        Department department = departmentBO
                            .getDepartment(budgetOrder.getCompanyCode());// 获取公司
                        if ("温州市".equals(department.getCityNo())
                                && EBudgetOrderNode.LOAN_PRINT.getCode()
                                    .equals(data.getToNodeCode())) {
                            // 当前主流程节点如果是银行放款流程 007_02 总公司寄送银行材料给打印岗
                            // 收件审核并通过后 抵押流程本地开始（主流程外的）
                            // 设置抵押流程节点为车辆抵押本地第一步008_01打印岗打印
                            budgetOrder.setPledgeCurNodeCode(
                                EBudgetOrderNode.LOCAL_PRINTPOST_PRINT
                                    .getCode());
                            budgetOrderBO.collateAchieve(budgetOrder);
                        }
                    }
                    if (EBudgetOrderNode.LOAN_PRINT.getCode()
                        .equals(curNodeCode)) {
                        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
                        budgetOrderBO.updateCurNodeCode(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 准入单改回不在物流传递中
                        budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                        budgetOrderBO.updateIsLogistics(budgetOrder);
                    }
                    List<SupplementReason> supplementReason = supplementReasonBO
                        .getSupplementReasonByLogisticsCode(code);
                    if (EBudgetOrderNode.BANK_LOAN_COLLATEPOST_COLLATE.getCode()
                        .equals(curNodeCode)) {
                        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
                        budgetOrderBO.updateCurNodeCode(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 获取当前节点的下一个节点
                        // 生成资料传递
                        NodeFlow nodeFlowNext = nodeFlowBO
                            .getNodeFlowByCurrentNode(
                                budgetOrder.getCurNodeCode());
                        String loCode = logisticsBO.saveLogistics(
                            ELogisticsType.BUDGET.getCode(),
                            budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                            nodeFlowNext.getCurrentNode(),
                            nodeFlowNext.getNextNode());

                        // 传递补件原因
                        if (CollectionUtils.isNotEmpty(supplementReason)) {
                            Logistics logistics = logisticsBO
                                .getLogistics(loCode);
                            logistics.setFromNodeCode(
                                EBudgetOrderNode.HEADQUARTERS_SEND_PRINT
                                    .getCode());
                            logistics.setToNodeCode(
                                EBudgetOrderNode.BANK_LOAN_COLLATEPOST_COLLATE
                                    .getCode());
                            for (SupplementReason reason : supplementReason) {
                                supplementReasonBO.refreshLogisticsCode(
                                    reason.getId(), loCode);
                            }
                        }
                    }
                } else {
                    // 车辆抵押
                    NodeFlow pledgeNodeFlow = nodeFlowBO
                        .getNodeFlowByCurrentNode(pledgeCurNodeCode);
                    if (EBudgetOrderNode.LOCAL_PRINTPOST_PRINT.getCode()
                        .equals(pledgeCurNodeCode)) {
                        budgetOrder
                            .setPledgeCurNodeCode(pledgeNodeFlow.getNextNode());
                        budgetOrderBO.collateAchieve(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 准入单改回不在物流传递中
                        budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                        budgetOrderBO.updateIsLogistics(budgetOrder);
                    }
                    if (EBudgetOrderNode.OUT_COLLATEPOST_COLLATE.getCode()
                        .equals(pledgeCurNodeCode)) {
                        budgetOrder
                            .setPledgeCurNodeCode(pledgeNodeFlow.getNextNode());
                        budgetOrderBO.collateAchieve(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 生成资料传递
                        NodeFlow nodeFlowNext = nodeFlowBO
                            .getNodeFlowByCurrentNode(
                                budgetOrder.getPledgeCurNodeCode());
                        logisticsBO.saveLogistics(
                            ELogisticsType.BUDGET.getCode(),
                            budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                            budgetOrder.getPledgeCurNodeCode(),
                            nodeFlowNext.getNextNode());
                    }
                    if (EBudgetOrderNode.LOCAL_COLLATEPOST_COLLATE.getCode()
                        .equals(pledgeCurNodeCode)) {
                        budgetOrder
                            .setPledgeCurNodeCode(pledgeNodeFlow.getNextNode());
                        budgetOrderBO.collateAchieve(budgetOrder);
                        data.setStatus(
                            ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                        // 生成资料传递
                        NodeFlow nodeFlowNext = nodeFlowBO
                            .getNodeFlowByCurrentNode(
                                budgetOrder.getPledgeCurNodeCode());
                        logisticsBO.saveLogistics(
                            ELogisticsType.BUDGET.getCode(),
                            budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                            budgetOrder.getPledgeCurNodeCode(),
                            nodeFlowNext.getNextNode());
                    }
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
                data.setStatus(ELogisticsStatus.RECEIVED.getCode());// 普通物流改为待审核
                RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getBizCode());
                // 如果是打印岗理件岗寄件刚，无需审核，直接收件
                if (!ERepayBizNode.BANK_REC_LOGIC.getCode()
                    .equals(repayBiz.getCurNodeCode())) {
                    data.setStatus(
                        ELogisticsStatus.RECEIVED_NOT_AUDITE.getCode());
                    // 还款业务改回不在物流传递中
                    repayBiz.setIsLogistics(EBoolean.NO.getCode());
                    repayBizBO.updateIsLogistics(repayBiz);
                    // 如果是理件岗，再产生一条物流单
                    if (!ERepayBizNode.PHYSICAL_PARTS.getCode()
                        .equals(repayBiz.getCurNodeCode())) {
                        // 生成资料传递
                        NodeFlow nodeFlowNext = nodeFlowBO
                            .getNodeFlowByCurrentNode(
                                repayBiz.getCurNodeCode());
                        // 取下下个节点
                        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(
                            nodeFlowNext.getNextNode());
                        logisticsBO.saveLogistics(
                            ELogisticsType.REPAY_BIZ.getCode(),
                            repayBiz.getCode(), repayBiz.getUserId(),
                            nodeFlowNext.getNextNode(), nodeFlow.getNextNode());
                        // 还款业务改回在物流传递中
                        repayBiz.setIsLogistics(EBoolean.YES.getCode());
                        repayBizBO.updateIsLogistics(repayBiz);
                    }
                    repayBizBO.refreshBankRecLogic(data.getBizCode(), operator);
                }
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
        } else if (ELogisticsType.REPAY_BIZ.getCode().equals(data.getType())) {
            repayBizBO.logicOrder(data.getBizCode(), operator, remark);
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
            if (!ELogisticsStatus.RECEIVED.getCode().equals(data.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是收件待审核状态!");
            }
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
