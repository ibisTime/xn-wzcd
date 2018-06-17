package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630563Req;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.exception.BizException;

/**
 * 司法诉讼
 * @author: silver 
 * @since: 2018年6月16日 下午8:34:53 
 * @history:
 */
@Service
public class JudgeAOImpl implements IJudgeAO {
    @Autowired
    private IJudgeBO judgeBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Override
    @Transactional
    public String judgeApply(XN630560Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.JUDGE.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在司法诉讼节点！");
        }

        Judge data = new Judge();
        data.setRepayBizCode(req.getRepayBizCode());
        data.setCaseNumber(req.getCaseNumber());
        data.setPlaintiff(req.getPlaintiff());
        data.setDefendant(req.getDefendant());
        data.setCaseSubject(req.getCaseSubject());

        data.setCaseFee(StringValidater.toLong(req.getCaseFee()));
        data.setCaseStartDatetime(DateUtil.strToDate(req.getCaseStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCasePdf(req.getCasePdf());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());

        repayBizBO.refreshJudgeApply(req.getRepayBizCode());
        return judgeBO.saveJudge(data);
    }

    @Override
    @Transactional
    public void judgeFollow(XN630561Req req) {
        Judge judge = judgeBO.getJudge(req.getCode());
        RepayBiz repayBiz = repayBizBO.getRepayBiz(judge.getRepayBizCode());
        if (!ERepayBizNode.JUDGE_FOLLOW.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在诉讼跟进节点！");
        }

        Judge data = new Judge();
        data.setCode(req.getCode());
        data.setCaseFee(StringValidater.toLong(req.getCaseFee()));
        data.setCaseStatus(req.getCaseStatus());
        data.setCourtDatetime(DateUtil.strToDate(req.getCourtDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setJudgeDatetime(DateUtil.strToDate(req.getJudgeDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setJudgePdf(req.getJudgePdf());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayBizBO.refreshJudgeFollow(repayBiz.getCode());
        judgeBO.refreshJudgeFollow(data);
    }

    @Override
    @Transactional
    public void judgeResultEntry(XN630562Req req) {
        Judge judge = judgeBO.getJudge(req.getCode());
        RepayBiz repayBiz = repayBizBO.getRepayBiz(judge.getRepayBizCode());
        if (!ERepayBizNode.JUDGE_RESULT_INPUT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在执行结果录入节点！");
        }

        Judge data = new Judge();
        data.setCode(req.getCode());
        data.setExeCaseNumber(req.getExeCaseNumber());
        data.setExeApplyUser(req.getExeApplyUser());
        data.setExeDatetime(DateUtil.strToDate(req.getExeDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExeResult(req.getExeResult());

        data.setSaleDatetime(DateUtil.strToDate(req.getSaleDatetime(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setExePdf(req.getExePdf());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayBizBO.refreshJudgeResultInput(repayBiz.getCode());
        judgeBO.refreshJudgeResultEntry(data);
    }

    @Override
    public void financeSureReceipt(XN630563Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.FINANCE_SURE_RECEIPT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在财务确认收货节点！");
        }

        RepayBiz data = new RepayBiz();
        data.setCode(req.getCode());
        data.setJudgeReceiptDatetime(DateUtil.strToDate(
            req.getJudgeReceiptDatetime(), DateUtil.DB_DATE_FORMAT_STRING));
        data.setJudgeReceiptAmount(
            StringValidater.toLong(req.getJudgeReceiptAmount()));
        data.setJudgeReceiptBank(req.getJudgeReceiptBank());
        data.setJudgeReceiptBankcard(req.getJudgeReceiptBankcard());
        data.setJudgeBillPdf(req.getJudgeBillPdf());

        data.setJudgeNote(req.getJudgeNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayBizBO.refreshFinanceSureReceipt(data);
    }

    @Override
    public Paginable<Judge> queryJudgePage(int start, int limit,
            Judge condition) {
        return judgeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Judge> queryJudgeList(Judge condition) {
        return judgeBO.queryJudgeList(condition);
    }

    @Override
    public Judge getJudge(String code) {
        return judgeBO.getJudge(code);
    }

}
