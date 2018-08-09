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
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECaseStatus;
import com.cdkj.loan.enums.EExeResult;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class JudgeBOImpl extends PaginableBOImpl<Judge> implements IJudgeBO {

    @Autowired
    private IJudgeDAO judgeDAO;

    @Override
    public String saveJudge(XN630560Req req) {
        Judge data = new Judge();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.JUDGE.getCode());
        data.setCode(code);
        data.setRepayBizCode(req.getRepayBizCode());
        data.setPlaintiff(req.getPlaintiff());
        data.setDefendant(req.getDefendant());

        data.setCaseSubject(req.getCaseSubject());
        data.setCaseStatus(ECaseStatus.RECORD.getCode());
        data.setCaseFee(StringValidater.toLong(req.getCaseFee()));
        data.setCaseStartDatetime(DateUtil.strToDate(req.getCaseStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCasePdf(req.getCasePdf());

        data.setStatus(EBoolean.NO.getCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        judgeDAO.insert(data);
        return code;
    }

    @Override
    public void refreshJudgeResultInput(XN630562Req req) {
        Judge data = queryJudgeByRepayBizCode(req.getCode(), EBoolean.NO);
        data.setExeCaseNumber(req.getExeCaseNumber());
        data.setExeApplyUser(req.getExeApplyUser());
        data.setExecuteMarkAmount(
            StringValidater.toLong(req.getExecuteMarkAmount()));
        data.setExeDatetime(DateUtil.strToDate(req.getExeDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExeResult(req.getExeResult());

        data.setSaleDatetime(DateUtil.strToDate(req.getSaleDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExePdf(req.getExePdf());
        if (!EExeResult.ABORT.getCode().equals(req.getExeResult())) {
            data.setStatus(EBoolean.YES.getCode());
        }
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
        judge.setHearCaseNumber(req.getHearCaseNumber());
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.toHoldCourt(judge);
    }

    @Override
    public void sentence(XN630568Req req) {
        Judge judge = queryJudgeByRepayBizCode(req.getRepayBizCode(),
            EBoolean.NO);
        judge.setJudgeDatetime(DateUtil.strToDate(req.getJudgeDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setJudgeResult(req.getJudgeResult());
        judge.setJudgePdf(req.getJudgePdf());
        judge.setJudgePdfDeliveryTime(DateUtil.strToDate(
            req.getJudgePdfDeliveryTime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setEffectiveTime(DateUtil.strToDate(req.getEffectiveTime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        judge.setUpdater(req.getOperator());
        judge.setUpdateDatetime(new Date());
        judgeDAO.sentence(judge);
    }

}
