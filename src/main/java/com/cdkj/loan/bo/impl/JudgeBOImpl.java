package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
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
        Judge data = new Judge();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.JUDGE.getCode());
        data.setCode(code);
        data.setRepayBizCode(req.getRepayBizCode());
        data.setCaseNumber(req.getCaseNumber());
        data.setPlaintiff(req.getPlaintiff());
        data.setDefendant(req.getDefendant());

        data.setCaseSubject(req.getCaseSubject());
        data.setCaseStatus(ECaseStatus.RECORD.getCode());
        data.setCaseFee(StringValidater.toLong(req.getCaseFee()));
        data.setCaseStartDatetime(DateUtil.strToDate(
            req.getCaseStartDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCasePdf(req.getCasePdf());

        data.setStatus(EBoolean.NO.getCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        judgeDAO.insert(data);
        return code;
    }

    @Override
    public void refreshJudgeFollow(XN630561Req req) {
        Judge data = queryJudgeByRepayBizCode(req.getCode(), EBoolean.NO);
        data.setCaseFee(StringValidater.toLong(req.getCaseFee()));
        data.setCaseStatus(req.getCaseStatus());
        data.setCourtDatetime(DateUtil.strToDate(req.getCourtDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setJudgeDatetime(DateUtil.strToDate(req.getJudgeDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setJudgePdf(req.getJudgePdf());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        judgeDAO.updateJudgeFollow(data);
    }

    @Override
    public void refreshJudgeResultInput(XN630562Req req) {
        Judge data = queryJudgeByRepayBizCode(req.getCode(), EBoolean.NO);
        data.setExeCaseNumber(req.getExeCaseNumber());
        data.setExeApplyUser(req.getExeApplyUser());
        data.setExeDatetime(DateUtil.strToDate(req.getExeDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExeResult(req.getExeResult());

        data.setSaleDatetime(DateUtil.strToDate(req.getSaleDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExePdf(req.getExePdf());
        data.setStatus(EBoolean.YES.getCode());
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
    public Judge queryJudgeByRepayBizCode(String repayBizCode, EBoolean status) {
        Judge data = null;

        Judge condition = new Judge();
        condition.setRepayBizCode(repayBizCode);
        condition.setStatus(status.getCode());
        List<Judge> list = judgeDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "对应诉讼信息不存在!");
        }
        return data;
    }
}
