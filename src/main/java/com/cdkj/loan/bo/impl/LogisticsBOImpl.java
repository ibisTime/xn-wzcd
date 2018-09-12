package com.cdkj.loan.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632152Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ERepayBizNode;
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

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Override
    public String saveLogistics(String type, String bizCode, String userId,
            String fromNodeCode, String toNodeCode) {
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
        data.setStatus(ELogisticsStatus.TO_SEND.getCode());
        logisticsDAO.insert(data);
        // 日志
        sysBizLogBO.saveSYSBizLog(bizCode, EBizLogType.LOGISTICS,
            data.getCode(), ELogisticsStatus.TO_SEND.getCode());
        return code;
    }

    @Override
    public String saveLogisticsToSupplement(String type, String bizCode,
            String userId, String fromNodeCode, String toNodeCode) {
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
        data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
        logisticsDAO.insert(data);
        return code;
    }

    @Override
    public void sendLogistics(Logistics data) {
        logisticsDAO.updateLogisticsSend(data);
    }

    @Override
    public void receiveLogistics(Logistics data) {
        logisticsDAO.updateLogisticsReceive(data);
    }

    @Override
    public void backPieceLogistics(Logistics data) {
        logisticsDAO.updateLogisticsBackPiece(data);
    }

    @Override
    public void auditePassLogistics(String code, String remark) {
        if (null == code) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }
        Logistics condition = new Logistics();
        condition.setCode(code);
        condition.setRemark(remark);
        condition.setStatus(ELogisticsStatus.AUDITE_PASS.getCode());
        logisticsDAO.updateLogisticsAudite(condition);
    }

    @Override
    @Transactional
    public void sendAgainLogistics(XN632152Req req, String code) {
        if (null == code) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写编号");
        }
        Logistics data = getLogistics(code);
        data.setSupplementNote(req.getSupplementNote());
        data.setRemark(req.getRemark());

        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
            // 补件原因
            ArrayList<Long> list = new ArrayList<Long>();
            List<SupplementReason> reasonList = req.getSupplementReasonList();
            for (SupplementReason reason : reasonList) {
                SupplementReason supplementReason = new SupplementReason();
                supplementReason.setLogisticsCode(code);
                supplementReason.setType(reason.getType());
                supplementReason.setReason(reason.getReason());
                supplementReason.setFromNodeCode(data.getFromNodeCode());
                supplementReason.setToNodeCode(data.getToNodeCode());
                supplementReason.setStatus(EBoolean.NO.getCode());
                supplementReason.setCreateDatetime(new Date());
                Long id = supplementReasonBO
                    .saveSupplementReason(supplementReason);
                list.add(id);
            }
            // 判断节点是否是007_05，是的话补件返回007_01
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(data.getBizCode());
            String preCurrentNode = budgetOrder.getCurNodeCode();
            if (EBudgetOrderNode.SEND_BANK_MATERIALS.getCode()
                .equals(budgetOrder.getCurNodeCode())) {
                Department company = departmentBO
                    .getDepartment(budgetOrder.getCompanyCode());
                if ("温州市".equals(company.getCityNo())) {
                    // 本地
                    budgetOrder.setCurNodeCode(
                        EBudgetOrderNode.SALESMAN_SEND_LOGISTICS.getCode());
                    // 改变发收节点
                    data.setFromNodeCode(
                        EBudgetOrderNode.SALESMAN_SEND_LOGISTICS.getCode());
                    data.setToNodeCode(
                        EBudgetOrderNode.HEADQUARTERS_SEND_PRINT.getCode());
                    data.setIsBankPointPartSupt(EBoolean.YES.getCode());
                } else {
                    // 外地
                    budgetOrder.setCurNodeCode(
                        EBudgetOrderNode.BRANCH_SEND_LOGISTICS.getCode());
                    // 改变发收节点
                    data.setFromNodeCode(
                        EBudgetOrderNode.BRANCH_SEND_LOGISTICS.getCode());
                    data.setToNodeCode(
                        EBudgetOrderNode.HEADQUARTERS_SEND_PRINT.getCode());
                    data.setIsBankPointPartSupt(EBoolean.YES.getCode());
                }
                budgetOrder.setReasonId(list);
                budgetOrderBO.updateCurNodeCodeAndReasonId(budgetOrder);
            }

            String pledgeCurrentNode = budgetOrder.getPledgeCurNodeCode();
            // 判断节点是否是008_03，是的话补件返回008_01
            if (EBudgetOrderNode.LOCAL_SENDPOST_SEND_BANK.getCode()
                .equals(pledgeCurrentNode)) {
                budgetOrder.setPledgeCurNodeCode(
                    EBudgetOrderNode.LOCAL_PRINTPOST_PRINT.getCode());
                budgetOrderBO.collateAchieve(budgetOrder);
                // 是否在资料传递中改成否
                budgetOrder.setIsLogistics(EBoolean.NO.getCode());
                budgetOrderBO.updateIsLogistics(budgetOrder);
                // 改变发收节点
                data.setFromNodeCode(
                    EBudgetOrderNode.LOCAL_PRINTPOST_PRINT.getCode());
                data.setToNodeCode(
                    EBudgetOrderNode.LOCAL_COLLATEPOST_COLLATE.getCode());
                data.setIsBankPointPartSupt(EBoolean.YES.getCode());
            }
            // 判断节点是否是009_08，是的话补件返回009_05
            if (EBudgetOrderNode.OUT_SENDPOST_SEND_BANK.getCode()
                .equals(pledgeCurrentNode)) {
                budgetOrder.setPledgeCurNodeCode(
                    EBudgetOrderNode.OUT_BRANCH_SEND_PARENT.getCode());
                budgetOrderBO.collateAchieve(budgetOrder);
                // 改变发收节点
                data.setFromNodeCode(
                    EBudgetOrderNode.OUT_BRANCH_SEND_PARENT.getCode());
                data.setToNodeCode(
                    EBudgetOrderNode.HEADQUARTERS_INTERNAL_SEND.getCode());
            }
            // 日志记录
            EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
                .get(budgetOrder.getCurNodeCode());
            sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                currentNode.getCode(), req.getRemark(), req.getOperator());
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            // gps补件原因
            data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
            data.setSupplementReason(req.getSupplementReason());
        } else {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getBizCode());
            if (ERepayBizNode.BANK_REC_LOGIC.getCode()
                .equals(repayBiz.getCurNodeCode())) {
                repayBiz.setCurNodeCode(ERepayBizNode.MORTGAGE_PRINT.getCode());
                repayBizBO.updateCurNodeCode(repayBiz);
                // 补件原因
                List<SupplementReason> reasonList = req
                    .getSupplementReasonList();
                for (SupplementReason reason : reasonList) {
                    SupplementReason supplementReason = new SupplementReason();
                    supplementReason.setLogisticsCode(code);
                    supplementReason.setType(reason.getType());
                    supplementReason.setReason(reason.getReason());
                    supplementReasonBO.saveSupplementReason(supplementReason);
                }
                data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
                data.setFromNodeCode(ERepayBizNode.MORTGAGE_PRINT.getCode());
                data.setToNodeCode(ERepayBizNode.PHYSICAL_PARTS.getCode());
            }
            // 产生物流单后改变状态为不在物流传递中
            repayBiz.setIsLogistics(EBoolean.NO.getCode());
            repayBizBO.updateIsLogistics(repayBiz);
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

    @Override
    public void updateLogistics(Logistics condition) {
        logisticsDAO.updateLogistics(condition);
    }

    @Override
    public Logistics getLogisticsByCommitBank(Logistics condition) {
        return logisticsDAO.selectLogisticsByCommitBank(condition);
    }

}
