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
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
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
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EIDKind;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.enums.ELogisticsType;
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

    @Override
    @Transactional
    public String addBudgetOrder(XN632120Req req) {
        BudgetOrder data = new BudgetOrder();

        // 上架贷款产品信息
        LoanProduct loanProduct = loanProductBO
            .getLoanProduct(req.getLoanProductCode());
        if (!ELoanProductStatus.PUBLISH_YES.getCode()
            .equals(loanProduct.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "贷款商品未上架");
        }
        data.setLoanProductCode(loanProduct.getCode());
        data.setLoanProductName(loanProduct.getName());
        data.setLoanBank(loanProduct.getLoanBank());
        data.setGpsFee(loanProduct.getGpsFee());

        data.setAuthFee(loanProduct.getAuthFee());
        data.setFee(loanProduct.getFee());
        data.setMonthRate(loanProduct.getMonthRate());
        // 征信
        Credit credit = creditBO.getCredit(req.getCreditCode());
        if (!EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode()
            .equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "征信单还未到达填写准入单节点");
        }
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
        data.setSaleUserId(credit.getSaleUserId());
        data.setCompanyCode(credit.getCompanyCode());
        data.setApplyDatetime(new Date());

        // 当前节点
        EBudgetOrderNode node = EBudgetOrderNode.WRITE_BUDGET_ORDER;
        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            // 下一个节点
            String nextNode = nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode())
                .getNextNode();
            node = EBudgetOrderNode.getMap().get(nextNode);
        }

        data.setCurNodeCode(node.getCode());
        String code = budgetOrderBO.saveBudgetOrder(data);

        // 修改征信单节点为 征信单入档
        if (null != credit) {
            credit.setCurNodeCode(ECreditNode.ACHIEVE.getCode());
            creditBO.refreshCreditNode(credit);
        }

        // 日志记录
        sysBizLogBO.saveSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
            node.getCode(), node.getValue(), req.getOperator());
        return code;
    }

    @Override
    public void riskApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.RISK_APPROVE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控专员审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder
                .setCurNodeCode(
                    nodeFlowBO
                        .getNodeFlowByCurrentNode(
                            EBudgetOrderNode.RISK_APPROVE.getCode())
                        .getNextNode());
        } else {
            budgetOrder
                .setCurNodeCode(
                    nodeFlowBO
                        .getNodeFlowByCurrentNode(
                            EBudgetOrderNode.RISK_APPROVE.getCode())
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
    @Transactional
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控主管审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode())
                .getNextNode());
            // 生成 收回手续费
            BudgetOrderFee data = new BudgetOrderFee();

            data.setCompanyCode(budgetOrder.getCompanyCode());
            data.setUserId(budgetOrder.getSaleUserId());
            data.setShouldAmount(budgetOrder.getFee() + budgetOrder.getAuthFee()
                    + budgetOrder.getGpsFee() + budgetOrder.getMonthDeposit());
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
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.RISK_CHARGE_APPROVE.getCode())
                .getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskChargeApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
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
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void bizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是业务总监审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(
            EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode());
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode())
                .getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode())
                .getBackNode());
            budgetOrder.setCurNodeCode(nodeFlow.getBackNode());
        }

        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshbizChargeApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void advanceFund(String code, String operator,
            String advanceFundDatetime, String advanceFundAmount,
            String billPdf) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        budgetOrder.setAdvanceFundDatetime(DateUtil
            .strToDate(advanceFundDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder
            .setAdvanceFundAmount(StringValidater.toLong(advanceFundAmount));

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setAdvanceFundDatetime(DateUtil
            .strToDate(advanceFundDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder
            .setAdvanceFundAmount(StringValidater.toLong(advanceFundAmount));

        // 下个节点设置
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.ADVANCEFUND.getCode())
            .getNextNode());
        budgetOrderBO.advancefund(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
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
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.GPSAZ.getCode())
            .getNextNode());
        budgetOrderBO.installGps(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.GPSMANAGERAPPROVE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是GPS管理员审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.GPSMANAGERAPPROVE.getCode())
                .getNextNode());

            // 更新gps使用状态
            List<BudgetOrderGps> gpslist = budgetOrderGpsBO
                .queryBudgetOrderGpsList(budgetOrder.getCode());
            for (BudgetOrderGps budgetOrderGps : gpslist) {
                Gps gps = gpsBO.getGpsByDevNo(budgetOrderGps.getGpsDevNo());
                gpsBO.refreshUseGps(gps.getCode(), budgetOrder.getCode());
            }
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(
                    EBudgetOrderNode.GPSMANAGERAPPROVE.getCode())
                .getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshGpsManagerApprove(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
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
        budgetOrder.setCarNumber(req.getCarNumber());
        budgetOrder.setCarInvoice(req.getCarInvoice());
        budgetOrder.setCarHgz(req.getCarHgz());
        budgetOrder.setCarJqx(req.getCarJqx());
        budgetOrder.setCarSyx(req.getCarSyx());
        budgetOrder.setCarRegcerti(req.getCarRegcerti());
        budgetOrder.setCarPd(req.getCarPd());
        budgetOrder.setCarKey(req.getCarKey());
        budgetOrder.setCarBigSmj(req.getCarBigSmj());

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
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    @Override
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        if (!EBudgetOrderNode.COMMITBANK.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认提交银行节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.COMMITBANK.getCode())
            .getNextNode());
        budgetOrder.setBankCommitDatetime(DateUtil.strToDate(bankCommitDatetime,
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRemark(bankCommitNote);
        budgetOrderBO.refreshCommitBank(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void confirmLoan(XN632130Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        if (!EBudgetOrderNode.CONFIRMLOAN.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
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
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.CONFIRMLOAN.getCode())
            .getNextNode());
        budgetOrderBO.refreshConfirmReceipt(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }

    @Override
    public void entryFk(XN632135Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.ENTRYLOAN.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入放款信息节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setRepayBankcardNumber(req.getRepayBankcardNumber());
        budgetOrder.setRepayBillDate(
            StringValidater.toInteger(req.getRepayBillDate()));
        budgetOrder.setRepayBankDate(
            StringValidater.toInteger(req.getRepayBankDate()));
        budgetOrder.setRepayCompanyDate(DateUtil.strToDate(
            req.getRepayCompanyDate(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRepayFirstMonthAmount(
            StringValidater.toLong(req.getRepayFirstMonthAmount()));
        budgetOrder.setRepayMonthAmount(
            StringValidater.toLong(req.getRepayMonthAmount()));
        budgetOrder.setBankFkDatetime(DateUtil.strToDate(req.getBankFkDate(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.ENTRYLOAN.getCode())
            .getNextNode());
        budgetOrderBO.refreshEntryFk(budgetOrder);

        // 获取参考材料
        // NodeFlow nodeFlow =
        // nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        // budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        // String fileList = nodeFlow.getFileList();
        // if (StringUtils.isNotBlank(fileList)) {
        // logisticsBO.saveLogistics(ELogisticsType.BUDGET.getCode(),
        // budgetOrder.getCode(), budgetOrder.getSaleUserId(),
        // preCurrentNode, nodeFlow.getNextNode(), fileList);
        // } else {
        // throw new BizException("xn0000", "当前节点材料清单不存在");
        // }

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public void entryMortgage(String code, String operator,
            String pledgeDatetime, String greenBigSmj) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ENTRYMORTGAGE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入抵押信息节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.ENTRYMORTGAGE.getCode())
            .getNextNode());
        budgetOrder.setPledgeDatetime(DateUtil.strToDate(pledgeDatetime,
            DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGreenBigSmj(greenBigSmj);
        budgetOrderBO.entryMortgage(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void mortgageCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ENTRYCOMMITBANK.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是确认提交银行节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder
            .setCurNodeCode(
                nodeFlowBO
                    .getNodeFlowByCurrentNode(
                        EBudgetOrderNode.ENTRYCOMMITBANK.getCode())
                    .getNextNode());
        budgetOrder.setPledgeBankCommitDatetime(DateUtil.strToDate(
            pledgeBankCommitDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRemark(pledgeBankCommitNote);
        budgetOrderBO.refreshMortgageCommitBank(budgetOrder);

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
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void mortgageFinish(String code, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.MORTGAGEFINISH.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是抵押完成节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        budgetOrder.setCurNodeCode(nodeFlowBO
            .getNodeFlowByCurrentNode(EBudgetOrderNode.MORTGAGEFINISH.getCode())
            .getNextNode());
        budgetOrderBO.refreshMortgageFinish(budgetOrder);

        // 日志记录
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    @Transactional
    public void archive(String code, String operator, String enterLocation) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.ARCHIVE.getCode()
            .equals(budgetOrder.getCurNodeCode())) {
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
        EBudgetOrderNode currentNode = EBudgetOrderNode.getMap()
            .get(budgetOrder.getCurNodeCode());
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
            Department department = departmentBO
                .getDepartment(budgetOrder.getCompanyCode());
            budgetOrder.setCompanyName(department.getName());
        }

        // 业务员姓名
        SYSUser sysUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        budgetOrder.setSaleUserName(sysUser.getRealName());

        // 贷款银行
        Bank loanBank = bankBO.getBank(budgetOrder.getLoanBank());
        budgetOrder.setLoanBankName(loanBank.getBankName());
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
        Paginable<BudgetOrder> page = budgetOrderBO
            .getPaginableByRoleCode(start, limit, condition);
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
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
            .queryBudgetOrderGpsList(code);
        budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);

        Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());

        CreditUser creditUser = new CreditUser();
        creditUser.setCreditCode(credit.getCode());
        List<CreditUser> queryCreditUserList = creditUserBO
            .queryCreditUserList(creditUser);
        creditUser.setCreditUserList(queryCreditUserList);
        budgetOrder.setCredit(credit);
        return budgetOrder;
    }

}
