package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.IInsuranceCompanyBO;
import com.cdkj.loan.bo.ILoanCsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.domain.LoanCs;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632120ReqRepointDetail;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.dto.req.XN632220Req;
import com.cdkj.loan.dto.req.XN632270Req;
import com.cdkj.loan.dto.req.XN632271Req;
import com.cdkj.loan.dto.req.XN632272Req;
import com.cdkj.loan.dto.req.XN632280Req;
import com.cdkj.loan.dto.req.XN632341Req;
import com.cdkj.loan.dto.res.XN632291Res;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EAdvanceType;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBankType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetFrozenStatus;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EButtonCode;
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EFbhStatus;
import com.cdkj.loan.enums.EIsAdvanceFund;
import com.cdkj.loan.enums.ELoanPeriod;
import com.cdkj.loan.enums.ELoanRole;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.EMakeCardStatus;
import com.cdkj.loan.enums.ERateType;
import com.cdkj.loan.enums.ERepointDetailStatus;
import com.cdkj.loan.enums.ERepointDetailUseMoneyPurpose;
import com.cdkj.loan.enums.EUseMoneyPurpose;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.exception.BizException;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

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
    private IGpsBO gpsBO;

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IAdvanceFundBO advanceFundBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private ICarDealerProtocolBO carDealerProtocolBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private ILoanCsBO loanCsBO;

    @Override
    @Transactional
    public void editBudgetOrder(XN632120Req req) {
        BudgetOrder data = budgetOrderBO
            .getBudgetOrder(req.getBudgetOrderCode());
        if (!EBudgetOrderNode.START_NODE.getCode().equals(data.getCurNodeCode())
                && !EBudgetOrderNode.FILL_AGAIN.getCode()
                    .equals(data.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前预算单节点不能修改");
        }

        data.setApplyUserCompany(req.getApplyUserCompany());
        data.setApplyUserDuty(req.getApplyUserDuty());
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
        data.setCompanyLoanCs(AmountUtil.div(loanAmount, invoicePrice));// 我司贷款成数

        data.setIsAdvanceFund(req.getIsAdvanceFund());
        Long fee = StringValidater.toLong(req.getFee());
        data.setFee(fee);
        double feeRate = AmountUtil.div(fee, loanAmount);
        data.setGlobalRate(
            feeRate + StringValidater.toDouble(req.getBankRate()));// 综合利率
        data.setCarDealerSubsidy(
            StringValidater.toLong(req.getCarDealerSubsidy()));

        Long totalAmount = loanAmount + fee;// 总费用 贷款总额
        data.setBankLoanCs(AmountUtil.div(totalAmount, invoicePrice));// 银行贷款成数
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

        // 根据协议计算出各种手续费
        XN632291Res xn632291Res = carDealerProtocolBO
            .calProtocolFee(data.getCode(), data.getCarDealerCode());
        data.setGpsFee(StringValidater.toLong(xn632291Res.getGpsFee()));
        data.setGpsDeduct(StringValidater.toDouble((req.getGpsDeduct())));
        data.setGpsFeeWay(req.getGpsFeeWay());

        data.setLyAmount(StringValidater.toLong(xn632291Res.getLyAmount()));
        data.setFxAmount(StringValidater.toLong(xn632291Res.getFxAmount()));
        data.setOtherFee(StringValidater.toLong(xn632291Res.getOtherFee()));
        data.setServiceChargeWay(req.getFeeWay());

        Long serviceCharge = StringValidater.toLong(xn632291Res.getLyAmount())
                + StringValidater.toLong(xn632291Res.getFxAmount())
                + StringValidater.toLong(xn632291Res.getGpsFee())
                + StringValidater.toLong(xn632291Res.getOtherFee());
        // 收客户手续费合计：履约保证金+担保风险金+GPS收费+杂费
        data.setServiceCharge(serviceCharge);

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

        List<XN632120ReqRepointDetail> list = req.getRepointDetailList();
        for (XN632120ReqRepointDetail req1 : list) {
            // 生成返点明细数据(用款用途)
            RepointDetail data1 = new RepointDetail();
            if (EUseMoneyPurpose.MORTGAGE.getCode().equals(// 应退按揭款
                req1.getUseMoneyPurpose())) {
                data1.setCompanyCode(req1.getCompanyCode());
                data1.setUseMoneyPurpose(EUseMoneyPurpose.MORTGAGE.getCode());
            } else if (EUseMoneyPurpose.PROTOCOL_INNER.getCode()
                .equals(req1.getUseMoneyPurpose())) {// 协议内
                data1.setCarDealerCode(req1.getCarDealerCode());
                data1.setUseMoneyPurpose(
                    EUseMoneyPurpose.PROTOCOL_INNER.getCode());
            } else if (EUseMoneyPurpose.MORTGAGE.getCode()
                .equals(req1.getUseMoneyPurpose())
                    && EIsAdvanceFund.NO.getCode()
                        .equals(data.getIsAdvanceFund())) {// 应退按揭款 不垫资
                data1.setMortgageAccountNo(req1.getMortgageAccountNo());
                data1.setUseMoneyPurpose(
                    EUseMoneyPurpose.PROTOCOL_INNER.getCode());
            } else if (EUseMoneyPurpose.PROTOCOL_OUTER.getCode()
                .equals(req1.getUseMoneyPurpose())) {
                data1.setUseMoneyPurpose(
                    EUseMoneyPurpose.PROTOCOL_OUTER.getCode());
            }

            data1.setBudgetCode(data.getCode());
            data1.setUserName(data.getCustomerName());
            CreditUser user = creditUserBO.getCreditUserByCreditCode(
                data.getCreditCode(), ELoanRole.APPLY_USER);
            data1.setIdNo(user.getIdNo());
            data1.setCarType(data.getCarType());
            data1.setLoanAmount(data.getLoanAmount());
            data1.setBankRate(data.getBankRate());
            if (StringUtils.isNotBlank(req1.getProtocolId())) {
                CarDealerProtocol condition = new CarDealerProtocol();
                condition.setCarDealerCode(data.getCarDealerCode());
                CarDealerProtocol protocol = carDealerProtocolBO
                    .getCarDealerProtocol(
                        Integer.valueOf(req1.getProtocolId()));

                if (ELoanPeriod.ONE_YEAER.getCode()
                    .equals(data.getLoanPeriods())) {

                    if (ERateType.CT.getCode().equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatCtRate12());
                    } else if (ERateType.ZT.getCode()
                        .equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatZkRate12());
                    }

                } else if (ELoanPeriod.TWO_YEAR.getCode()
                    .equals(data.getLoanPeriods())) {

                    if (ERateType.CT.getCode().equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatCtRate24());
                    } else if (ERateType.ZT.getCode()
                        .equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatZkRate24());
                    }

                } else if (ELoanPeriod.THREE_YEAR.getCode()
                    .equals(data.getLoanPeriods())) {

                    if (ERateType.CT.getCode().equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatCtRate36());
                    } else if (ERateType.ZT.getCode()
                        .equals(data.getRateType())) {
                        data1.setBenchmarkRate(protocol.getPlatZkRate36());
                    }
                }
            }
            data1.setFee(fee);
            data1.setRepointAmount(
                StringValidater.toLong(req1.getRepointAmount()));
            data1.setAccountCode(req1.getAccountCode());
            data1.setCurNodeCode(ERepointDetailStatus.TODO_MAKE_BILL.getCode());

            repointDetailBO.saveRepointDetail(data1);
        }

        // 删除
        budgetOrderGpsBO.removeBudgetOrderGpsList(data.getCode());
        // 添加
        budgetOrderGpsBO.saveBudgetOrderGpsList(data.getCode(),
            req.getGpsList());

        budgetOrderBO.refresh(data);
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
            // 产生手续费
            budgetOrderFeeBO.saveBudgetOrderFee(budgetOrder, operator);

            // 预算单节点改为垫资审核
            budgetOrder
                .setCurNodeCode(EBudgetOrderNode.ADVANCE_FUND_AUDIT.getCode());
            // 判断是否预算单是否垫资
            if (EIsAdvanceFund.NO.getCode()
                .equals(budgetOrder.getIsAdvanceFund())) {

                // 不垫资 进入银行放款流程第一步
                // 更改节点为银行放款流程第一步
                budgetOrder
                    .setCurNodeCode(EBudgetOrderNode.SEND_LOGISTICS.getCode());
                sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                    EBizLogType.BANK_LOAN_COMMIT, budgetOrder.getCode(),
                    EBudgetOrderNode.SEND_LOGISTICS.getCode(),
                    EBudgetOrderNode.SEND_LOGISTICS.getValue(), operator);
                budgetOrderBO.bankLoanConfirmSubmitBank(budgetOrder);

                // 当前节点
                String curNodeCode = budgetOrder.getCurNodeCode();
                String nextNodeCode = nodeFlowBO
                    .getNodeFlowByCurrentNode(curNodeCode).getNextNode();

                // 生成资料传递
                NodeFlow nodeFlow = nodeFlowBO
                    .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
                logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                    budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                    curNodeCode, nextNodeCode, nodeFlow.getFileList());
            }
            if (EIsAdvanceFund.YES.getCode()
                .equals(budgetOrder.getIsAdvanceFund())) {
                // 垫资 预算单节点改为垫资审核
                // 生成垫资单判断是总公司业务还是分公司业务
                budgetOrder.setCurNodeCode(
                    EBudgetOrderNode.ADVANCE_FUND_AUDIT.getCode());
                Department department = departmentBO
                    .getDepartment(budgetOrder.getCompanyCode());
                if (EBoolean.NO.getCode().equals(department.getParentCode())) {
                    // 总公司业务 打款给汽车经销商
                    AdvanceFund data = new AdvanceFund();
                    data.setBudgetCode(budgetOrder.getCode());
                    data.setType(EAdvanceType.PARENT_BIZ.getCode());
                    data.setCustomerName(budgetOrder.getCustomerName());
                    data.setCompanyCode(budgetOrder.getCompanyCode());
                    data.setCarDealerCode(budgetOrder.getCarDealerCode());
                    RepointDetail repointDetail = new RepointDetail();
                    repointDetail.setBudgetCode(budgetOrder.getCode());
                    repointDetail.setUseMoneyPurpose(
                        EUseMoneyPurpose.MORTGAGE.getCode());
                    List<RepointDetail> RepointDetailList = repointDetailBO
                        .queryRepointDetailList(repointDetail);
                    RepointDetail mortgage = RepointDetailList.get(0);
                    data.setUseAmount(mortgage.getRepointAmount());// 应退按揭款来自用款用途的应退按揭款
                    data.setLoanAmount(budgetOrder.getLoanAmount());
                    data.setServiceCharge(budgetOrder.getServiceCharge());
                    data.setServiceChargeWay(budgetOrder.getServiceChargeWay());
                    data.setGpsFee(budgetOrder.getGpsFee());
                    data.setGpsFeeWay(budgetOrder.getGpsFeeWay());
                    data.setLoanBankCode(budgetOrder.getLoanBankCode());
                    data.setIsAdvanceFund(budgetOrder.getIsAdvanceFund());
                    CollectBankcard condition = new CollectBankcard();
                    condition.setCompanyCode(budgetOrder.getCarDealerCode());
                    List<CollectBankcard> list = collectBankcardBO
                        .queryCollectBankcardList(condition);
                    String collectBankcardCode = null;
                    for (CollectBankcard collectBankcard : list) {
                        if (ECollectBankcardType.DEALER_COLLECT.getCode()
                            .equals(collectBankcard.getType())) {
                            // 经销商的收款账号
                            collectBankcardCode = collectBankcard.getCode();
                        }
                    }
                    // 汽车经销商的账号
                    data.setCollectBankcardCode(collectBankcardCode);
                    data.setUpdater(operator);
                    data.setUpdateDatetime(new Date());
                    data.setCurNodeCode(
                        EAdvanceFundNode.PARENT_CONFIRM.getCode());

                    String advanceFundCode = advanceFundBO
                        .saveAdvanceFund(data);

                    sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                        EBizLogType.ADVANCE_FUND_PARENT, advanceFundCode,
                        EAdvanceFundNode.PARENT_CONFIRM.getCode(),
                        EAdvanceFundNode.PARENT_CONFIRM.getValue(), operator);

                } else {
                    // 分公司的业务 打款给分公司
                    AdvanceFund data = new AdvanceFund();
                    data.setBudgetCode(budgetOrder.getCode());
                    data.setType(EAdvanceType.BRANCH_BIZ.getCode());
                    data.setCustomerName(budgetOrder.getCustomerName());
                    data.setCompanyCode(budgetOrder.getCompanyCode());
                    data.setCarDealerCode(budgetOrder.getCarDealerCode());
                    // 用款应该是预算单的应退按揭款 现在暂时用贷款金额 用款用途做完后换成用款用途的应退按揭款
                    data.setUseAmount(budgetOrder.getLoanAmount());
                    data.setLoanAmount(budgetOrder.getLoanAmount());
                    data.setServiceCharge(budgetOrder.getServiceCharge());
                    data.setServiceChargeWay(budgetOrder.getServiceChargeWay());
                    data.setGpsFee(budgetOrder.getGpsFee());
                    data.setGpsFeeWay(budgetOrder.getGpsFeeWay());
                    data.setLoanBankCode(budgetOrder.getLoanBankCode());
                    data.setIsAdvanceFund(budgetOrder.getIsAdvanceFund());
                    CollectBankcard condition = new CollectBankcard();
                    condition.setCompanyCode(budgetOrder.getCompanyCode());
                    List<CollectBankcard> list = collectBankcardBO
                        .queryCollectBankcardList(condition);
                    String collectBankcardCode = null;
                    for (CollectBankcard collectBankcard : list) {
                        if (ECollectBankcardType.PLATFORM.getCode()
                            .equals(collectBankcard.getType())) {
                            // 公司普通账户
                            collectBankcardCode = collectBankcard.getCode();
                        }
                    }
                    // 分公司的账号
                    data.setCollectBankcardCode(collectBankcardCode);
                    data.setUpdater(operator);
                    data.setUpdateDatetime(new Date());
                    data.setCurNodeCode(
                        EAdvanceFundNode.BRANCH_CONFIRM.getCode());

                    String advanceFundCode = advanceFundBO
                        .saveAdvanceFund(data);

                    sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                        EBizLogType.ADVANCE_FUND_BRANCH, advanceFundCode,
                        EAdvanceFundNode.BRANCH_CONFIRM.getCode(),
                        EAdvanceFundNode.BRANCH_CONFIRM.getValue(), operator);

                }
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
    @Transactional
    public void canceOrder(String code, String operator, String cancelNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(EBudgetOrderNode.START_NODE.getCode());
        budgetOrderBO.canceOrder(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void bankLoanCommit(String code, Date bankCommitDatetime,
            String bankCommitNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.BANK_LOAN_COMMIT.getCode()
            .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_FEN_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.SEND_BANK_MATERIALS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.BRANCH_PENDING_PARTS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.HEADQUARTERS_PENDING_PARTS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.CAR_SEND_BANK_MATERIALS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.CAR_BRANCH_PENDING_PARTS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.CAR_HEADQUARTERS_PENDING_PARTS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.FEN_CAR_SEND_LOGISTICS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.HEADQUARTERS_CAR_SEND_BANK_MATERIALS
        // .getCode().equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.HEADQUARTERS_SEND_CONTRACT.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        // && !EBudgetOrderNode.FEN_CAR_BRANCH_PENDING_PARTS.getCode()
        // .equals(budgetOrder.getCurNodeCode())
        ) {
            // &&
            // !EBudgetOrderNode.HEADQUARTERS_CAR_PENDING_PARTS.getCode().equals(budgetOrder.getCurNodeCode())
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认提交银行节点，不能操作");
        }

        // 当前节点
        String curNodeCode = budgetOrder.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
            EBoolean.YES.getCode());

        budgetOrder.setCurNodeCode(nextNodeCode);
        budgetOrder.setCode(code);
        budgetOrder.setBankCommitDatetime(bankCommitDatetime);
        budgetOrder.setBankCommitNote(bankCommitNote);
        budgetOrder.setOperator(operator);
        budgetOrder.setOperateDatetime(new Date());
        budgetOrderBO.refreshBankLoanCommit(budgetOrder);

        // 生成资料传递
        // NodeFlow nodeFlow = nodeFlowBO
        // .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
        // logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
        // budgetOrder.getCode(), budgetOrder.getSaleUserId(), curNodeCode,
        // nextNodeCode, nodeFlow.getFileList());

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
    public void bankLoanConfirm(XN632141Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.CONFIRM_RECEIVABLES.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是银行放款节点，不能操作");
        }

        // 当前节点
        String curNodeCode = budgetOrder.getCurNodeCode();

        String nextNodeCode = null;
        Department department = departmentBO
            .getDepartment(budgetOrder.getCompanyCode());
        String parentCode = department.getParentCode();
        Bank bankBySubbranch = bankBO
            .getBankBySubbranch(budgetOrder.getLoanBankCode());
        if (EBoolean.YES.getCode().equals(parentCode) && EBankType.GH.getCode()
            .equals(bankBySubbranch.getBankCode())) {
            nextNodeCode = EBudgetOrderNode.SENDING_CONTRACT.getCode();
        }
        nextNodeCode = EBudgetOrderNode.CAR_SEND_LOGISTICS.getCode();

        budgetOrder.setCurNodeCode(nextNodeCode);
        budgetOrder.setCode(req.getCode());
        budgetOrder
            .setBankFkAmount(StringValidater.toLong(req.getBankFkAmount()));
        budgetOrder.setBankFkDatetime(DateUtil.strToDate(
            req.getBankFkDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setBankReceiptCode(req.getBankReceiptCode());

        budgetOrder.setBankReceiptNumber(req.getBankReceiptNumber());
        budgetOrder.setBankReceiptPdf(req.getBankReceiptPdf());
        budgetOrder.setBankReceiptNote(req.getBankReceiptNote());
        budgetOrder.setOperator(req.getOperator());
        budgetOrder.setOperateDatetime(new Date());

        BankSubbranch data = bankSubbranchBO
            .getBankSubbranch(budgetOrder.getLoanBankCode());
        if ("ICBC" == data.getBankType()) {
            budgetOrder
                .setMakeCardStatus(EMakeCardStatus.PENDING_CARD.getCode());
        } else {
            budgetOrder
                .setMakeCardStatus(EMakeCardStatus.PENDING_RECORD.getCode());
        }
        budgetOrderBO.refreshBankLoanConfirm(budgetOrder);

        // 生成资料传递
        NodeFlow nodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode());
        logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
            budgetOrder.getCode(), budgetOrder.getSaleUserId(), curNodeCode,
            nextNodeCode, nodeFlow.getFileList());

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
    public void carPledgeCommit(String code, Date pledgeCommitDatetime,
            String pledgeCommitNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.CAR_BANK_LOAN_COMMIT.getCode()
            .equals(budgetOrder.getCurNodeCode())
                && !EBudgetOrderNode.CAR_FEN_BANK_LOAN_COMMIT.getCode()
                    .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是银行放款确认提交节点，不能操作");
        }

        // 当前节点
        String curNodeCode = budgetOrder.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(budgetOrder.getCurNodeCode(),
            EBoolean.YES.getCode());

        budgetOrder.setCurNodeCode(nextNodeCode);
        budgetOrder.setCode(code);
        budgetOrder.setPledgeCommitDatetime(pledgeCommitDatetime);
        budgetOrder.setPledgeCommitNote(pledgeCommitNote);
        budgetOrder.setOperator(operator);
        budgetOrder.setOperateDatetime(new Date());
        budgetOrderBO.refreshCarPledgeCommit(budgetOrder);

        // 生成资料传递
        // NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(budgetOrder
        // .getCurNodeCode());
        // logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
        // budgetOrder.getCode(), budgetOrder.getSaleUserId(), curNodeCode,
        // nextNodeCode, nodeFlow.getFileList());

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
    public void carPledgeConfirm(String code, String operator) {
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

        budgetOrder.setCurNodeCode(nextNodeCode);
        budgetOrder.setCode(code);
        budgetOrder.setOperator(operator);
        budgetOrder.setOperateDatetime(new Date());
        SYSUser user = sysUserBO.getUser(operator);
        budgetOrder.setOperateDepartment(user.getDepartmentCode());
        budgetOrderBO.refreshCarPledgeConfirm(budgetOrder);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    // 逻辑
    // 1、前提条件判断
    // 2、没完善可再次补充，完善则入档完成
    // 3、
    @Override
    @Transactional
    public void carLoanArchive(XN632200Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.PENDING_FILE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是待入档节点，不能操作");
        }

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
        budgetOrder.setCurNodeCode(nextNodeCode);
        budgetOrder.setInsuranceCompanyCode(req.getInsuranceCompanyCode());
        budgetOrder.setCarColor(req.getCarColor());
        budgetOrder.setCarBrand(req.getCarBrand());

        budgetOrder.setFrameNo(req.getFrameNo());
        budgetOrder.setEngineNo(req.getEngineNo());
        budgetOrder
            .setForceInsurance(StringValidater.toLong(req.getForceInsurance()));
        budgetOrder.setCommerceInsurance(req.getCommerceInsurance());
        budgetOrder.setInsuranceEffectDatetime(
            DateUtil.strToDate(req.getInsuranceEffectDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder.setInsuranceBank(req.getInsuranceBank());
        budgetOrder.setSaleUserId(req.getSaleUserId());
        budgetOrder.setGuaranteeContractCode(req.getGuaranteeContractCode());
        budgetOrder.setRegCertificateCode(req.getRegCertificateCode());
        budgetOrder.setOtherContact(req.getOtherContact());

        budgetOrder.setContactMobile(req.getContactMobile());
        budgetOrder.setGuarantorName(req.getGuarantorName());
        budgetOrder.setGuarantorMobile(req.getGuarantorMobile());
        budgetOrder.setBankCardNumber(req.getBankCardNumber());
        budgetOrder.setBillDatetime(DateUtil.strToDate(req.getBillDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder
            .setMonthAmount(StringValidater.toLong(req.getRepayMonthAmount()));
        budgetOrder.setRepayBankDate(
            StringValidater.toInteger(req.getRepayBankDate()));
        budgetOrder.setRepayFirstMonthAmount(
            StringValidater.toLong(req.getRepayFirstMonthAmount()));
        budgetOrder.setRepayFirstMonthDatetime(
            DateUtil.strToDate(req.getRepayFirstMonthDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRepayMonthAmount(
            StringValidater.toLong(req.getRepayMonthAmount()));

        budgetOrder.setIdNoPic(req.getIdNoPic());
        budgetOrder.setIsComplete(req.getIsComplete());
        budgetOrder.setStorePlace(req.getStorePlace());
        budgetOrder.setFileRemark(req.getFileRemark());

        budgetOrder.setOperator(req.getOperator());
        budgetOrder.setOperateDatetime(new Date());
        budgetOrder.setOperateDepartment(req.getOperateDepartment());

        if (null != req.getFileList()) {
            StringBuilder fileListBuilder = new StringBuilder();
            for (String file : req.getFileList()) {
                fileListBuilder.append(file).append(",");
            }
            budgetOrder.setFileList(fileListBuilder.toString());
        }

        budgetOrderBO.refreshCarLoanArchive(budgetOrder);

        /****** 生成还款业务 ******/
        // 检查用户是否已经注册过
        User user = userBO.getUser(budgetOrder.getMobile(),
            EUserKind.Customer.getCode());
        String userId = null;
        if (user == null) {
            // 用户代注册并实名认证
            userId = userBO.doRegisterAndIdentify(budgetOrder.getMobile(),
                budgetOrder.getIdKind(), budgetOrder.getCustomerName(),
                budgetOrder.getIdNo());
            distributeAccount(userId, budgetOrder.getMobile(),
                EUserKind.Customer.getCode());
        } else {
            userId = user.getUserId();
        }

        // 绑定用户银行卡
        String bankcardCode = bankcardBO.bind(userId,
            budgetOrder.getCustomerName(), budgetOrder.getBankCardNumber(),
            budgetOrder.getLoanBankCode(), budgetOrder.getLoanBankName(),
            budgetOrder.getLoanBankSubbranch());

        // 自动生成还款业务
        RepayBiz repayBiz = repayBizBO.generateCarLoanRepayBiz(budgetOrder,
            userId, bankcardCode, req.getOperator());

        // 自动生成还款计划
        repayPlanBO.genereateNewRepayPlan(repayBiz);

        // 日志记录
        String preCurrentNode = budgetOrder.getCurNodeCode();
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind) {
        List<String> currencyList = new ArrayList<String>();
        currencyList.add(ECurrency.CNY.getCode());
        currencyList.add(ECurrency.JF.getCode());

        for (String currency : currencyList) {
            accountBO.distributeAccount(userId, mobile,
                EAccountType.getAccountType(kind), currency);
        }
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

        // 获取我司贷款成数区间
        LoanCs loanCsCondition = new LoanCs();
        loanCsCondition.setType(budgetOrder.getShopWay());
        List<LoanCs> loanCsList = loanCsBO.queryLoanCsList(loanCsCondition);
        if (CollectionUtils.isNotEmpty(loanCsList)) {
            LoanCs resultCs = loanCsList.get(0);
            budgetOrder.setCompanyLoanCsSection(
                resultCs.getMinCs() + "-" + resultCs.getMaxCs());
        }
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

        if (StringUtils.isNotBlank(budgetOrder.getBankReceiptCode())) {
            CollectBankcard receiptBank = collectBankcardBO
                .getCollectBankcard(budgetOrder.getBankReceiptCode());
            if (null != receiptBank) {
                budgetOrder.setBankReceiptName(receiptBank.getBankName());
            }
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

        Bank loanBank = bankBO
            .getBankBySubbranch(budgetOrder.getLoanBankCode());
        if (null != loanBank) {
            budgetOrder.setLoanBankName(loanBank.getBankName());
        }

        BankSubbranch subbranch = bankSubbranchBO
            .getBankSubbranch(budgetOrder.getLoanBankCode());
        if (null != subbranch) {
            budgetOrder.setBankSubbranch(subbranch);
        }

        Department department = departmentBO
            .getDepartment(budgetOrder.getOperateDepartment());
        if (null != department) {
            budgetOrder.setOperateDepartmentName(department.getName());
        }

        // 业务公司名称
        if (StringUtils.isNotBlank(budgetOrder.getCompanyCode())) {
            Department company = departmentBO
                .getDepartment(budgetOrder.getCompanyCode());
            budgetOrder.setCompanyName(company.getName());
        }

        SYSUser user = sysUserBO.getUser(budgetOrder.getOperator());
        if (null != user) {
            budgetOrder.setOperatorName(user.getRealName());
        }

        SYSUser saleUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        if (null != saleUser) {
            budgetOrder.setSaleUserName(saleUser.getRealName());
        }
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
            .queryBudgetOrderGpsList(budgetOrder.getCode());
        if (CollectionUtils.isNotEmpty(budgetOrderGpsList)) {
            budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);
        }

        // 获取返点列表
        List<RepointDetail> shouldBackRepointList = repointDetailBO
            .queryRepointDetailList(budgetOrder.getCode(),
                ERepointDetailUseMoneyPurpose.SHOULD_BACK.getCode());
        budgetOrder.setRepointDetailList1(shouldBackRepointList);

        List<RepointDetail> proInRepointList = repointDetailBO
            .queryRepointDetailList(budgetOrder.getCode(),
                ERepointDetailUseMoneyPurpose.PROIN_REPOINT.getCode());
        budgetOrder.setRepointDetailList2(proInRepointList);

        List<RepointDetail> proOutRepointList = repointDetailBO
            .queryRepointDetailList(budgetOrder.getCode(),
                ERepointDetailUseMoneyPurpose.PROOUT_REPOINT.getCode());
        budgetOrder.setRepointDetailList3(proOutRepointList);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition) {
        Paginable<BudgetOrder> page = budgetOrderBO
            .getPaginableByRoleCode(start, limit, condition);
        List<BudgetOrder> list = page.getList();
        for (BudgetOrder budgetOrder : list) {
            initBudget(budgetOrder);
        }
        return page;
    }

    @Override
    @Transactional
    public void approveMakeCard(String code, String makeCardRemark,
            String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EMakeCardStatus.PENDING_CARD.getCode()
            .equals(budgetOrder.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态不是待制卡状态，不能操作！");
        }
        BankSubbranch data = bankSubbranchBO
            .getBankSubbranch(budgetOrder.getLoanBankCode());
        if ("ICBC" != data.getBankType()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "银行行别不是工行，不能操作！");
        }
        budgetOrder
            .setMakeCardStatus(EMakeCardStatus.ALREADY_MADE_CARD.getCode());
        budgetOrder.setMakeCardRemark(makeCardRemark);
        budgetOrder.setMakeCardOperator(operator);
        budgetOrderBO.approveMakeCard(budgetOrder);
    }

    @Override
    @Transactional
    public void cardMaking(String code, String bankCardNumber,
            String makeCardRemark) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EMakeCardStatus.PENDING_RECORD.getCode()
            .equals(budgetOrder.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态不是待回录状态，不能操作！");
        }

        BankSubbranch data = bankSubbranchBO
            .getBankSubbranch(budgetOrder.getLoanBankCode());
        if ("ICBC" == data.getBankType()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "银行行别是工行，不能操作！");
        }
        budgetOrder.setMakeCardStatus(EMakeCardStatus.BACK_RECORD.getCode());
        budgetOrder.setBankCardNumber(bankCardNumber);
        budgetOrder.setMakeCardRemark(makeCardRemark);
        budgetOrderBO.refreshCardMaking(budgetOrder);
    }

    @Override
    @Transactional
    public void entryPreservation(XN632220Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (EBoolean.YES.getCode().equals(budgetOrder.getIsAdvanceFund())) {
            if (!EBudgetOrderNode.ADVANCE_FUND_AUDIT.getCode()
                .equals(budgetOrder.getMakeCardStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是垫资完成节点，不能操作！");
            }
        } else {
            if (!EBudgetOrderNode.CONFIRM_RECEIVABLES.getCode()
                .equals(budgetOrder.getMakeCardStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是银行放款节点，不能操作！");
            }
        }

        budgetOrder.setDeliveryDatetime(DateUtil.strToDate(
            req.getDeliveryDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        Long loanAmount = budgetOrder.getLoanAmount();
        Long currentInvoicePrice = StringValidater
            .toLong(req.getCurrentInvoicePrice());
        double companyLoanCs = AmountUtil.div(loanAmount, currentInvoicePrice);
        budgetOrder.setCompanyLoanCs(companyLoanCs);
        budgetOrder.setIsRightInvoice(EBoolean.NO.getCode());
        if (companyLoanCs >= 0.6 && companyLoanCs <= 0.9) {
            budgetOrder.setIsRightInvoice(EBoolean.YES.getCode());
        }
        budgetOrder.setIsRightInvoice(EBoolean.NO.getCode());
        budgetOrder.setCurrentInvoicePrice(
            StringValidater.toLong(req.getCurrentInvoicePrice()));
        budgetOrder.setInvoice(req.getInvoice());
        budgetOrder.setCertification(req.getCertification());
        budgetOrder
            .setForceInsurance(StringValidater.toLong(req.getForceInsurance()));
        budgetOrder.setBusinessInsurance(
            StringValidater.toLong(req.getBusinessInsurance()));
        budgetOrder.setMotorRegCertification(req.getMotorRegCertification());
        budgetOrder.setPdPdf(req.getPdPdf());
        budgetOrder.setFbhRemark(req.getFbhRemark());
        budgetOrder.setFbhStatus(EFbhStatus.TO_PENDING_ENTRY.getCode());
        budgetOrderBO.entryPreservation(budgetOrder);
    }

    @Override
    @Transactional
    public void invoiceMismatchApply(String code, String loanAmount,
            String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.INVOICE_MISMATCH_APPLY.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是发票不匹配申请节点，不能操作！");
        }
        // 当前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        // 下个节点
        String nextNode = nodeFlowBO
            .getNodeFlowByCurrentNode(
                EBudgetOrderNode.INVOICE_MISMATCH_APPLY.getCode())
            .getNextNode();
        budgetOrder.setPreLoanAmount(budgetOrder.getLoanAmount());
        budgetOrder.setLoanAmount(StringValidater.toLong(loanAmount));
        budgetOrder.setCurNodeCode(nextNode);
        budgetOrderBO.invoiceMismatchApply(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void approveApply(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.APPROVE_APPLY.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder
                .setCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(
                        EBudgetOrderNode.APPROVE_APPLY.getCode())
                    .getNextNode());
        } else {
            budgetOrder
                .setCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(
                        EBudgetOrderNode.APPROVE_APPLY.getCode())
                    .getBackNode());
        }
        budgetOrderBO.approveApply(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void twoApproveApply(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.TWO_APPROVE_APPLY.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是二审节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.TWO_APPROVE_APPLY.getCode())
                .getNextNode());
            XN632291Res xn632291Res = carDealerProtocolBO.calProtocolFee(
                budgetOrder.getCode(), budgetOrder.getCarDealerCode());
            budgetOrder
                .setGpsFee(StringValidater.toLong(xn632291Res.getGpsFee()));
            budgetOrder
                .setLyAmount(StringValidater.toLong(xn632291Res.getLyAmount()));
            budgetOrder
                .setFxAmount(StringValidater.toLong(xn632291Res.getFxAmount()));

            budgetOrder
                .setOtherFee(StringValidater.toLong(xn632291Res.getOtherFee()));
            budgetOrderBO.twoApproveYes(budgetOrder);

            // 将原来的手续设置为失效，新增手续费
            budgetOrderFeeBO.refreshBudgetOrderNoEffect(budgetOrder.getCode());
            budgetOrderFeeBO.saveBudgetOrderFee(budgetOrder, operator);
            // TODO 将原来的返点设置为失效，新增返点
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.TWO_APPROVE_APPLY.getCode())
                .getBackNode());
            budgetOrderBO.twoApproveNo(budgetOrder);
        }

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void mortgageRefund(String code, String shouldBackBankcardCode,
            String shouldBackDatetime, String shouldBackBillPdf) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        Long loanAmount = budgetOrder.getLoanAmount();
        Long fee = budgetOrder.getFee();
        Long gpsFee = budgetOrder.getGpsFee();
        Long carDealerSubsidy = budgetOrder.getCarDealerSubsidy();
        Long shouldBackAmount = loanAmount - fee - gpsFee - carDealerSubsidy;

        budgetOrder.setShouldBackAmount(shouldBackAmount);
        budgetOrder.setShouldBackBankcardCode(shouldBackBankcardCode);
        budgetOrder.setShouldBackDatetime(DateUtil.strToDate(shouldBackDatetime,
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setShouldBackBillPdf(shouldBackBillPdf);
        budgetOrderBO.mortgageRefund(budgetOrder);
    }

    @Override
    @Transactional
    public void applyCancel(XN632270Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setZfReason(req.getZfReason());
        budgetOrder.setFrozenStatus(EBudgetFrozenStatus.FROZEN.getCode());
        budgetOrder.setCancelNodeCode(budgetOrder.getCurNodeCode());
        // 节点
        EBudgetOrderNode currentNode = EBudgetOrderNode.APPLY_CANCEL;
        String nextNode = nodeFlowBO
            .getNodeFlowByCurrentNode(currentNode.getCode()).getNextNode();
        currentNode = EBudgetOrderNode.getMap().get(nextNode);
        budgetOrder.setCurNodeCode(currentNode.getCode());

        budgetOrderBO.applyCancel(budgetOrder);

        // 写日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_CANCEL, budgetOrder.getCode(), preCurrentNode,
            budgetOrder.getCurNodeCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void cancelBizAudit(XN632271Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.APPROVE_CANCEL.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是审核节点，不能操作");
        }
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 判断是否已垫资 如果已经垫资 下一个节点是财务审核节点 未垫资 下一个节点时废流程结束节点
            if (EIsAdvanceFund.NO.getCode()
                .equals(budgetOrder.getIsAdvanceFund())) {// 没垫资情况
                budgetOrder.setCurNodeCode(
                    EBudgetOrderNode.CANCEL_APPLY_END.getCode());
                budgetOrder
                    .setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
            } else {// 垫资情况
                String currentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(budgetOrder.getCurNodeCode())
                    .getNextNode();
                budgetOrder.setCurNodeCode(currentNode);
            }

            // 更新gps使用状态为待使用
            budgetOrderGpsBO.removeBudgetOrderGpsList(budgetOrder.getCode());
        } else if (EApproveResult.NOT_PASS.getCode()
            .equals(req.getApproveResult())) {
            budgetOrder.setCurNodeCode(budgetOrder.getCancelNodeCode());
            budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
        }

        budgetOrderBO.cancelBizAudit(budgetOrder);
        // 写日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_CANCEL, budgetOrder.getCode(), preCurrentNode,
            budgetOrder.getCurNodeCode(), req.getApproveNote(),
            req.getOperator());
    }

    @Override
    @Transactional
    public void financeConfirm(XN632272Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.FINANCE_CONFIRM_RECEIVABLES.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是财务确认收款节点，不能操作");
        }
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setZfSkAmount(StringValidater.toLong(req.getZfSkAmount()));
        budgetOrder.setZfSkBankcardCode(req.getZfSkBankcardCode());
        budgetOrder.setZfSkReceiptDatetime(DateUtil.strToDate(
            req.getZfSkReceiptDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setZfFinanceRemark(req.getZfFinanceRemark());
        budgetOrder.setCurNodeCode(
            nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode).getNextNode());
        budgetOrderBO.financeConfirm(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public void receiptAndReturn(XN632280Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        budgetOrder.setZfSkBankcardCode(req.getZfSkBankcardCode());
        budgetOrder.setZfSkAmount(StringValidater.toLong(req.getZfSkAmount()));
        budgetOrder.setZfSkReceiptDatetime(DateUtil.strToDate(
            req.getZfSkReceiptDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setZfFinanceRemark(req.getZfFinanceRemark());
        budgetOrder.setIsSubmitCancel(EBoolean.NO.getCode());
        budgetOrderBO.receiptAndReturn(budgetOrder);
    }

    @Override
    public void remindingProcess(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBoolean.NO.getCode().equals(budgetOrder.getIsSubmitCancel())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "提交作废申请不为否，不能操作！");
        }
        budgetOrder.setIsSubmitCancel(EBoolean.YES.getCode());
        budgetOrder.setCurNodeCode(EBudgetOrderNode.TO_APPLY_CANCEL.getCode());
        budgetOrderBO.remindingProcess(budgetOrder);
    }

    @Override
    @Transactional
    public void renewInsuranceRemind(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        int insuranceRemindCount = budgetOrder.getInsuranceRemindCount() + 1;
        budgetOrderBO.renewInsuranceRemind(code, insuranceRemindCount);

        String mobile = budgetOrder.getMobile();
        String content = "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的保险即将到期，请及时续保！";
        smsOutBO.sendSmsOut(mobile, content);
    }

    @Override
    public void renewInsurance(XN632341Req req) {
        BudgetOrder data = new BudgetOrder();
        data.setCode(req.getCode());
        data.setInsuranceCompanyCode(req.getInsuranceCompanyCode());
        data.setInsuranceApplyDatetime(
            DateUtil.strToDate(req.getInsuranceApplyDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setInsuranceEndDatetime(DateUtil.strToDate(
            req.getInsuranceEndDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setInsuranceForcePdf(req.getInsuranceForcePdf());

        data.setInsuranceBusinessPdf(req.getInsuranceBusinessPdf());
        data.setInsuranceNote(req.getInsuranceNote());
        data.setOperator(req.getOperator());
        data.setOperateDatetime(new Date());
        budgetOrderBO.renewInsurance(data);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByDz(int start, int limit,
            BudgetOrder condition) {
        return budgetOrderBO.getPaginable(start, limit, condition);
    }

}
