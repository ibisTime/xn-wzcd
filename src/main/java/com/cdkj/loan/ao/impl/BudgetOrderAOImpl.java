package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.enums.EApproveResult;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

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
        return budgetOrderBO.saveBudgetOrder(data);
    }

    @Override
    public String audit(String code, String approveResult, String approveNote,
            String operator) {
        if (EApproveResult.PASS.getCode().equals(approveResult)) {

        }
        return null;
    }

    @Override
    public int editBudgetOrder(BudgetOrder data) {
        return budgetOrderBO.refreshBudgetOrder(data);
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
