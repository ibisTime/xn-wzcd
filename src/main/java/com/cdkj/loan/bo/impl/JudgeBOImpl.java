package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IJudgeDAO;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630565Req;
import com.cdkj.loan.dto.req.XN630566Req;
import com.cdkj.loan.dto.req.XN630567Req;
import com.cdkj.loan.dto.req.XN630568Req;
import com.cdkj.loan.dto.req.XN630569Req;
import com.cdkj.loan.dto.req.XN630580Req;
import com.cdkj.loan.dto.req.XN630581Req;
import com.cdkj.loan.dto.req.XN630582Req;
import com.cdkj.loan.dto.req.XN630583Req;
import com.cdkj.loan.dto.req.XN630584Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECaseStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class JudgeBOImpl extends PaginableBOImpl<Judge> implements IJudgeBO {

    @Autowired
    private IJudgeDAO judgeDAO;

    @Override
    public String saveJudge(XN630560Req req) {
        String code = null;
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        if (judge != null) {
            code = judge.getCode();
            judge.setPlaintiff(req.getPlaintiff());
            judge.setDefendant(req.getDefendant());
            judge.setCaseStatus(ECaseStatus.RECORD.getCode());
            judge.setCaseFee(StringValidater.toLong(req.getCaseFee()));
            judge.setUpdater(req.getOperator());
            judge.setUpdateDatetime(new Date());
            judgeDAO.updateJudge(judge);
        } else {
            Judge data = new Judge();
            code = OrderNoGenerater.generate(EGeneratePrefix.JUDGE.getCode());
            data.setCode(code);
            data.setRepayBizCode(req.getRepayBizCode());
            data.setPlaintiff(req.getPlaintiff());
            data.setDefendant(req.getDefendant());

            data.setCaseStatus(ECaseStatus.RECORD.getCode());
            data.setCaseFee(StringValidater.toLong(req.getCaseFee()));

            data.setStatus(EBoolean.NO.getCode());
            data.setUpdater(req.getOperator());
            data.setUpdateDatetime(new Date());
            judgeDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshJudgeResultInput(XN630562Req req) {
        Judge data = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        data.setExeResult(req.getExeResult());
        data.setRemark(req.getRemark());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        judgeDAO.updateJudgeResultInput(data);
    }

    @Override
    public List<Judge> queryJudgeList(Judge condition) {
        return judgeDAO.selectList(condition);
    }

    @Override
    public Judge getJudge(String code) {
        Judge data = null;
        if (StringUtils.isNotBlank(code)) {
            Judge condition = new Judge();
            condition.setCode(code);
            data = judgeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "对应诉讼信息不存在!");
            }
        }
        return data;
    }

    @Override
    public Judge queryJudgeByRepayBizCode(String repayBizCode,
            EBoolean status) {
        Judge condition = new Judge();
        condition.setRepayBizCode(repayBizCode);
        condition.setStatus(status.getCode());
        Judge judge = judgeDAO.select(condition);
        if (judge == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "对应诉讼信息不存在!");
        }
        return judge;
    }

    @Override
    public Judge getJudgeByRepaybizCode(String code) {
        Judge condition = new Judge();
        condition.setRepayBizCode(code);
        return judgeDAO.select(condition);
    }

    @Override
    public void cashier(XN630565Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setPayAmountProve(req.getPayAmountProve());
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.cashier(judge);
    }

    @Override
    public void acceptance(XN630566Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setAcceptanceTime(DateUtil.strToDate(req.getAcceptanceTime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setAcceptanceFee(StringValidater.toLong(req.getAcceptanceFee()));
        judge.setCaseNumber(req.getCaseNumber());
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.acceptance(judge);
    }

    @Override
    public void toHoldCourt(XN630567Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setCourtDatetime(DateUtil.strToDate(req.getCourtDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setCourtAddress(req.getCourtAddress());
        judge.setHandleJudge(req.getHandleJudge());
        judge.setSummonsDeliveryTime(DateUtil.strToDate(
            req.getSummonsDeliveryTime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.toHoldCourt(judge);
    }

    @Override
    public void sentence(XN630568Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setJudgePdf(req.getJudgePdf());
        judge.setJudgePdfDeliveryTime(DateUtil.strToDate(
            req.getJudgePdfDeliveryTime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.sentence(judge);
    }

    @Override
    public void takeEffect(XN630569Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setEffectiveTime(DateUtil.strToDate(req.getEffectiveTime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.takeEffect(judge);
    }

    @Override
    public void applyImplement(XN630580Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setExeApplyUser(req.getExeApplyUser());
        judge.setApplyDatetime(new Date());
        judge.setBeExeUser(req.getBeExeUser());
        if (StringUtils.isNotBlank(req.getExecuteMarkAmount())) {
            judge.setExecuteMarkAmount(
                StringValidater.toLong(req.getExecuteMarkAmount()));
        }
        if (StringUtils.isNotBlank(req.getRecoveryDatetime())) {
            judge.setRecoveryDatetime(DateUtil.strToDate(
                req.getRecoveryDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        }
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.applyImplement(judge);
    }

    @Override
    public void implementAdmissibility(XN630581Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setHandleJudge(req.getHandleJudge());
        judge.setCaseSubject(req.getCaseSubject());
        if (StringUtils.isNotBlank(req.getHearCaseNumber())) {
            judge.setHearCaseNumber(req.getHearCaseNumber());
        }
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.implementAdmissibility(judge);
    }

    @Override
    public void auction(XN630582Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setSaleDatetime(DateUtil.strToDate(req.getSaleDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.auction(judge);
    }

    @Override
    public void notice(XN630583Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setNoticeDatetime(DateUtil.strToDate(req.getNoticeDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.notice(judge);
    }

    @Override
    public void inputVerdict(XN630584Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setAdjudicationDeadline(DateUtil.strToDate(
            req.getAdjudicationDeadline(), DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setStatus(EBoolean.YES.getCode());
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.inputVerdict(judge);
    }

}
