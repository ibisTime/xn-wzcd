package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.dto.req.XN632180Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBackAdvanceStatus;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EIDKind;
import com.cdkj.loan.enums.EIsAdvanceFund;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ERepointStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Override
    @Transactional
    public void editBudgetOrder(XN632120Req req) {
        BudgetOrder data = budgetOrderBO.getBudgetOrder(req.getCode());

        // 上架贷款产品信息
        LoanProduct loanProduct = loanProductBO.getLoanProduct(req
            .getLoanProductCode());
        if (!ELoanProductStatus.PUBLISH_YES.getCode().equals(
            loanProduct.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "贷款商品未上架");
        }
        data.setLoanProductCode(loanProduct.getCode());
        data.setLoanProductName(loanProduct.getName());
        data.setLoanBank(loanProduct.getLoanBank());
        data.setGpsFee(loanProduct.getGpsFee());
        // 公证费=贷款额*公证费比例
        Long loanAmount = StringValidater.toLong(req.getLoanAmount());
        data.setAuthFee(AmountUtil.mul(loanAmount, loanProduct.getAuthRate()));
        // 银行服务费=前置*贷款额/（1+前置）
        Long amount = AmountUtil.mul(loanAmount, loanProduct.getPreRate());
        data.setBankFee(AmountUtil.div(amount, (1.0 + loanProduct.getPreRate())));
        data.setCompanyFee(StringValidater.toLong(req.getCompanyFee()));

        data.setBizType(req.getBizType());
        data.setLoanPeriod(req.getLoanPeriod());
        data.setInvoiceCompany(req.getInvoiceCompany());
        data.setCarBrand(req.getCarBrand());
        data.setCarSeries(req.getCarSeries());

        data.setCarModel(req.getCarModel());
        data.setCarPic(req.getCarPic());
        data.setCarHgzPic(req.getCarHgzPic());
        data.setCarHgzNo(req.getCarHgzNo());
        data.setCarFrameNo(req.getCarFrameNo());
        data.setCarEngineNo(req.getCarEngineNo());
        data.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        data.setInvoicePrice(StringValidater.toLong(req.getInvoicePrice()));

        data.setCarColor(req.getCarColor());
        data.setMonthDeposit(StringValidater.toLong(req.getMonthDeposit()));
        data.setFirstAmount(StringValidater.toLong(req.getFirstAmount()));
        data.setFirstRate(StringValidater.toDouble(req.getFirstRate()));
        data.setLoanAmount(loanAmount);

        data.setSettleAddress(req.getSettleAddress());
        data.setApplyUserName(req.getApplyUserName());
        data.setGender(req.getGender());
        data.setMarryState(req.getMarryState());
        data.setNation(req.getNation());

        data.setEducation(req.getEducation());
        data.setIdKind(EIDKind.IDCard.getCode());
        data.setIdNo(req.getIdNo());
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
        data.setWorkCompanyProperty(req.getWorkCompanyProperty());
        data.setWorkBelongIndustry(req.getWorkBelongIndustry());
        data.setWorkProfession(req.getWorkProfession());
        data.setWorkDatetime(DateUtil.strToDate(req.getWorkDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
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
        data.setMateCompanyName(req.getMateCompanyName());
        data.setMateCompanyAddress(req.getMateCompanyAddress());
        data.setMateCompanyContactNo(req.getMateCompanyContactNo());

        data.setMateZfbJourDatetimeStart(DateUtil.strToDate(
            req.getMateZfbJourDatetimeStart(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setMateZfbJourDatetimeEnd(DateUtil.strToDate(
            req.getMateZfbJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMateZfbJourIncome(StringValidater.toLong(req
            .getMateZfbJourIncome()));
        data.setMateZfbJourExpend(StringValidater.toLong(req
            .getMateZfbJourExpend()));
        data.setMateZfbJourBalance(StringValidater.toLong(req
            .getMateZfbJourBalance()));
        data.setMateZfbJourMonthIncome(StringValidater.toLong(req
            .getMateZfbJourMonthIncome()));
        data.setMateZfbJourMonthExpend(StringValidater.toLong(req
            .getMateZfbJourMonthExpend()));

        data.setMateZfbJourPic(req.getMateZfbJourPic());
        data.setMateZfbJourRemark(req.getMateZfbJourRemark());

        data.setMateWxJourDatetimeStart(DateUtil.strToDate(
            req.getMateWxJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setMateWxJourDatetimeEnd(DateUtil.strToDate(
            req.getMateWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMateWxJourIncome(StringValidater.toLong(req
            .getMateWxJourIncome()));
        data.setMateWxJourExpend(StringValidater.toLong(req
            .getMateWxJourExpend()));
        data.setMateWxJourBalance(StringValidater.toLong(req
            .getMateWxJourBalance()));
        data.setMateWxJourMonthIncome(StringValidater.toLong(req
            .getMateWxJourMonthIncome()));
        data.setMateWxJourMonthExpend(StringValidater.toLong(req
            .getMateWxJourMonthExpend()));
        data.setMateWxJourPic(req.getMateWxJourPic());
        data.setMateWxJourRemark(req.getMateWxJourRemark());

        data.setMateJourDatetimeStart(DateUtil.strToDate(
            req.getMateJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setMateJourDatetimeEnd(DateUtil.strToDate(
            req.getMateJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMateJourIncome(StringValidater.toLong(req.getMateJourIncome()));
        data.setMateJourExpend(StringValidater.toLong(req.getMateJourExpend()));
        data.setMateJourBalance(StringValidater.toLong(req.getMateJourBalance()));
        data.setMateJourMonthIncome(StringValidater.toLong(req
            .getMateJourMonthIncome()));
        data.setMateJourMonthExpend(StringValidater.toLong(req
            .getMateJourMonthExpend()));

        data.setMateJourPic(req.getMateJourPic());
        data.setMateJourRemark(req.getMateJourRemark());
        data.setMateAssetPdf(req.getMateAssetPdf());

        data.setGuaName(req.getGuaName());
        data.setGuaMobile(req.getGuaMobile());
        data.setGuaIdNo(req.getGuaIdNo());
        data.setGuaPhone(req.getGuaPhone());
        data.setGuaCompanyName(req.getGuaCompanyName());

        data.setGuaCompanyAddress(req.getGuaCompanyAddress());
        data.setGuaHouseAssetAddress(req.getGuaHouseAssetAddress());

        data.setGuaZfbJourDatetimeStart(DateUtil.strToDate(
            req.getGuaZfbJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGuaZfbJourDatetimeEnd(DateUtil.strToDate(
            req.getGuaZfbJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setGuaZfbJourIncome(StringValidater.toLong(req
            .getGuaZfbJourIncome()));
        data.setGuaZfbJourExpend(StringValidater.toLong(req
            .getGuaZfbJourExpend()));
        data.setGuaZfbJourBalance(StringValidater.toLong(req
            .getGuaZfbJourBalance()));
        data.setGuaZfbJourMonthIncome(StringValidater.toLong(req
            .getGuaZfbJourMonthIncome()));
        data.setGuaZfbJourMonthExpend(StringValidater.toLong(req
            .getGuaZfbJourMonthExpend()));

        data.setGuaZfbJourPic(req.getGuaZfbJourPic());
        data.setGuaZfbJourRemark(req.getGuaZfbJourRemark());

        data.setGuaWxJourDatetimeStart(DateUtil.strToDate(
            req.getGuaWxJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGuaWxJourDatetimeEnd(DateUtil.strToDate(
            req.getGuaWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setGuaWxJourIncome(StringValidater.toLong(req.getGuaWxJourIncome()));
        data.setGuaWxJourExpend(StringValidater.toLong(req.getGuaWxJourExpend()));
        data.setGuaWxJourBalance(StringValidater.toLong(req
            .getGuaWxJourBalance()));
        data.setGuaWxJourMonthIncome(StringValidater.toLong(req
            .getGuaWxJourMonthIncome()));
        data.setGuaWxJourMonthExpend(StringValidater.toLong(req
            .getGuaWxJourMonthExpend()));

        data.setGuaWxJourPic(req.getGuaWxJourPic());
        data.setGuaWxJourRemark(req.getGuaWxJourRemark());

        data.setGuaJourDatetimeStart(DateUtil.strToDate(
            req.getGuaJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGuaJourDatetimeEnd(DateUtil.strToDate(
            req.getGuaJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setGuaJourIncome(StringValidater.toLong(req.getGuaJourIncome()));
        data.setGuaJourExpend(StringValidater.toLong(req.getGuaJourExpend()));
        data.setGuaJourBalance(StringValidater.toLong(req.getGuaJourBalance()));
        data.setGuaJourMonthIncome(StringValidater.toLong(req
            .getGuaJourMonthIncome()));
        data.setGuaJourMonthExpend(StringValidater.toLong(req
            .getGuaJourMonthExpend()));

        data.setGuaJourPic(req.getGuaJourPic());
        data.setGuaJourRemark(req.getGuaJourRemark());
        data.setGuaAssetPdf(req.getGuaAssetPdf());

        data.setEmergencyName1(req.getEmergencyName1());
        data.setEmergencyRelation1(req.getEmergencyRelation1());
        data.setEmergencyMobile1(req.getEmergencyMobile1());

        data.setEmergencyName2(req.getEmergencyName2());
        data.setEmergencyRelation2(req.getEmergencyRelation2());
        data.setEmergencyMobile2(req.getEmergencyMobile2());
        data.setZfbJourDatetimeStart(DateUtil.strToDate(
            req.getZfbJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setZfbJourDatetimeEnd(DateUtil.strToDate(
            req.getZfbJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setZfbJourIncome(StringValidater.toLong(req.getZfbJourIncome()));
        data.setZfbJourExpend(StringValidater.toLong(req.getZfbJourExpend()));
        data.setZfbJourBalance(StringValidater.toLong(req.getZfbJourBalance()));
        data.setZfbJourMonthIncome(StringValidater.toLong(req
            .getZfbJourMonthIncome()));
        data.setZfbJourMonthExpend(StringValidater.toLong(req
            .getZfbJourMonthExpend()));

        data.setZfbJourPic(req.getZfbJourPic());
        data.setZfbJourRemark(req.getZfbJourRemark());
        data.setWxJourDatetimeStart(DateUtil.strToDate(
            req.getWxJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setWxJourDatetimeEnd(DateUtil.strToDate(
            req.getWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setWxJourIncome(StringValidater.toLong(req.getWxJourIncome()));
        data.setWxJourExpend(StringValidater.toLong(req.getWxJourExpend()));
        data.setWxJourBalance(StringValidater.toLong(req.getWxJourBalance()));
        data.setWxJourMonthIncome(StringValidater.toLong(req
            .getWxJourMonthIncome()));
        data.setWxJourMonthExpend(StringValidater.toLong(req
            .getWxJourMonthExpend()));

        data.setWxJourPic(req.getWxJourPic());
        data.setWxJourRemark(req.getWxJourRemark());
        data.setJourDatetimeStart(DateUtil.strToDate(
            req.getJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setJourDatetimeEnd(DateUtil.strToDate(req.getJourDatetimeEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setJourIncome(StringValidater.toLong(req.getJourIncome()));
        data.setJourExpend(StringValidater.toLong(req.getJourExpend()));
        data.setJourBalance(StringValidater.toLong(req.getJourBalance()));
        data.setJourMonthIncome(StringValidater.toLong(req.getJourMonthIncome()));
        data.setJourMonthExpend(StringValidater.toLong(req.getJourMonthExpend()));

        data.setJourPic(req.getJourPic());
        data.setJourRemark(req.getJourRemark());
        data.setAssetPdf(req.getAssetPdf());
        data.setHouseContract(req.getHouseContract());
        data.setHousePicture(req.getHousePicture());
        data.setIsAdvanceFund(req.getIsAdvanceFund());

        // 当前节点
        EBudgetOrderNode node = EBudgetOrderNode.WRITE_BUDGET_ORDER;
        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            // 下一个节点
            String nextNode = nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode()).getNextNode();
            node = EBudgetOrderNode.getMap().get(nextNode);
        }

        data.setCurNodeCode(node.getCode());
        budgetOrderBO.refreshBudgetOrder(data);

        // 日志记录
        sysBizLogBO.saveSYSBizLog(data.getCode(), EBizLogType.BUDGET_ORDER,
            data.getCode(), node.getCode(), node.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void riskApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.RISK_APPROVE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.RISK_APPROVE.getCode()).getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.RISK_APPROVE.getCode()).getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控主管审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode()).getNextNode());
            // 生成 收回手续费
            BudgetOrderFee data = new BudgetOrderFee();

            data.setCompanyCode(budgetOrder.getCompanyCode());
            data.setUserId(budgetOrder.getSaleUserId());

            // 应收手续费=银行服务费+公证费+gps费+月供保证金+公司服务费
            data.setShouldAmount(budgetOrder.getBankFee()
                    + budgetOrder.getAuthFee() + budgetOrder.getGpsFee()
                    + budgetOrder.getMonthDeposit()
                    + budgetOrder.getCompanyFee());
            data.setRealAmount(0L);
            data.setIsSettled(EBoolean.NO.getCode());

            data.setUpdater(operator);
            data.setUpdateDatetime(new Date());
            data.setBudgetOrder(code);
            budgetOrderFeeBO.saveBudgetOrderFee(data);

            // 征信单回写准入单编号
            Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());
            credit.setBudgetCode(budgetOrder.getCode());
            creditBO.refreshCredit(credit);

            // 生成返点支付数据
            Repoint repoint = new Repoint();
            // 准入单的贷款金额 乘以 准入单的贷款产品的返点比例 等于应返金额
            Long loanAmount = budgetOrder.getLoanAmount();
            LoanProduct loanProduct = loanProductBO.getLoanProduct(budgetOrder
                .getLoanProductCode());
            double backRate = loanProduct.getBackRate();
            long shouldAmount = Math.round(loanAmount * backRate);
            BizTeam bizTeam = bizTeamBO.getBizTeam(budgetOrder.getTeamCode());
            repoint.setTeamCode(budgetOrder.getTeamCode());
            repoint.setBizCode(budgetOrder.getCode());
            repoint.setAccountNo(bizTeam.getAccountNo());
            repoint.setBank(bizTeam.getBank());
            repoint.setSubbranch(bizTeam.getSubbranch());
            repoint.setShouldAmount(shouldAmount);
            repoint.setStatus(ERepointStatus.TODO.getCode());
            repoint.setUpdater(operator);
            repoint.setUpdateDatetime(new Date());
            repointBO.saveRepoint(repoint);

        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode()).getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskChargeApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void interview(String code, String interviewVideo,
            String interviewContract, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setInterviewVideo(interviewVideo);
        budgetOrder.setInterviewContract(interviewContract);
        EBudgetOrderNode node = EBudgetOrderNode.BIZ_CHARGE_APPROVE;
        budgetOrder.setCurNodeCode(node.getCode());
        budgetOrderBO.interview(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void bizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是业务总监审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.BIZ_CHARGE_APPROVE
                .getCode());
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode()).getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode()).getBackNode());
            budgetOrder.setCurNodeCode(nodeFlow.getBackNode());
        }

        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshbizChargeApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void advanceFund(String code, String operator,
            String advanceFundDatetime, String advanceFundAmount, String billPdf) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        budgetOrder.setAdvanceFundDatetime(DateUtil.strToDate(
            advanceFundDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setAdvanceFundAmount(StringValidater
            .toLong(advanceFundAmount));

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setAdvanceFundDatetime(DateUtil.strToDate(
            advanceFundDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setAdvanceFundAmount(StringValidater
            .toLong(advanceFundAmount));

        // 下个节点设置
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.ADVANCEFUND.getCode()).getNextNode());
        budgetOrderBO.advancefund(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
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
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.GPSAZ.getCode()).getNextNode());
        budgetOrderBO.installGps(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.GPSMANAGERAPPROVE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是GPS管理员审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.GPSMANAGERAPPROVE.getCode()).getNextNode());

            // 更新gps使用状态
            List<BudgetOrderGps> gpslist = budgetOrderGpsBO
                .queryBudgetOrderGpsList(budgetOrder.getCode());
            for (BudgetOrderGps budgetOrderGps : gpslist) {
                Gps gps = gpsBO.getGps(budgetOrderGps.getCode());
                gpsBO.refreshUseGps(gps.getCode(), budgetOrder.getCode());
            }
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                EBudgetOrderNode.GPSMANAGERAPPROVE.getCode()).getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshGpsManagerApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void carSettle(XN632128Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();

        budgetOrder.setCarSettleDatetime(DateUtil.strToDate(
            req.getCarSettleDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        // budgetOrder.setCarNumber(req.getCarNumber());
        budgetOrder.setCarInvoice(req.getCarInvoice());
        budgetOrder.setCarHgz(req.getCarHgz());
        budgetOrder.setCarJqx(req.getCarJqx());
        budgetOrder.setCarSyx(req.getCarSyx());

        NodeFlow nodeFlow = nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.CARSETTLE.getCode());
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());

        // 车辆信息落户
        budgetOrderBO.carSettle(budgetOrder);
        // 获取参考材料
        String fileList = nodeFlow.getFileList();
        if (StringUtils.isNotBlank(fileList)) {
            logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                EBudgetOrderNode.CARSETTLE.getCode(), nodeFlow.getNextNode(),
                fileList);
        } else {
            throw new BizException("xn0000", "当前节点材料清单不存在");
        }

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    @Override
    @Transactional
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.COMMITBANK.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认提交银行节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.COMMITBANK.getCode()).getNextNode());
        budgetOrder.setBankCommitDatetime(DateUtil.strToDate(
            bankCommitDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRemark(bankCommitNote);
        budgetOrderBO.refreshCommitBank(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void confirmLoan(XN632130Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.CONFIRMLOAN.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认放款节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setReceiptBankCode(req.getReceiptBankCode());
        budgetOrder.setReceiptBankName(req.getReceiptBankName());
        budgetOrder.setReceiptBankcardNumber(req.getReceiptBankcardNumber());
        budgetOrder.setReceiptPdf(req.getReceiptPdf());
        budgetOrder.setReceiptRemark(req.getReceiptRemark());
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.CONFIRMLOAN.getCode()).getNextNode());
        budgetOrderBO.refreshConfirmReceipt(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

        // 银行已放款待财务退款 生成退客户垫资款数据
        if (EIsAdvanceFund.YES.getCode().equals(budgetOrder.getIsAdvanceFund())) {
            budgetOrder.setBackAdvanceStatus(EBackAdvanceStatus.NONEED_BACK
                .getCode());

        }
        if (EIsAdvanceFund.NO.getCode().equals(budgetOrder.getIsAdvanceFund())) {
            budgetOrder.setBackAdvanceStatus(EBackAdvanceStatus.TODO_BACK
                .getCode());
        }
        budgetOrderBO.saveBackAdvanceFund(budgetOrder);

    }

    @Override
    @Transactional
    public void entryFk(XN632135Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.ENTRYLOAN.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入放款信息节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setRepayBankcardNumber(req.getRepayBankcardNumber());
        budgetOrder.setRepayBillDate(StringValidater.toInteger(req
            .getRepayBillDate()));
        budgetOrder.setRepayBankDate(StringValidater.toInteger(req
            .getRepayBankDate()));
        budgetOrder.setRepayCompanyDate(DateUtil.strToDate(
            req.getRepayCompanyDate(), DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder
            .setRepayFirstMonthDatetime(DateUtil.strToDate(
                req.getRepayFirstMonthDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRepayFirstMonthAmount(StringValidater.toLong(req
            .getRepayFirstMonthAmount()));
        budgetOrder.setRepayMonthAmount(StringValidater.toLong(req
            .getRepayMonthAmount()));

        budgetOrder.setBankFkDatetime(DateUtil.strToDate(req.getBankFkDate(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.ENTRYLOAN.getCode()).getNextNode());
        budgetOrderBO.refreshEntryFk(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void entryMortgage(String code, String operator,
            String pledgeDatetime, String greenBigSmj) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ENTRYMORTGAGE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入抵押信息节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            preCurrentNode).getNextNode());

        budgetOrder.setPledgeDatetime(DateUtil.strToDate(pledgeDatetime,
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGreenBigSmj(greenBigSmj);
        budgetOrderBO.entryMortgage(budgetOrder);

        // 获取参考材料
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        String fileList = nodeFlow.getFileList();
        if (StringUtils.isNotBlank(fileList)) {
            logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                preCurrentNode, nodeFlow.getNextNode(), fileList);
        } else {
            throw new BizException("xn0000", "当前节点材料清单不存在");
        }

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void mortgageCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ENTRYCOMMITBANK.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认提交银行节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.ENTRYCOMMITBANK.getCode()).getNextNode());
        budgetOrder.setPledgeBankCommitDatetime(DateUtil.strToDate(
            pledgeBankCommitDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRemark(pledgeBankCommitNote);
        budgetOrderBO.refreshMortgageCommitBank(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void mortgageFinish(XN632133Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.MORTGAGEFINISH.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是抵押完成节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.MORTGAGEFINISH.getCode()).getNextNode());
        budgetOrder.setCarNumber(req.getCarNumber());
        budgetOrder.setCarRegcerti(req.getCarRegcerti());
        budgetOrder.setCarPd(req.getCarPd());
        budgetOrder.setCarKey(req.getCarKey());
        budgetOrder.setCarBigSmj(req.getCarBigSmj());
        budgetOrderBO.refreshMortgageFinish(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void archive(String code, String operator, String enterLocation) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ARCHIVE.getCode().equals(
            budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是入档节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        // 归档

        /****** 生成还款业务 ******/
        // 检查用户是否已经注册过
        String userId = userBO.getUserIdByMobile(budgetOrder.getMobile());
        if (StringUtils.isBlank(userId)) {
            // 用户代注册并实名认证
            userId = userBO.doRegisterAndIdentify(budgetOrder.getMobile(),
                budgetOrder.getIdKind(), budgetOrder.getApplyUserName(),
                budgetOrder.getIdNo());
        }

        // 绑定用户银行卡
        String bankcardCode = bankcardBO.bind(userId,
            budgetOrder.getApplyUserName(),
            budgetOrder.getRepayBankcardNumber(),
            budgetOrder.getRepayBankCode(), budgetOrder.getRepayBankName(),
            budgetOrder.getRepaySubbranch());

        // 自动生成还款业务
        RepayBiz repayBiz = repayBizBO.genereateNewCarLoanRepayBiz(budgetOrder,
            userId, bankcardCode, operator);

        // 自动生成还款计划
        repayPlanBO.genereateNewRapayPlan(repayBiz);

        // 归档完成，更新预算单信息
        String repayBizCode = repayBiz.getCode();
        budgetOrder.setCurNodeCode(EBudgetOrderNode.ARCHIVE_END.getCode());
        budgetOrderBO.archiveSuccess(budgetOrder, repayBizCode, userId);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap().get(
            budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition) {
        Paginable<BudgetOrder> page = budgetOrderBO.getPaginable(start, limit,
            condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BudgetOrder budgetOrder : page.getList()) {
                initBudgetOrder(budgetOrder);
            }
        }
        return page;
    }

    // 初始化预算单数据，包含公司名称
    private void initBudgetOrder(BudgetOrder budgetOrder) {
        // 业务公司名称
        if (StringUtils.isNotBlank(budgetOrder.getCompanyCode())) {
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            budgetOrder.setCompanyName(department.getName());
        }

        // 业务员姓名
        SYSUser sysUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        budgetOrder.setSaleUserName(sysUser.getRealName());

        // 贷款银行
        if (StringUtils.isNotBlank(budgetOrder.getLoanBank())) {
            Bank loanBank = bankBO.getBank(budgetOrder.getLoanBank());
            budgetOrder.setLoanBankName(loanBank.getBankName());
        }
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        initBudgetOrder(budgetOrder);
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
            .queryBudgetOrderGpsList(code);
        budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);
        return budgetOrder;
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition) {
        Paginable<BudgetOrder> page = budgetOrderBO.getPaginableByRoleCode(
            start, limit, condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BudgetOrder budgetOrder : page.getList()) {
                initBudgetOrder(budgetOrder);
            }
        }
        return page;
    }

    @Override
    public BudgetOrder getMoreBudget(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        initBudgetOrder(budgetOrder);

        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
            .queryBudgetOrderGpsList(code);
        budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);

        Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());
        CreditUser creditUser = new CreditUser();
        creditUser.setCreditCode(credit.getCode());
        List<CreditUser> queryCreditUserList = creditUserBO
            .queryCreditUserList(creditUser);
        credit.setCreditUserList(queryCreditUserList);

        budgetOrder.setCredit(credit);
        return budgetOrder;
    }

    @Override
    public void confirmBackAdvanceFund(XN632180Req req) {

        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        budgetOrder.setBackAdvanceAmount(req.getBackAdvanceAmount());
        budgetOrder.setBackAdvanceAccount(req.getBackAdvanceAccount());
        budgetOrder.setBackAdvanceOpenBank(req.getBackAdvanceOpenBank());
        budgetOrder.setBackAdvanceSubbranch(req.getBackAdvanceSubbranch());
        budgetOrder.setBackAdvanceWaterBill(req.getBackAdvanceWaterBill());

        budgetOrderBO.confirmBackAdvanceFund(budgetOrder);

    }
}
