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
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Order;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
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
        String code = OrderNoGenerater.generate("RB");

        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(budgetOrder.getCode());
        repayBiz.setUserId(userId);
        repayBiz.setBankcardCode(bankcardCode);

        repayBiz.setBizPrice(budgetOrder.getInvoicePrice());
        repayBiz.setSfRate(budgetOrder.getFirstRate());
        repayBiz.setSfAmount(budgetOrder.getFirstAmount());
        repayBiz.setLoanBank(budgetOrder.getLoanBank());
        repayBiz.setLoanAmount(budgetOrder.getLoanAmount());

        repayBiz
            .setPeriods(StringValidater.toInteger(budgetOrder.getLoanPeriod()));
        repayBiz.setRestPeriods(repayBiz.getPeriods());
        repayBiz.setBankRate(0.0);// 作废
        repayBiz
            .setFirstRepayDatetime(budgetOrder.getRepayFirstMonthDatetime());
        repayBiz.setFirstRepayAmount(budgetOrder.getRepayFirstMonthAmount());

        repayBiz.setMonthDatetime(budgetOrder.getRepayBankDate());
        repayBiz.setMonthAmount(budgetOrder.getRepayMonthAmount());
        repayBiz.setLyDeposit(budgetOrder.getMonthDeposit());
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());

        repayBiz.setRestAmount(budgetOrder.getLoanAmount());
        repayBiz.setRestTotalCost(0L);
        repayBiz.setTotalInDeposit(0L);
        repayBiz.setOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);

        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(budgetOrder.getRemark());

        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void refreshRepayAllCarLoan(String repayBizCode) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(repayBizCode);
        repayBiz.setCurNodeCode(ERepayBizNode.QKCS_DEPART_CHECK.getCode());// 到清款催收部审核节点
        repayBiz.setUpdater(ESysUser.SYS_USER_HTWT.getCode());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark("本业务已正常还款");

        repayBizDAO.updateRepayAll(repayBiz);
    }

    @Override
    public void confirmSettledProduct(RepayBiz data) {
        repayBizDAO.updateConfirmSettledProduct(data);
    }

    @Override
    public void refreshAdvanceRepayCarLoan(RepayBiz repayBiz,
            Long realWithholdAmount) {
        repayBiz.setCurNodeCode(ERepayBizNode.QKCS_DEPART_CHECK.getCode());
        repayBiz.setIsAdvanceSettled(EBoolean.YES.getCode());
        repayBiz.setRestAmount(0L);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark("该业务已提前还款，待结清");
        repayBizDAO.updateRepayAllAdvance(repayBiz);
    }

    @Override
    public RepayBiz generateProductLoanRepayBiz(Order order) {
        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate("RB");

        repayBiz.setCode(code);
        String userId = order.getApplyUser();
        repayBiz.setUserId(userId);
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
        repayBiz.setLoanStartDatetime(new Date());
        Date addMonths = DateUtils.addMonths(new Date(), order.getPeriods());
        repayBiz.setLoanEndDatetime(addMonths);

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
        repayBiz.setOverdueAmount(0L);
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
            repayBiz
                .setRestAmount(repayBiz.getRestAmount() - realWithholdAmount);
            repayBizDAO.updateRepayBizRestAmount(repayBiz);
        }
    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#refreshAdvanceRepayProduct(com.cdkj.loan.domain.RepayBiz, java.lang.Long)
     */
    @Override
    public void refreshAdvanceRepayProduct(RepayBiz repayBiz,
            Long realWithholdAmount) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#refreshRepayAllCarProduct(java.lang.String)
     */
    @Override
    public void refreshRepayAllCarProduct(String repayBizCode) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#confirmSettledCarProduct(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void confirmSettledCarProduct(RepayBiz repayBiz) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.cdkj.loan.bo.IRepayBizBO#refreshEnterBlackList(com.cdkj.loan.domain.RepayBiz)
     */
    @Override
    public void refreshEnterBlackList(RepayBiz data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void approveByQkcsDepartment(String code, String curNodeCode,
            Long cutLyDeposit, String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setCutLyDeposit(cutLyDeposit);
        repayBiz.setUpdater(updater);

        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.approveByQkcsDepart(repayBiz);
    }

    @Override
    public void approveByBankCheck(String code, String curNodeCode,
            Date settleDatetime, String settleAttach, String updater,
            String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setSettleDatetime(settleDatetime);
        repayBiz.setSettleAttach(settleAttach);

        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizDAO.approveByBankCheck(repayBiz);
    }

    @Override
    public void approveByManager(String code, String curNodeCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        repayBizDAO.approveByManager(repayBiz);
    }

    @Override
    public void approveByFinance(String code, String curNodeCode,
            String updater, String remark) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        repayBizDAO.approveByFinance(repayBiz);
    }

    @Override
    public void releaseMortgage(String code, String curNodeCode,
            Date releaseDatetime, String updater) {
        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(code);
        repayBiz.setCurNodeCode(curNodeCode);
        repayBiz.setReleaseDatetime(releaseDatetime);
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());

        repayBizDAO.releaseMortgage(repayBiz);
    }

    @Override
    public void applyTrailer(RepayBiz repayBiz) {
        repayBizDAO.applyTrailer(repayBiz);
    }

    @Override
    public void financialMoney(RepayBiz repayBiz) {
        repayBizDAO.financialMoney(repayBiz);
    }

    @Override
    public void trailerEntry(RepayBiz repayBiz) {
        repayBizDAO.trailerEntry(repayBiz);
    }

    @Override
    public void judicialLitigationEntry(RepayBiz repayBiz) {
        repayBizDAO.judicialLitigationEntry(repayBiz);
    }

    @Override
    public void trailerManage(RepayBiz repayBiz) {
        repayBizDAO.trailerManage(repayBiz);
    }

    @Override
    public void qkcsbRedeemApply(RepayBiz repayBiz) {
        repayBizDAO.qkcsbRedeemApply(repayBiz);
    }

    @Override
    public void riskManagerCheck(RepayBiz repayBiz) {
        repayBizDAO.riskManagerCheck(repayBiz);
    }

    @Override
    public void financeApprove(RepayBiz repayBiz) {
        repayBizDAO.financeApprove(repayBiz);
    }

    @Override
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
}
