package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICostAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.ICostBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.IOverdueTreatmentBO;
import com.cdkj.loan.bo.IRemindLogBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.domain.OverdueTreatment;
import com.cdkj.loan.domain.RemindLog;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.dto.req.XN630535Req;
import com.cdkj.loan.dto.req.XN630537Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECollectionResult;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.enums.EReplaceIsRepayStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayPlanAOImpl implements IRepayPlanAO {

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayBizAO repayBizAO;

    @Autowired
    private ICostAO costAO;

    @Autowired
    private ICostBO costBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    IRemindLogBO remindLogBO;

    @Autowired
    ICollectBankcardBO collectBankcardBO;

    @Autowired
    IBankcardBO bankcardBO;

    @Autowired
    IReplaceRepayApplyBO replaceRepayApplyBO;

    @Autowired
    IOverdueTreatmentBO overdueTreatmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    private static final Logger logger = LoggerFactory
        .getLogger(RepayPlanAOImpl.class);

    @Override
    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition) {
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            if (StringUtils.isNotBlank(repayPlan.getUserId())) {
                User user = userBO.getUser(repayPlan.getUserId());
                repayPlan.setUser(user);
                repayPlan.setRealName(user.getRealName());
                repayPlan.setRepayBiz(repayBizAO.getRepayBiz(repayPlan
                    .getRepayBizCode()));
            }
            // 未还清收成本
            repayPlan.setNotPayedFee(repayPlan.getTotalFee()
                    - repayPlan.getPayedFee());
        }
        return results;
    }

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanBO.queryRepayPlanList(condition);
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        // 获取用户信息和业务信息
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        repayPlan.setRepayBiz(repayBizAO.getRepayBiz(repayPlan
            .getRepayBizCode()));// 要展示转义字段，所以调用AO层

        // 获取清收成本
        Cost cost = new Cost();
        cost.setRepayPlanCode(code);
        List<Cost> list = costBO.queryCostList(cost);
        repayPlan.setCostList(list);

        // 逾期处理记录
        OverdueTreatment overdueTreatment = new OverdueTreatment();
        overdueTreatment.setRepayPlanCode(code);
        List<OverdueTreatment> overdueTreatmentList = overdueTreatmentBO
            .queryOverdueTreatmentList(overdueTreatment);
        repayPlan.setOverdueTreatmentList(overdueTreatmentList);

        // 获取催收记录
        RemindLog rlCondition = new RemindLog();
        rlCondition.setRepayPlanCode(code);
        List<RemindLog> remindLogList = remindLogBO
            .queryRemindLogList(rlCondition);
        repayPlan.setRemindLogList(remindLogList);

        // 获取银行卡号
        String bankcardCode = repayBizBO.getRepayBiz(
            repayPlan.getRepayBizCode()).getBankcardCode();
        String bankcardNumber = bankcardBO.getBankcard(bankcardCode)
            .getBankcardNumber();
        repayPlan.setBankcardNumber(bankcardNumber);

        // 获取代偿记录
        ReplaceRepayApply condition = new ReplaceRepayApply();
        RepayPlan data = repayPlanBO.getRepayPlan(repayPlan.getCode());
        condition.setBizCode(data.getRepayBizCode());
        List<ReplaceRepayApply> repayApplyList = replaceRepayApplyBO
            .queryReplaceRepayApplyList(condition);
        if (CollectionUtils.isNotEmpty(repayApplyList)) {
            repayPlan.setReplaceRepayApply(repayApplyList.get(0));
        }

        if (StringUtils.isNotBlank(repayPlan.getRemitBankCode())) {
            CollectBankcard collectBankcard = collectBankcardBO
                .getCollectBankcard(repayPlan.getRemitBankCode());
            repayPlan.setRemitBankName(collectBankcard.getBankName());
        }

        // 未还清收成本
        repayPlan.setNotPayedFee(repayPlan.getTotalFee()
                - repayPlan.getPayedFee());

        return repayPlan;
    }

    // 当月还款名单查询
    @Override
    public Object queryCurrentMonthRepayPage(int start, int limit,
            RepayPlan condition) {
        condition.setRepayStartDatetime(DateUtil.getFirstDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(repayBizBO.getRepayBiz(repayPlan
                .getRepayBizCode()));
            Long monthRepayAmount = repayPlan.getRepayCapital()
                    * repayPlan.getRepayInterest();
            repayPlan.setRepayAmount(monthRepayAmount);
        }
        return results;
    }

    // 催收过程
    @Override
    @Transactional
    public void collectionProcess(XN630537Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        if (!ERepayPlanNode.OVERDUE.getCode()
            .equals(repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划不是逾期状态");
        }
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan.getRepayBizCode());
        if (!ERepayBizNode.TO_REPAY.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不是还款中，暂无法处理");
        }

        // 催收过程
        OverdueTreatment data = new OverdueTreatment();
        data.setRepayPlanCode(repayPlan.getCode());
        data.setCollectionWay(req.getCollectionWay());
        data.setCollectionTarget(req.getCollectionTarget());
        data.setCollectionProcess(req.getCollectionProcess());
        data.setCollectionWish(req.getCollectionWish());
        data.setCollectionProcessNote(req.getCollectionProcessNote());
        data.setCollectionType(EBoolean.NO.getCode());
        String code = overdueTreatmentBO.saveOverdueTreatment(data);

        // 添加费用清单
        costAO.addCost(req.getCode(), code, req.getCostList());
        Long totalFee = repayPlan.getTotalFee();
        if (totalFee == null) {
            totalFee = 0L;
        }
        for (XN630535Req xn630535Req : req.getCostList()) {
            totalFee += StringValidater.toLong(xn630535Req.getAmount());
        }
        // 更新还款计划
        repayPlan.setTotalFee(totalFee);// 清收费用总额
    }

    // 催收结果
    @Override
    @Transactional
    public void overdueHandle(XN630532Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        if (!ERepayPlanNode.OVERDUE.getCode()
            .equals(repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划不是逾期状态");
        }
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan.getRepayBizCode());
        if (!ERepayBizNode.TO_REPAY.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不是还款中，暂无法处理");
        }

        // 催收结果
        OverdueTreatment data = new OverdueTreatment();
        data.setRepayPlanCode(repayPlan.getCode());
        data.setCollectionResult(req.getCollectionResult());
        data.setDepositIsProvide(req.getDepositIsProvide());
        data.setCollectionType(EBoolean.YES.getCode());
        if (StringUtils.isNotBlank(req.getOverdueDeposit())) {
            data.setOverdueDeposit(StringValidater.toLong(req
                .getOverdueDeposit()));
        }
        data.setCollectionResultNote(req.getCollectionResultNote());
        if (StringUtils.isNotBlank(req.getRealRepayAmount())) {
            data.setRealRepayAmount(StringValidater.toLong(req
                .getRealRepayAmount()));// 部分还款实还金额
        }
        String code = overdueTreatmentBO.saveOverdueTreatment(data);

        // 添加费用清单
        costAO.addCost(req.getCode(), code, req.getCostList());
        Long totalFee = repayPlan.getTotalFee();
        if (totalFee == null) {
            totalFee = 0L;
        }
        for (XN630535Req xn630535Req : req.getCostList()) {
            totalFee += StringValidater.toLong(xn630535Req.getAmount());
        }

        // 更新还款计划
        repayPlan.setTotalFee(repayPlan.getTotalFee() + totalFee);

        User user = userBO.getUser(repayPlan.getUserId());
        if (ECollectionResult.ALL_REPAY.getCode().equals(
            req.getCollectionResult())) {// 全额还款
            repayPlan.setCurNodeCode(ERepayPlanNode.HANDLER_TO_GREEN.getCode());
            repayPlan.setOverdueAmount(0L);
            repayPlan.setPayedAmount(repayPlan.getRepayAmount());
            // 剩余期数 = 总期数-还款计划的当前期数
            repayBiz.setRestPeriods(repayBiz.getPeriods()
                    - repayPlan.getCurPeriods());

            userBO.refreshGreenSign(user, req.getOperator());
        } else if (ECollectionResult.PART_REPAY.getCode().equals(
            req.getCollectionResult())) {
            if (EBoolean.YES.getCode().equals(req.getDepositIsProvide())) {
                repayPlan.setDepositIsProvide(EBoolean.YES.getCode());
                repayPlan.setOverdueDeposit(StringValidater.toLong(req
                    .getOverdueDeposit()));
            }
            Long realRepayAmount = StringValidater.toLong(req
                .getRealRepayAmount());
            repayPlan.setPayedAmount(repayPlan.getPayedAmount()
                    + realRepayAmount);// 已还金额
            repayPlan.setOverplusAmount(repayPlan.getRepayAmount()
                    - repayPlan.getPayedAmount());
            // 多次部分还款，还完后进绿名单
            if (repayPlan.getOverdueAmount() == 0) {
                repayPlan.setCurNodeCode(ERepayPlanNode.HANDLER_TO_GREEN
                    .getCode());
            }
        } else if (ECollectionResult.REJUST_REPAY.getCode().equals(
            req.getCollectionResult())
                || ECollectionResult.TAKE_CAR.getCode().equals(
                    req.getCollectionResult())) {
            repayPlan.setCurNodeCode(ERepayPlanNode.HANDLER_TO_RED.getCode());

            userBO.refreshRedSign(user, req.getOperator());
        } else if (ECollectionResult.REPLACE_REPAY.getCode().equals(
            req.getCollectionResult())) {
            repayPlan
                .setCurNodeCode(ERepayPlanNode.HANDLER_TO_YELLOW.getCode());

            // 剩余期数 = 总期数-还款计划的当前期数
            repayBiz.setRestPeriods(repayBiz.getPeriods()
                    - repayPlan.getCurPeriods());

            userBO.refreshYellowSign(user, req.getOperator());
        } else if (ECollectionResult.JUDGE.getCode().equals(
            req.getCollectionResult())) {
            repayPlan.setCurNodeCode(ERepayPlanNode.JUDGE.getCode());
            userBO.refreshBlackSign(user, req.getOperator());
        }
        repayPlanBO.refreshOverdueHandle(repayPlan);

        // 红名单更新收车节点,司法诉讼则直接进去诉讼，无需收车
        String nextNode = repayBiz.getCurNodeCode();
        if (ERepayPlanNode.HANDLER_TO_RED.getCode().equals(
            repayPlan.getCurNodeCode())) {
            nextNode = ERepayBizNode.TC_APPLY.getCode();
            sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), nextNode);
        }
        if (ERepayPlanNode.JUDGE.getCode().equals(repayPlan.getCurNodeCode())) {
            nextNode = ERepayBizNode.JUDGE.getCode();
            sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), nextNode);
        }
        repayBizBO.overdueRedMenuHandle(repayBiz, nextNode);
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_PLAN,
            repayPlan.getCode(), ERepayPlanNode.OVERDUE.getCode(),
            req.getCollectionResultNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void payFee(String code, List<String> costList, String operator,
            String payType) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        // TODO 支付方式 扣款
        long totalFee = 0L;
        for (String costCode : costList) {
            Cost cost = costBO.getCost(costCode);
            if (EBoolean.YES.getCode().equals(cost.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前清收成本已缴纳");
            }
            totalFee += cost.getAmount();
            costBO.refreshRepay(cost, payType);
        }
        repayPlan.setTotalFee(repayPlan.getTotalFee() - totalFee);
        if (repayPlan.getPayedFee() == null) {
            repayPlan.setPayedFee(0L);
        }
        Long totalPayedFee = totalFee + repayPlan.getPayedFee(); // 现在总的支付费用
        repayPlan.setPayedFee(totalPayedFee);
        repayPlanBO.payFee(repayPlan);
    }

    @Override
    @Transactional
    public void payCompensatoryAmount(String code, String operator,
            String payType, Long payAmount) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        if (!ERepayPlanNode.HANDLER_TO_YELLOW.getCode().equals(
            repayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划不在黄名单上");
        }
        if (repayPlan.getOverdueAmount().longValue() < repayPlan
            .getReplaceRealRepayAmount().longValue()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划的逾期金额已全部代偿");
        }
        if (repayPlan.getOverdueAmount().longValue() < (repayPlan
            .getReplaceRealRepayAmount().longValue() + payAmount)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款计划的已代偿金额加本次代偿金额已超过逾期金额");
        }
        repayPlan.setReplaceRealRepayAmount(repayPlan
            .getReplaceRealRepayAmount() + payAmount);
        if (repayPlan.getOverdueAmount().longValue() == repayPlan
            .getReplaceRealRepayAmount().longValue()) {
            repayPlan.setReplaceIsRepay(EReplaceIsRepayStatus.REPLACE_ALL
                .getCode());
        } else {
            repayPlan.setReplaceIsRepay(EReplaceIsRepayStatus.REPLACE_PART
                .getCode());
        }
        repayPlanBO.payCompensatoryAmount(repayPlan);

        // TODO 支付方式
    }

    @Override
    public void doMakeBlack(String code) {
        // RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        // repayPlan.setCurNodeCode(ERepayPlanNode.PRD_HANDLER_TO_BLACK.getCode());
        // repayPlanBO.refreshToBlackProduct(repayPlan);
    }

    @Override
    public Long getUnsettledLoan() {
        RepayPlan condition = new RepayPlan();
        List<RepayPlan> results = repayPlanBO.queryRepayPlanList(condition);
        Long unsettledLoan = 0L;
        for (RepayPlan repayPlan : results) {
            if (repayPlan.getCurNodeCode().equals(
                ERepayPlanNode.OVERDUE.getCode())
                    || repayPlan.getCurNodeCode().equals(
                        ERepayPlanNode.HANDLER_TO_GREEN.getCode())) {
                Long amount = repayPlan.getTotalFee() - repayPlan.getPayedFee()
                        + repayPlan.getOverplusAmount();
                unsettledLoan = unsettledLoan + amount;
            }
        }
        return unsettledLoan;
    }

    @Override
    public Paginable<RepayPlan> queryRepayPlanPageByRoleCode(int start,
            int limit, RepayPlan condition) {
        Paginable<RepayPlan> paginable = repayPlanBO.getPaginableByRoleCode(
            start, limit, condition);
        for (RepayPlan repayPlan : paginable.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(repayBizAO.getRepayBiz(repayPlan
                .getRepayBizCode()));

        }
        return paginable;
    }

    @Override
    public void doPayedDaily() {
        logger.info("***************开始扫结束还款计划***************");
        SYSConfig sysConfig = sysConfigBO
            .getSYSConfig(SysConstants.REPAYPLAN_STEP);
        int step = Integer.valueOf(sysConfig.getCvalue()); // 每次处理的条数
        while (true) {
            RepayPlan condition = new RepayPlan();
            condition.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
            condition.setRepayStartDatetime(DateUtil.getFirstDay());
            condition.setRepayEndDatetime(DateUtil.getLastDay());
            Paginable<RepayPlan> page = repayPlanBO.getPaginable(0, step,
                condition);
            List<RepayPlan> list = page.getList();
            if (CollectionUtils.isNotEmpty(list)) {
                doDailyRepayPlan(list);
                if (list.size() < step) {// 最后一批
                    break;
                }
            } else {
                break;
            }
        }
        logger.info("***************结束扫结束还款计划***************");
    }

    private void doDailyRepayPlan(List<RepayPlan> list) {
        for (RepayPlan repayPlan : list) {
            // 1、将还款计划更新为 已还款
            // 2、如果还款计划已全部完成，将还款业务更新为 提交结算单
            repayPlanBO.refreshPayedDaily(repayPlan.getCode());
            RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan
                .getRepayBizCode());
            repayBizBO.refreshRestAmount(repayBiz, repayPlan.getRepayAmount());// 更新剩余欠款
            if (repayPlan.getPeriods() == repayPlan.getCurPeriods()) {
                repayBizBO.refreshRepayEndCommitSettle(repayPlan
                    .getRepayBizCode());
            }
        }
    }

}
