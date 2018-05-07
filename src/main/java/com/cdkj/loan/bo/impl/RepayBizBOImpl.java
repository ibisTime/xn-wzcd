package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ERepayBizStatus;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanStatus;
import com.cdkj.loan.enums.ESysUser;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayBizBOImpl extends PaginableBOImpl<RepayBiz>
        implements IRepayBizBO {

    @Autowired
    private IRepayBizDAO repayBizDAO;

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
    public RepayBiz genereateNewCarLoanRepayBiz(LoanOrder loanOrder,
            String userId, String bankcardCode) {

        RepayBiz repayBiz = new RepayBiz();
        String code = OrderNoGenerater.generate("RB");

        repayBiz.setCode(code);
        repayBiz.setRefType(ERepayBizType.CAR.getCode());
        repayBiz.setRefCode(loanOrder.getCode());
        repayBiz.setUserId(userId);
        repayBiz.setBankcardCode(bankcardCode);

        repayBiz.setBizPrice(loanOrder.getCarPrice());
        repayBiz.setSfRate(loanOrder.getSfRate());
        repayBiz.setSfAmount(loanOrder.getSfAmount());
        repayBiz.setLoanBank(loanOrder.getLoanBank());
        repayBiz.setLoanAmount(loanOrder.getLoanAmount());

        repayBiz.setPeriods(loanOrder.getPeriods());
        repayBiz.setRestPeriods(loanOrder.getPeriods());
        repayBiz.setBankRate(loanOrder.getBankRate());
        repayBiz.setLoanStartDatetime(loanOrder.getLoanStartDatetime());
        repayBiz.setLoanEndDatetime(loanOrder.getLoanEndDatetime());

        repayBiz.setFxDeposit(loanOrder.getFxDeposit());
        repayBiz.setFirstRepayDatetime(loanOrder.getFirstRepayDatetime());
        repayBiz.setFirstRepayAmount(loanOrder.getFirstRepayAmount());
        repayBiz.setMonthDatetime(loanOrder.getMonthDatetime());
        repayBiz.setMonthAmount(loanOrder.getMonthAmount());

        repayBiz.setLyDeposit(loanOrder.getLyDeposit());
        repayBiz.setCutLyDeposit(0L);
        repayBiz.setStatus(ERepayPlanStatus.TO_REPAYMENTS.getCode());
        Long monthAmount = loanOrder.getMonthAmount();
        int periods = loanOrder.getPeriods();
        long amount = monthAmount * (long) (periods - 1);
        repayBiz.setRestAmount(amount);
        repayBiz.setRestTotalCost(0L);

        repayBiz.setTotalInDeposit(0L);
        repayBiz.setOverdueAmount(0L);
        repayBiz.setTotalOverdueCount(0);
        repayBiz.setCurOverdueCount(0);
        repayBiz.setBlackHandleNote("暂无");

        repayBiz.setUpdater(loanOrder.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(loanOrder.getRemark());

        repayBizDAO.insert(repayBiz);
        return repayBiz;
    }

    @Override
    public void repayCompleteNormal(String repayBizCode) {

        RepayBiz repayBiz = new RepayBiz();
        repayBiz.setCode(repayBizCode);
        repayBiz.setStatus(ERepayBizStatus.YET_REPAYMENTS.getCode());
        repayBiz.setUpdater(ESysUser.SYS_USER_HTWT.getCode());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark("本业务已正常还款");

        repayBizDAO.repayComplete(repayBiz);

    }

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

}
