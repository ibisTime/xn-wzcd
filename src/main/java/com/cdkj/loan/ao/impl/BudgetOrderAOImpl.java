package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.exception.BizException;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public String addBudgetOrder(XN632120Req req) {
        BudgetOrder data = new BudgetOrder();
        data.setLoanProductCode(req.getLoanProductCode());
        data.setCreditCode(req.getCreditCode());
        data.setBizType(req.getBizType());
        data.setLoanPeriod(req.getLoanPeriod());
        data.setInvoiceCompany(req.getInvoiceCompany());
        data.setCarBrand(req.getCarBrand());
        data.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        data.setInvoicePrice(StringValidater.toLong(req.getInvoicePrice()));
        data.setCarColor(req.getCarColor());
        data.setMonthDeposit(StringValidater.toLong(req.getMonthDeposit()));
        data.setFirstAmount(StringValidater.toLong(req.getFirstAmount()));
        data.setFirstRate(StringValidater.toDouble(req.getFirstRate()));
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        data.setSettleAddress(req.getSettleAddress());
        data.setApplyUserName(req.getApplyUserName());
        data.setGender(req.getGender());
        data.setMarryState(req.getMarryState());
        data.setNation(req.getNation());
        data.setEducation(req.getEducation());
        data.setIdNo(req.getIdNO());
        data.setFamilyNumber(req.getFamilyNumber());
        data.setMobile(req.getMobile());
        data.setNowAddress(req.getNowAddress());
        data.setPostCode1(req.getPostCode1());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setPostCode2(req.getPostCode2());
        data.setFamilyMainAsset(req.getFamilyMainAsset());
        data.setMainAssetInclude(req.getMainAssetInclude());
        data.setMainIncome(req.getMainIncome());
        data.setWorkCompanyName(req.getWorkCompanyName());
        data.setWorkCompanyAddress(req.getWorkCompanyAddress());
        data.setSelfCompanyArea(req.getSelfCompanyArea());
        data.setEmployeeQuantity(req.getEmployeeQuantity());
        data.setEnterpriseMonthOutput(req.getEnterpriseMonthOutput());
        data.setPosition(req.getPosition());
        data.setPostTitle(req.getPostTitle());
        data.setMonthIncome(req.getMonthIncome());
        data.setMateName(req.getMateName());
        data.setMateMobile(req.getMateMobile());
        data.setMateIdNo(req.getMateIdNo());
        data.setMateEducation(req.getMateEducation());
        data.setMateCompanyAddress(req.getMateCompanyAddress());
        data.setMateCompanyContactNo(req.getMateCompanyContactNo());
        data.setGuaName(req.getGuaName());
        data.setGuaMobile(req.getGuaMobile());
        data.setGuaIdNo(req.getGuaIdNo());
        data.setGuaPhone(req.getGuaPhone());
        data.setGuaCompanyName(req.getGuaCompanyName());
        data.setGuaCompanyAddress(req.getGuaCompanyAddress());
        data.setGuaHouseAssetAddress(req.getGuaHouseAssetAddress());
        data.setEmergencyName1(req.getEmergencyName1());
        data.setEmergencyRelation1(req.getEmergencyRelation1());
        data.setEmergencyMobile1(req.getEmergencyMobile1());
        data.setEmergencyName2(req.getEmergencyName2());
        data.setEmergencyRelation2(req.getEmergencyRelation2());
        data.setEmergencyMobile2(req.getEmergencyMobile2());
        data.setJourDatetimeStart(DateUtil.strToDate(req.getJourDatetimeStart(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setJourDatetimeEnd(DateUtil.strToDate(req.getJourDatetimeEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setJourIncome(StringValidater.toLong(req.getJourIncome()));
        data.setJourExpend(StringValidater.toLong(req.getJourExpend()));
        data.setJourBalance(StringValidater.toLong(req.getJourBalance()));
        data.setJourMonthIncome(
            StringValidater.toLong(req.getJourMonthIncome()));
        data.setJourMonthExpend(
            StringValidater.toLong(req.getJourMonthExpend()));
        data.setJourRemark(req.getJourRemark());
        data.setHouseContract(req.getHouseContract());
        data.setHousePicture(req.getHousePicture());
        data.setIsAdvanceFund(req.getIsAdvanceFund());

        data.setSaleUserId(req.getOperator());
        data.setApplyDatetime(new Date());
        data.setCurNodeCode("");

        EBudgetOrderNode node = EBudgetOrderNode.START_NODE;
        data.setCurNodeCode(node.getCode());
        if (EButtonCode.SEND.getCode().equals(req.getDealType())) {
            node = EBudgetOrderNode.getMap()
                .get(nodeFlowBO.getNodeFlowByCurrentNode(
                    EBudgetOrderNode.AREA_AUDIT.getCode()));
            data.setCurNodeCode(EBudgetOrderNode.AREA_AUDIT.getCode());
        }

        String code = budgetOrderBO.saveBudgetOrder(data);
        // 日志记录
        sysBizLogBO.saveSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
            node.getCode(), node.getValue(), req.getOperator());
        return code;
    }

    @Override
    public void riskApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.AREA_AUDIT.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(EBudgetOrderNode.AREA_AUDIT.getCode())
                .getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(EBudgetOrderNode.AREA_AUDIT.getCode())
                .getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void editBudgetOrder(BudgetOrder data) {
        budgetOrderBO.refreshBudgetOrder(data);
    }

    @Override
    public int dropBudgetOrder(String code) {
        return budgetOrderBO.removeBudgetOrder(code);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition) {
        return budgetOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition) {
        return budgetOrderBO.queryBudgetOrderList(condition);
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        return budgetOrderBO.getBudgetOrder(code);
    }

}
