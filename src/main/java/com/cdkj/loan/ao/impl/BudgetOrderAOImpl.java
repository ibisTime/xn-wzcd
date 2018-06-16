package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.IInsuranceCompanyBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Autowired
    private IInsuranceCompanyBO insuranceCompanyBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    // @Autowired
    // private IAdvanceFundBO advanceFundBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Override
    @Transactional
    public void addBudgetOrder(XN632120Req req) {

        BudgetOrder data = budgetOrderBO
            .getBudgetOrder(req.getBudgetOrderCode());

        data.setCustomerType(req.getCustomerType());
        data.setCarDealerCode(req.getCarDealerCode());
        data.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        data.setCarModel(req.getCarModel());
        data.setLoanPeriods(req.getLoanPeriods());

        data.setInvoicePrice(StringValidater.toLong(req.getInvoicePrice()));
        data.setRateType(req.getRateType());
        data.setIsSurvey(req.getIsSurvey());
        data.setBankRate(StringValidater.toDouble(req.getBankRate()));
        Long loanAmount = data.getLoanAmount();
        Long invoicePrice = StringValidater.toLong(req.getInvoicePrice());
        data.setCompanyLoanCs((double) (loanAmount / invoicePrice));// 我司贷款成数

        data.setIsAdvanceFund(req.getIsAdvanceFund());
        Long fee = StringValidater.toLong(req.getFee());
        data.setGlobalRate((double) (fee / loanAmount)
                + StringValidater.toDouble(req.getBankRate()));// 综合利率
        data.setFee(StringValidater.toLong(req.getFee()));
        data.setCarDealerSubsidy(
            StringValidater.toDouble(req.getCarDealerSubsidy()));

        data.setBankLoanCs((double) (loanAmount + fee) / invoicePrice);// 银行贷款成数
        data.setApplyUserMonthIncome(
            StringValidater.toLong(req.getApplyUserMonthIncome()));
        data.setApplyUserSettleInterest(
            StringValidater.toLong(req.getApplyUserSettleInterest()));
        data.setApplyUserBalance(
            StringValidater.toLong(req.getApplyUserBalance()));
        data.setApplyUserJourShowIncome(req.getApplyUserJourShowIncome());

        data.setApplyUserIsPrint(req.getApplyUserIsPrint());
        data.setGhMonthIncome(StringValidater.toLong(req.getGhMonthIncome()));
        data.setGhSettleInterest(
            StringValidater.toLong(req.getGhSettleInterest()));
        data.setGhBalance(StringValidater.toLong(req.getGhBalance()));
        data.setGhJourShowIncome(req.getGhJourShowIncome());

        data.setGhIsPrint(req.getGhIsPrint());
        data.setGuarantor1MonthIncome(
            StringValidater.toLong(req.getGuarantor1MonthIncome()));
        data.setGuarantor1SettleInterest(
            StringValidater.toLong(req.getGuarantor1SettleInterest()));
        data.setGuarantor1Balance(
            StringValidater.toLong(req.getGuarantor1Balance()));
        data.setGuarantor1JourShowIncome(req.getGuarantor1JourShowIncome());

        data.setGuarantor1IsPrint(req.getGuarantor1IsPrint());
        data.setGuarantor2MonthIncome(
            StringValidater.toLong(req.getGuarantor2MonthIncome()));
        data.setGuarantor2SettleInterest(
            StringValidater.toLong(req.getGuarantor2SettleInterest()));
        data.setGuarantor2Balance(
            StringValidater.toLong(req.getGuarantor2Balance()));
        data.setGuarantor2JourShowIncome(req.getGuarantor2JourShowIncome());

        data.setGuarantor2IsPrint(req.getGuarantor2IsPrint());
        data.setIsHouseProperty(req.getIsHouseProperty());
        data.setHouseProperty(req.getHouseProperty());
        data.setIsHouseContract(req.getIsHouseContract());
        data.setHouseInvoice(req.getHouseInvoice());

        data.setIsLicense(req.getIsLicense());
        data.setLicense(req.getLicense());
        data.setIsSiteProve(req.getIsSiteProve());
        data.setSiteProve(req.getSiteProve());
        data.setSiteArea(req.getSiteArea());

        data.setCarType(req.getCarType());
        data.setIsDriceLicense(req.getIsDriceLicense());
        data.setDriceLicense(req.getDriceLicense());
        data.setOtherPropertyNote(req.getOtherPropertyNote());
        data.setApplyBirthAddress(req.getApplyBirthAddress());

        data.setApplyNowAddress(req.getApplyNowAddress());
        data.setHouseType(req.getHouseType());
        data.setGhBirthAddress(req.getGhBirthAddress());
        data.setGuarantor1BirthAddress(req.getGuarantor1BirthAddress());
        data.setGuarantor2BirthAddress(req.getGuarantor2BirthAddress());

        data.setOtherNote(req.getOtherNote());
        data.setOilSubsidy(StringValidater.toLong(req.getOilSubsidy()));
        data.setOilSubsidyKil(StringValidater.toDouble(req.getOilSubsidyKil()));
        data.setIsPlatInsure(req.getIsPlatInsure());
        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));

        data.setGpsDeduct(StringValidater.toLong(req.getGpsDeduct()));
        data.setGpsFeeWay(req.getGpsFeeWay());
        data.setLyAmount(StringValidater.toLong(req.getLyAmount()));
        data.setFxAmount(StringValidater.toLong(req.getFxAmount()));
        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));

        data.setFeeWay(req.getFeeWay());
        data.setMarryDivorce(req.getMarryDivorce());
        data.setApplyUserHkb(req.getApplyUserHkb());
        data.setBankBillPdf(req.getBankBillPdf());
        data.setSingleProvePdf(req.getSingleProvePdf());

        data.setIncomeProvePdf(req.getIncomeProvePdf());
        data.setLiveProvePdf(req.getLiveProvePdf());
        data.setBuildProvePdf(req.getBuildProvePdf());
        data.setHkbFirstPage(req.getHkbFirstPage());
        data.setHkbMainPage(req.getHkbMainPage());

        data.setGhHkb(req.getGhHkb());
        data.setGuarantor1IdNo(req.getGuarantor1IdNo());
        data.setGuarantor1Hkb(req.getGuarantor1Hkb());
        data.setGuarantor2IdNo(req.getGuarantor2IdNo());
        data.setGuarantor2Hkb(req.getGuarantor2Hkb());

        data.setHousePic(req.getHousePic());
        data.setHouseUnitPic(req.getHouseUnitPic());
        data.setHouseDoorPic(req.getHouseDoorPic());
        data.setHouseRoomPic(req.getHouseRoomPic());
        data.setHouseCustomerPic(req.getHouseCustomerPic());

        data.setHouseSaleCustomerPic(req.getHouseSaleCustomerPic());
        data.setCompanyNamePic(req.getCompanyNamePic());
        data.setCompanyPlacePic(req.getCompanyPlacePic());
        data.setCompanyWorkshopPic(req.getCompanyWorkshopPic());
        data.setCompanySaleCustomerPic(req.getCompanySaleCustomerPic());

        data.setSecondHgz(req.getSecondHgz());
        data.setSecondOdometer(req.getSecondOdometer());
        data.setSecondConsolePic(req.getSecondConsolePic());
        data.setSecond300Pdf(req.getSecond300Pdf());
        data.setSecondQxbPic(req.getSecondQxbPic());

        data.setSecondCarInPic(req.getSecondCarInPic());
        data.setSecondNumber(req.getSecondNumber());
        data.setOtherFilePdf(req.getOtherFilePdf());
        data.setOtherApplyNote(req.getOtherApplyNote());
        data.setApplyDatetime(new Date());

        String preNodeCode = data.getCurNodeCode();
        if (EButtonCode.SEND.getCode().equals(req.getDealType())) {
            EBudgetOrderNode node = EBudgetOrderNode.getMap().get(nodeFlowBO
                .getNodeFlowByCurrentNode(data.getCurNodeCode()).getNextNode());
            data.setCurNodeCode(node.getCode());

            // 日志记录
            sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
                EBizLogType.BUDGET_ORDER, data.getCode(), preNodeCode,
                node.getCode(), node.getValue(), req.getOperator());
        }

        // 使用gps更新列表
        for (String gpsCode : req.getGpsList()) {
            Gps dataGps = new Gps();
            dataGps.setCode(gpsCode);
            // gpsBO.refreshUseGps(dataGps);
        }

        // // 更新征信人员信息
        // for (XN632120ReqIncome reqIncome : req.getCreditUserIncomeList()) {
        // CreditUser creditUser = new CreditUser();
        // String code = OrderNoGenerater
        // .generate(EGeneratePrefix.CREDITUSER.getCode());
        // creditUser.setCode(code);
        // creditUser.setMonthIncome(
        // StringValidater.toLong(reqIncome.getMonthIncome()));
        // creditUser.setSettleInterest(
        // StringValidater.toDouble(reqIncome.getSettleInterest()));
        // creditUser
        // .setBalance(StringValidater.toLong(reqIncome.getBalance()));
        //
        // creditUser.setJourShowIncome(reqIncome.getJourShowIncome());
        // creditUser.setJourShowIncome(reqIncome.getJourShowIncome());
        // creditUser.setIsPrint(reqIncome.getIsPrint());
        // creditUserBO.refreshCreditUserIncome(creditUser);
        // }

        budgetOrderBO.refresh(data);
    }

    @Override
    public void approveAreaManager(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.AREA_AUDIT.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是区域总经理准入审核节点，不能操作");
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
        budgetOrderBO.refreshAreaManagerApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void approveBranchCompany(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.COMPANY_AUDIT.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是省分公司总经理审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder
                .setCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(
                        EBudgetOrderNode.COMPANY_AUDIT.getCode())
                    .getNextNode());
        } else {
            budgetOrder
                .setCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(
                        EBudgetOrderNode.COMPANY_AUDIT.getCode())
                    .getBackNode());
        }
        budgetOrderBO.refreshBranchCompanyApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void approveGlobalManager(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.SECOND_AUDIT.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是二审节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            // 审核通过 判断是总公司业务还是分公司业务
            Department department = departmentBO
                .getDepartment(budgetOrder.getCompanyCode());

            if ("".equals(department.getParentCode())
                    && null == department.getParentCode()) {
                // 总公司业务
                budgetOrder
                    .setCurNodeCode(EAdvanceFundNode.PARENT_CONFIRM.getCode());

            } else if (!"".equals(department.getParentCode())
                    && null != department.getParentCode()) {
                // 分公司的业务
                budgetOrder
                    .setCurNodeCode(EAdvanceFundNode.BRANCH_CONFIRM.getCode());
            }
        } else {
            budgetOrder
                .setCurNodeCode(
                    nodeFlowBO
                        .getNodeFlowByCurrentNode(
                            EBudgetOrderNode.SECOND_AUDIT.getCode())
                        .getBackNode());
        }
        budgetOrderBO.refreshGlobalManagerApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void canceOrder(String code, String operator, String cancelNote) {

    }

    @Override
    @Transactional
    public void refreshBankLoanCommit(String code, Date bankCommitDatetime,
            String bankCommitNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.BANK_LOAN_COMMIT.getCode()
            .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.SEND_BANK_MATERIALS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.BRANCH_PENDING_PARTS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.HEADQUARTERS_PENDING_PARTS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_SEND_BANK_MATERIALS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_BRANCH_PENDING_PARTS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_HEADQUARTERS_PENDING_PARTS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_FEN_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.FEN_CAR_SEND_LOGISTICS.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.HEADQUARTERS_CAR_SEND_BANK_MATERIALS
                    .getCode().equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.HEADQUARTERS_SEND_CONTRACT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.FEN_CAR_BRANCH_PENDING_PARTS.getCode()
                    .equals(budgetOrder.getCurNodeCode())) {
            // &&
            // !EBudgetOrderNode.HEADQUARTERS_CAR_PENDING_PARTS.getCode().equals(budgetOrder.getCurNodeCode())
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是发件节点，不能操作");
        }

        String nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
            EBoolean.YES.getCode());

        BudgetOrder data = new BudgetOrder();
        data.setCurNodeCode(nextNodeCode);
        data.setCode(code);
        data.setBankCommitDatetime(bankCommitDatetime);
        data.setBankCommitNote(bankCommitNote);
        data.setOperator(operator);
        data.setOperateDatetime(new Date());
        budgetOrderBO.refreshBankLoanCommit(data);

        // 生成资料传递
        NodeFlow nodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
        logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
            budgetOrder.getCode(), budgetOrder.getSaleUserId(),
            budgetOrder.getCurNodeCode(), nextNodeCode, nodeFlow.getFileList());

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void refreshBankLoanConfirm(XN632141Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.CONFIRM_RECEIVABLES.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是银行放款确认提交节点，不能操作");
        }

        String nextNodeCode = null;
        Department department = departmentBO
            .getDepartment(budgetOrder.getCompanyCode());
        String parentCode = department.getParentCode();
        if (parentCode == null) {
            nextNodeCode = EBudgetOrderNode.CAR_BANK_LOAN_COMMIT.getCode();
        }
        nextNodeCode = EBudgetOrderNode.CAR_FEN_BANK_LOAN_COMMIT.getCode();

        BudgetOrder data = new BudgetOrder();
        data.setCurNodeCode(nextNodeCode);
        data.setCode(req.getCode());
        data.setBankFkAmount(StringValidater.toLong(req.getBankFkAmount()));
        data.setBankFkDatetime(DateUtil.strToDate(req.getBankFkDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setBankReceiptCode(req.getBankReceiptCode());

        data.setBankReceiptNumber(req.getBankReceiptNumber());
        data.setBankReceiptPdf(req.getBankReceiptPdf());
        data.setBankReceiptNote(req.getBankReceiptNote());
        data.setOperator(req.getOperator());
        data.setOperateDatetime(new Date());
        budgetOrderBO.refreshBankLoanConfirm(data);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void refreshCarPledgeCommit(String code, Date pledgeCommitDatetime,
            String pledgeCommitNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.CAR_BANK_LOAN_COMMIT.getCode()
            .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_FEN_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是银行放款确认提交节点，不能操作");
        }

        String nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
            EBoolean.YES.getCode());

        BudgetOrder data = new BudgetOrder();
        data.setCurNodeCode(nextNodeCode);
        data.setCode(code);
        data.setPledgeCommitDatetime(pledgeCommitDatetime);
        data.setPledgeCommitNote(pledgeCommitNote);
        data.setOperator(operator);
        data.setOperateDatetime(new Date());
        budgetOrderBO.refreshCarPledgeCommit(data);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void refreshCarPledgeConfirm(String code, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.CAR_PLEDGE_CONFIRM.getCode()
            .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_FEN_PLEDGE_CONFIRM.getCode()
                    .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是抵押完成节点，不能操作");
        }

        String nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
            EBoolean.YES.getCode());

        BudgetOrder data = new BudgetOrder();
        data.setCurNodeCode(nextNodeCode);
        data.setCode(code);
        data.setOperator(operator);
        data.setOperateDatetime(new Date());
        budgetOrderBO.refreshCarPledgeConfirm(data);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void refreshCarLoanArchive(XN632200Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // if (!EBudgetOrderNode.PENDING_FILE.getCode().equals(
        // budgetOrder.getCurNodeCode())) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "当前节点不是待入档节点，不能操作");
        // }

        if (EBoolean.YES.getCode().equals(req.getIsComplete())
                && null == req.getStorePlace()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "存放位置不能为空！");
        }

        if (null != req.getContactMobile()) {
            PhoneUtil.checkMobile(req.getContactMobile());
        }
        if (null != req.getGuarantorMobile()) {
            PhoneUtil.checkMobile(req.getGuarantorMobile());
        }

        // 获取下一个节点
        String nextNodeCode = budgetOrder.getCurNodeCode();
        if (EBoolean.YES.getCode().equals(req.getIsComplete())) {
            nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
                EBoolean.YES.getCode());
        }

        BudgetOrder data = new BudgetOrder();
        data.setCurNodeCode(nextNodeCode);
        data.setCode(req.getCode());
        data.setInsuranceCompanyCode(req.getInsuranceCompanyCode());
        data.setCarColor(req.getCarColor());
        data.setCarBrand(req.getCarBrand());

        data.setFrameNo(req.getFrameNo());
        data.setEngineNo(req.getEngineNo());
        data.setForceInsurance(StringValidater.toLong(req.getForceInsurance()));
        data.setCommerceInsurance(req.getCommerceInsurance());
        data.setInsuranceEffectDatetime(
            DateUtil.strToDate(req.getInsuranceEffectDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setInsuranceBank(req.getInsuranceBank());
        data.setSaleUserId(req.getSaleUserId());
        data.setGuaranteeContractCode(req.getGuaranteeContractCode());
        data.setRegCertificateCode(req.getRegCertificateCode());
        data.setOtherContact(req.getOtherContact());

        data.setContactMobile(req.getContactMobile());
        data.setGuarantorName(req.getGuarantorName());
        data.setGuarantorMobile(req.getGuarantorMobile());
        data.setBankCardNumber(req.getBankCardNumber());
        data.setBillDatetime(DateUtil.strToDate(req.getBillDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setIdNoPic(req.getIdNoPic());
        data.setIsComplete(req.getIsComplete());
        data.setStorePlace(req.getStorePlace());
        data.setFileRemark(req.getFileRemark());

        data.setOperator(req.getOperator());
        data.setOperateDatetime(new Date());
        data.setOperateDepartment(req.getOperateDepartment());

        if (null != req.getFileList()) {
            StringBuilder fileListBuilder = new StringBuilder();
            for (String file : req.getFileList()) {
                fileListBuilder.append(file).append(",");
            }
            data.setFileList(fileListBuilder.toString());
        }

        budgetOrderBO.refreshCarLoanArchive(data);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void installGps(String code, String operator,
            List<XN632126ReqGps> gpsAzList) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();

        // 删除
        budgetOrderGpsBO.removeBudgetOrderGpsList(code);
        // 添加
        budgetOrderGpsBO.saveBudgetOrderGpsList(code, gpsAzList);

        // 下个节点设置
        // budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
        // EBudgetOrderNode.GPSAZ.getCode()).getNextNode());
        // budgetOrderBO.installGps(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    // 获取下一个节点
    public String getNextNodeCode(String curNodeCode, String approveResult) {
        NodeFlow nodeFolw = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        String nextNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFolw.getNextNode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = nodeFolw.getBackNode();
        }
        return nextNodeCode;
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition) {
        Paginable<BudgetOrder> page = budgetOrderBO.getPaginable(start, limit,
            condition);
        List<BudgetOrder> list = page.getList();
        for (BudgetOrder budgetOrder : list) {
            initBudget(budgetOrder);
        }
        return page;
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition) {
        List<BudgetOrder> list = budgetOrderBO.queryBudgetOrderList(condition);

        for (BudgetOrder budgetOrder : list) {
            initBudget(budgetOrder);
        }

        return list;
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        initBudget(budgetOrder);
        return budgetOrder;
    }

    private void initBudget(BudgetOrder budgetOrder) {
        String file = budgetOrder.getFileList();
        if (StringUtils.isNotBlank(file)) {
            String[] fileArray = file.split(",");
            List<String> fileList = new ArrayList<String>();
            for (String data : fileArray) {
                fileList.add(data);
            }
            budgetOrder.setFileListArray(fileList);
        }
        Bank receiptBank = bankBO.getBank(budgetOrder.getBankReceiptCode());
        if (null != receiptBank) {
            budgetOrder.setBankReceiptName(receiptBank.getBankName());
        }

        CarDealer carDealer = carDealerBO
            .getCarDealer(budgetOrder.getCarDealerCode());
        if (null != carDealer) {
            budgetOrder.setCarDealerName(carDealer.getFullName());
        }

        InsuranceCompany insuranceCompany = insuranceCompanyBO
            .getInsuranceCompany(budgetOrder.getInsuranceCompanyCode());
        if (null != insuranceCompany) {
            budgetOrder.setInsuranceCompanyName(insuranceCompany.getName());
        }

        Bank loanBank = bankBO.getBank(budgetOrder.getBankReceiptCode());
        if (null != loanBank) {
            budgetOrder.setLoanBankName(loanBank.getBankName());
        }

        Department department = departmentBO
            .getDepartment(budgetOrder.getOperateDepartment());
        if (null != department) {
            budgetOrder.setOperateDepartmentName(department.getName());
        }

        SYSUser user = sysUserBO.getUser(budgetOrder.getOperator());
        if (null != user) {
            budgetOrder.setOperatorName(user.getRealName());
        }

        SYSUser saleUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        if (null != saleUser) {
            budgetOrder.setSaleUserName(saleUser.getRealName());
        }
    }

    @Override
    public Object queryBudgetOrderPageByRoleCode(int start, int limit,
            BudgetOrder condition) {

        return budgetOrderBO.getPaginableByRoleCode(start, limit, condition);
    }

    @Override
    public void refreshCardMaking(String code, String bankCardNumber,
            String makeCardRemark) {
        BudgetOrder condition = budgetOrderBO.getBudgetOrder(code);
        condition.setBankCardNumber(bankCardNumber);
        condition.setMakeCardRemark(makeCardRemark);
        budgetOrderBO.refreshCardMaking(condition);
    }
}
