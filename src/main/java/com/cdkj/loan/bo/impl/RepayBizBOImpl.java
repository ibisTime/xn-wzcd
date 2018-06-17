package com.cdkj.loan.bo.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EIDKind;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ESysUser;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayBizBOImpl extends PaginableBOImpl<RepayBiz>
        implements IRepayBizBO {

    @Autowired
    private IRepayBizDAO repayBizDAO;

    @Autowired
    private IBankcardAO bankcardAO;

    @Autowired
    private IUserBO userBO;

    @Override
    public void refreshBankcardNew(String code, String bankcardCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.updateBankcard(repayBiz);
    }

    @Override
    public void refreshBankcardModify(String code, String bankcardCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        String bankcardCodelist = repayBiz.getBankcardCode();
        if (!bankcardCode.equals(bankcardCodelist)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款卡编号" + bankcardCode + "不存在，请重新添加！！！");
        }
        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.updateBankcard(repayBiz);
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizDAO.selectList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        RepayBiz data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz condition = new RepayBiz();
            condition.setCode(code);
            data = repayBizDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "还款业务编号" + code + "不存在");
            }
        }
        return data;
    }

    @Override
    public RepayBiz generateCarLoanRepayBiz(BudgetOrder budgetOrder,
            String userId, String bankcardCode, String operator) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.REPAY_BIZ.getCode());
        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(budgetOrder.getCode());
        repayBiz.setUserId(userId);
        repayBiz.setRealName(budgetOrder.getCustomerName());
        repayBiz.setIdKind(EIDKind.IDCard.getCode());
        // repayBiz.setIdNo(budgetOrder.getIdNo());

        repayBiz.setBankcardCode(bankcardCode);
        repayBiz.setBizPrice(budgetOrder.getInvoicePrice());
        Long firstAmount = budgetOrder.getInvoicePrice()
                - budgetOrder.getLoanAmount();// 首付金额
        repayBiz.setSfRate(
            AmountUtil.div(firstAmount, budgetOrder.getInvoicePrice()));// 首付比例
        repayBiz.setSfAmount(firstAmount);
        repayBiz.setLoanBank(budgetOrder.getLoanBankCode());
        repayBiz.setLoanAmount(budgetOrder.getLoanAmount());

        repayBiz.setFxDeposit(0L);
        repayBiz.setPeriods(
            StringValidater.toInteger(budgetOrder.getLoanPeriods()));
        repayBiz.setRestPeriods(repayBiz.getPeriods());
        repayBiz.setBankRate(0.0);// 作废

        repayBiz.setBankFkDatetime(budgetOrder.getBankFkDatetime());
        Date now = new Date();
        repayBiz.setLoanStartDatetime(now);
        Date addMonths = DateUtils.addMonths(now, repayBiz.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);
        repayBiz.setFxDeposit(0L);

        // repayBiz
        // .setFirstRepayDatetime(budgetOrder.getRepayFirstMonthDatetime());
        // repayBiz.setFirstRepayAmount(budgetOrder.getRepayFirstMonthAmount());
        //
        // repayBiz.setMonthDatetime(budgetOrder.getRepayBankDate());
        // repayBiz.setMonthAmount(budgetOrder.getRepayMonthAmount());
        repayBiz.setLyDeposit(budgetOrder.getLyAmount());
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());

        repayBiz.setRestAmount(budgetOrder.getLoanAmount());
        repayBiz.setRestTotalCost(0L);
        repayBiz.setTotalInDeposit(0L);
        repayBiz.setRestOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);

        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());

        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void refreshRepayCarLoan(String repayBizCode,
            Long realWithholdAmount) {
        RepayBiz repayBiz = getRepayBiz(repayBizCode);
        repayBiz.setRestAmount(repayBiz.getRestAmount() - realWithholdAmount);
        if (repayBiz.getRestAmount() == 0) {
            repayBiz.setCurNodeCode(ERepayBizNode.COMMIT_SETTLE.getCode());// 提交结算单节点
            repayBiz.setRemark("提交结算单");
        }
        repayBiz.setUpdater(ESysUser.SYS_USER_HTWT.getCode());
        repayBiz.setUpdateDatetime(new Date());

        repayBizDAO.updateRepayAll(repayBiz);
    }

    @Override
    public void overdueRedMenuHandle(RepayBiz data, String curNodeCode) {
        data.setCurNodeCode(curNodeCode);
        repayBizDAO.updateOverdueRedHandle(data);
    }

    @Override
    public void confirmSettledProduct(RepayBiz data) {
        repayBizDAO.updateConfirmSettledProduct(data);
    }

    @Override
    public void refreshAdvanceRepayCarLoan(XN630512Req req, RepayBiz repayBiz,
            Long realWithholdAmount) {
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setSettleAttach(req.getSettleAttach());
        repayBiz.setSettleDatetime(DateUtil.strToDate(req.getSettleDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        repayBiz.setDepositReceipt(req.getDepositReceipt());
        repayBiz.setRefundBankSubbranch(req.getRefundBankSubbranch());

        repayBiz.setRefundBankRealName(req.getRefundBankRealName());
        repayBiz.setRefundBankcard(req.getRefundBankcard());
        repayBiz.setSecondCompanyInsurance(req.getSecondCompanyInsurance());
        repayBiz.setThirdCompanyInsurance(req.getThirdCompanyInsurance());
        repayBiz.setCurNodeCode(ERepayBizNode.FINANCE_CHECK.getCode());

        repayBiz.setIsAdvanceSettled(EBoolean.YES.getCode());
        repayBiz.setRestAmount(0L);
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark("财务审核");
        repayBizDAO.updateRepayAllAdvance(repayBiz);
    }

    @Override
    public RepayBiz generateProductLoanRepayBiz(Order order) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.REPAY_BIZ.getCode());

        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.PRODUCT.getCode());
        User applyUser = userBO.getUser(order.getApplyUser());
        repayBiz.setUserId(applyUser.getUserId());
        repayBiz.setRealName(applyUser.getRealName());
        repayBiz.setIdKind(applyUser.getIdKind());
        repayBiz.setIdNo(applyUser.getIdNo());

        repayBiz.setBankcardCode(order.getBankcardCode());
        repayBiz.setRefType(ERepayBizType.PRODUCT.getCode());
        repayBiz.setRefCode(order.getCode());

        repayBiz.setBizPrice(order.getAmount());
        repayBiz.setSfRate(order.getSfRate());
        repayBiz.setSfAmount(order.getSfAmount());
        String bankName = bankcardAO.getBankcard(order.getBankcardCode())
            .getBankName();
        repayBiz.setLoanBank(bankName);
        repayBiz.setLoanAmount(order.getLoanAmount());

        repayBiz.setPeriods(order.getPeriods());
        repayBiz.setRestPeriods(order.getPeriods());
        repayBiz.setBankRate(order.getBankRate());
        Date now = new Date();
        repayBiz.setLoanStartDatetime(now);
        Date addMonths = DateUtils.addMonths(now, order.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);

        // repayBiz.setBankFkDatetime(now);
        repayBiz.setFxDeposit(0L);
        Date date = DateUtils.addMonths(order.getApplyDatetime(), 1);
        repayBiz.setFirstRepayDatetime(date);
        Long monthlyAmount = new BigDecimal(order.getLoanAmount())
            .divide(new BigDecimal(order.getPeriods()), 0, RoundingMode.DOWN)
            .longValue();
        // long long3 = (long) (long2 * order.getBankRate());
        repayBiz.setFirstRepayAmount(monthlyAmount);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getApplyDatetime());
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        repayBiz.setMonthDatetime(i);
        repayBiz.setMonthAmount(monthlyAmount);

        repayBiz.setLyDeposit(0L);
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_TO_REPAY.getCode());
        repayBiz.setRestAmount(order.getLoanAmount());
        repayBiz.setRestTotalCost(0L);

        repayBiz.setTotalInDeposit(0L);
        repayBiz.setRestOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);
        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");

        repayBiz.setUpdater(order.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(order.getRemark());
        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void refreshRestAmount(RepayBiz repayBiz, Long realWithholdAmount) {
        if (repayBiz != null && realWithholdAmount != null) {
            repayBiz
                .setRestAmount(repayBiz.getRestAmount() - realWithholdAmount);
            repayBizDAO.updateRepayBizRestAmount(repayBiz);
        }
    }

    @Override
    public void repayOverdue(RepayBiz repayBiz) {
        if (repayBiz != null) {
            repayBizDAO.repayOverDue(repayBiz);
        }
    }

    @Override
    public void refreshAdvanceRepayProduct(RepayBiz repayBiz,
            Long realWithholdAmount) {
    }

    @Override
    public void refreshRepayAllCarProduct(String repayBizCode) {
    }

    @Override
    public void confirmSettledCarProduct(RepayBiz repayBiz) {
    }

    @Override
    public void refreshEnterBlackList(RepayBiz data) {
    }

    @Override
    public void refreshJudgeApply(String code) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(ERepayBizNode.JUDGE_FOLLOW.getCode());
        repayBizDAO.updateJudgeApply(data);
    }

    @Override
    public void refreshJudgeFollow(String code) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(ERepayBizNode.JUDGE_RESULT_INPUT.getCode());
        repayBizDAO.updateJudgeFollow(data);
    }

    @Override
    public void refreshJudgeResultInput(String code) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(ERepayBizNode.FINANCE_SURE_RECEIPT.getCode());
        repayBizDAO.updateJudgeResultInput(data);
    }

    @Override
    public void refreshFinanceSureReceipt(RepayBiz data) {
        repayBizDAO.updateFinanceSureReceipt(data);
    }

    @Override
    public void takeCarApply(RepayBiz data) {
        repayBizDAO.updateTakeCarApply(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarRiskManageCheck(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarRiskManageCheck(RepayBiz data) {
        repayBizDAO.updateTakeCarRiskManageCheck(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarCompanyManageCheck(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarCompanyManageCheck(RepayBiz data) {
        repayBizDAO.updateTakeCarCompanyManageCheck(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarRiskLeaderCheck(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarRiskLeaderCheck(RepayBiz data) {
        repayBizDAO.updateTakeCarRiskLeaderCheck(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarFinanceManageCheck(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarFinanceManageCheck(RepayBiz data) {
        repayBizDAO.updateTakeCarFinanceManageCheck(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarSureFk(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarSureFk(RepayBiz data) {
        repayBizDAO.updateTakeCarSureFk(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarInputResult(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarInputResult(RepayBiz data) {
        repayBizDAO.updateTakeCarInputResult(data);
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#takeCarResultHandle(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void takeCarResultHandle(RepayBiz data) {
        repayBizDAO.updateTakeCarResultHandle(data);
    }

    public Paginable<RepayBiz> getPaginableByRoleCode(int start, int limit,
            RepayBiz condition) {
        prepare(condition);
        long totalCount = repayBizDAO.selectTotalCountByRoleCode(condition);
        Page<RepayBiz> page = new Page<RepayBiz>(start, limit, totalCount);
        List<RepayBiz> dataList = repayBizDAO.selectRepayBizByRoleCode(
            condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshCommitSettle(RepayBiz data) {
        repayBizDAO.updateCommitSettle(data);
    }

    @Override
    public void refreshFinanceCheck(String code, String curNodeCode,
            String remark, String updater) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        repayBizDAO.updateFinanceCheck(data);
    }

    @Override
    public void refreshCashRemit(RepayBiz data) {
        repayBizDAO.updateCashRemit(data);
    }

    @Override
    public void refreshReleaseMortgageApply(String code, String curNodeCode,
            String applyNote, String updater) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setReleaseApplyNote(applyNote);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        repayBizDAO.updateReleaseMortgageApply(data);
    }

    @Override
    public void refreshRiskIndoorCheck(String code, String curNodeCode,
            String remark, String updater) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        repayBizDAO.updateRiskIndoorCheck(data);
    }

    @Override
    public void refreshRiskManagerCheck(String code, String curNodeCode,
            String remark, String updater) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(curNodeCode);
        data.setRemark(remark);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        repayBizDAO.updateRiskManagerCheck(data);
    }

    @Override
    public void refreshBankRecLogic(String code, String updater) {
        RepayBiz data = new RepayBiz();
        data.setCode(code);
        data.setCurNodeCode(ERepayBizNode.MORTGAGE_INPUT.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        repayBizDAO.updateBankRecLogic(data);
    }

    @Override
    public void refreshMortgageInput(RepayBiz data) {
        repayBizDAO.updateMortgageInput(data);
    }
}
