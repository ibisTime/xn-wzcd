package com.cdkj.loan.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.req.XN630556Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.enums.EReplaceIsRepayStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayPlanBOImpl extends PaginableBOImpl<RepayPlan> implements
        IRepayPlanBO {

    @Autowired
    private IRepayPlanDAO repayPlanDAO;

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public List<RepayPlan> queryRepayPlanListByRepayBizCode(
            String repayBizCode, List<String> curNodeList) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCodeList(curNodeList);
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public RepayPlan getRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(repayPlanNode.getCode());
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        RepayPlan data = null;
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前还款业务没有"
                    + repayPlanNode.getValue() + "的记录");
        }
        return data;
    }

    @Override
    public RepayPlan getRepayPlanByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(repayPlanNode.getCode());
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        RepayPlan data = null;
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        }
        return data;
    }

    // 当月
    @Override
    public RepayPlan getRepayPlanCurMonth(String repayBizCode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setRepayStartDatetime(DateUtil.getFirstDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        RepayPlan data = null;
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        }
        return data;
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan condition = new RepayPlan();
            condition.setCode(code);
            data = repayPlanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "还款计划不存在");
            }
        }
        return data;
    }

    @Override
    public void genereateNewRepayPlan(RepayBiz repayBiz) {

        List<RepayPlan> repayPlanList = new ArrayList<RepayPlan>();

        for (int i = 0; i < repayBiz.getPeriods(); i++) {

            RepayPlan repayPlan = new RepayPlan();

            int curPeriod = i + 1;

            String code = OrderNoGenerater.generate(EGeneratePrefix.REPAY_PLAN
                .getCode()) + curPeriod;

            Long repayCapital = repayBiz.getMonthAmount();
            if (i == 0) {
                repayCapital = repayBiz.getFirstRepayAmount();
            }

            Date repayDatetime = getRepayDatetime(
                repayBiz.getFirstRepayDatetime(), repayBiz.getMonthDatetime(),
                curPeriod);

            repayPlan.setCode(code);
            repayPlan.setRefType(repayBiz.getRefType());
            repayPlan.setRepayBizCode(repayBiz.getCode());
            repayPlan.setUserId(repayBiz.getUserId());
            repayPlan.setPeriods(repayBiz.getPeriods());
            repayPlan.setCurPeriods(curPeriod);

            repayPlan.setRepayDatetime(repayDatetime);
            repayPlan.setRepayCapital(repayCapital);
            repayPlan.setRepayInterest(0L);
            repayPlan.setPayedAmount(0L);

            // 每期应还金额
            long shouldRepayAmount = repayPlan.getRepayCapital()
                    + repayPlan.getRepayInterest();
            repayPlan.setOverplusAmount(shouldRepayAmount);
            repayPlan.setOverdueAmount(0L);
            if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
                repayPlan.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
            } else if (ERepayBizType.PRODUCT.getCode().equals(
                repayBiz.getRefType())) {
                repayPlan.setCurNodeCode(ERepayPlanNode.PRD_TO_REPAY.getCode());
            }
            repayPlan.setTotalFee(0L);
            repayPlan.setPayedFee(0L);

            repayPlan.setOverdueDeposit(0L);
            repayPlan.setRepayIsPart(EBoolean.NO.getCode());
            repayPlan.setRealRepayAmount(0L);
            repayPlan.setRemindCount(0);
            repayPlan.setReplaceRealRepayAmount(0L);
            repayPlan.setReplaceIsRepay(EReplaceIsRepayStatus.TO_REPLACE
                .getCode());
            repayPlan.setReplaceBackRepayAmount(0L);
            repayPlanList.add(repayPlan);
        }
        repayPlanDAO.insertList(repayPlanList);
    }

    @Override
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan.setPayedAmount(repayPlan.getPayedAmount()
                + realWithholdAmount);

        repayPlan.setOverplusAmount(repayPlan.getOverplusAmount()
                - realWithholdAmount);

        repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());

        repayPlanDAO.repayResultHandle(repayPlan);
    }

    @Override
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan.setPayedAmount(repayPlan.getPayedAmount()
                + realWithholdAmount);

        repayPlan.setOverplusAmount(repayPlan.getOverplusAmount()
                - realWithholdAmount);

        repayPlanDAO.repayPartSuccess(repayPlan);
    }

    @Override
    public void refreshRepayPlanOverdue(RepayPlan repayPlan) {
        repayPlanDAO.updateOverdue(repayPlan);
    }

    /**
     * @param firstRepayDatetime 第一期还款时间
     * @param monthDatetime 每月还款日期
     * @param period 第几期
     * @return 
     * @create: 2018年5月6日 下午3:44:31 haiqingzheng
     * @history:
     */
    private Date getRepayDatetime(Date firstRepayDatetime, int monthDatetime,
            int curPeriod) {
        Date repayDatetime = null;
        if (curPeriod < 1) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "计算每月还款日期发送错误，还款期数必须大于0");
        }
        if (curPeriod == 1) {
            repayDatetime = firstRepayDatetime;
        } else {
            repayDatetime = DateUtil.getIntervalDate(firstRepayDatetime,
                curPeriod - 1, monthDatetime);
        }
        return repayDatetime;
    }

    @Override
    public boolean checkRepayComplete(String repayBizCode, String repayPlanCode) {

        boolean isComplete = true;

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);

        List<RepayPlan> repayPlans = repayPlanDAO.selectList(condition);

        if (CollectionUtils.isNotEmpty(repayPlans)) {
            for (RepayPlan repayPlan : repayPlans) {
                if (ERepayPlanNode.TO_REPAY.getCode().equals(
                    repayPlan.getCurNodeCode())
                        && !repayPlan.getCode().equals(repayPlanCode)) {
                    isComplete = false;
                    break;
                }
            }
        }
        return isComplete;

    }

    @Override
    public boolean checkPreUnpay(String repayBizCode, int curPeriod) {
        boolean flag = false;
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setOrder("cur_periods", true);
        List<RepayPlan> repayPlans = repayPlanDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(repayPlans)) {
            for (RepayPlan repayPlan : repayPlans) {
                if (repayPlan.getCurPeriods() >= curPeriod) {
                    break;
                }
                if (ERepayPlanNode.TO_REPAY.getCode().equals(
                    repayPlan.getCurNodeCode())
                        || ERepayPlanNode.HANDLER_TO_RED.getCode().equals(
                            repayPlan.getCurNodeCode())
                        || ERepayPlanNode.QKCSB_APPLY_TC.getCode().equals(
                            repayPlan.getCurNodeCode())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public void refreshOverdueHandle(RepayPlan repayPlan) {
        repayPlanDAO.updateOverdueHandle(repayPlan);
    }

    @Override
    public void refreshToGreen(RepayPlan repayPlan) {
        repayPlanDAO.updateOverdueHandle(repayPlan);
    }

    @Override
    public void refreshToBlackProduct(RepayPlan repayPlan) {
        repayPlanDAO.updateOverdueHandle(repayPlan);
    }

    @Override
    public void payFee(RepayPlan repayPlan) {
        repayPlanDAO.payFee(repayPlan);
    }

    @Override
    public void repayAmount(RepayPlan repayPlan) {
        repayPlanDAO.repayAmount(repayPlan);
    }

    @Override
    public void refreshRepayPlanTakeCarHandle(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        List<String> nodeList = new ArrayList<String>();
        nodeList.add(ERepayPlanNode.TO_REPAY.getCode());
        nodeList.add(ERepayPlanNode.QKCSB_APPLY_TC.getCode());
        List<RepayPlan> planList = queryRepayPlanListByRepayBizCode(
            repayBizCode, nodeList);
        for (RepayPlan repayPlan : planList) {
            repayPlan.setCurNodeCode(repayPlanNode.getCode());
            if (repayPlan.getCurNodeCode().equals(
                ERepayPlanNode.BAD_DEBT.getCode())) {
                repayPlan.setPayedAmount(0L);
                repayPlan.setOverplusAmount(repayPlan.getMonthRepayAmount());
            } else {
                repayPlan.setPayedAmount(repayPlan.getMonthRepayAmount());
                repayPlan.setOverplusAmount(0L);
            }
            repayPlanDAO.repayResultHandle(repayPlan);
        }
    }

    @Override
    public Paginable<RepayPlan> getPaginableByRoleCode(int start, int limit,
            RepayPlan condition) {
        prepare(condition);
        long totalCount = repayPlanDAO.selectTotalCountByRoleCode(condition);
        Page<RepayPlan> page = new Page<RepayPlan>(start, limit, totalCount);
        List<RepayPlan> dataList = repayPlanDAO.selectRepayPlanByRoleCode(
            condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public int getTotalCount(String repayPlanCode, ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setCode(repayPlanCode);
        condition.setCurNodeCode(repayPlanCode);
        return (int) repayPlanDAO.selectTotalCount(condition);
    }

    @Override
    public void takeCarApply(RepayPlan data, XN630550Req req) {
        data.setPawnshopIsRedeem(req.getPawnshopIsRedeem());
        data.setPawnshopName(req.getPawnshopName());
        data.setRansom(req.getRansom());
        data.setTsCarAmount(StringValidater.toLong(req.getTsCarAmount()));
        data.setTsBankcardNumber(req.getTsBankcardNumber());
        data.setTsBankName(req.getTsBankName());
        data.setTsSubbranch(req.getTsSubbranch());
        data.setTcApplyNote(req.getTcApplyNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setRemark("申请拖车");
        repayPlanDAO.updateTakeCarApply(data);
    }

    @Override
    public void takeCarSureFk(RepayPlan data, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator) {
        data.setRemitBankCode(remitBankCode);
        data.setRemitBillPdf(remitBillPdf);
        data.setRemitDatetime(remitDatetime);
        data.setUpdater(operator);
        data.setUpdateDatetime(new Date());
        data.setRemark("确认收款");
        repayPlanDAO.updateTakeCarApply(data);
    }

    @Override
    public void takeCarInputResult(RepayPlan data, XN630556Req req) {
        data.setTakeCarAddress(req.getTakeCarAddress());
        data.setTakeDatetime(DateUtil.strToDate(req.getTakeDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setTakeName(req.getTakeName());
        data.setTakeLocation(req.getTakeLocation());
        data.setTakeNote(req.getTakeNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayPlanDAO.updateTakeCarInputResult(data);
    }

    @Override
    public void takeCarResultHandle(RepayPlan data, XN630557Req req) {
        data.setDealResult(req.getDealResult());
        data.setSellPrice(StringValidater.toLong(req.getSellPrice()));
        data.setDeposit(StringValidater.toLong(req.getDeposit()));
        data.setFeeNote(req.getFeeNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayPlanDAO.updateTakeCarInputResult(data);
    }
}
