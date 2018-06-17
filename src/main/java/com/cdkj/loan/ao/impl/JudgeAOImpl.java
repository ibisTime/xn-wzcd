package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630563Req;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECaseStatus;
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

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    @Transactional
    public String judgeApply(XN630560Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.JUDGE.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在司法诉讼节点！");
        }

        repayBizBO.refreshJudgeApply(req.getRepayBizCode());
        String code = judgeBO.saveJudge(req);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(nodeFlowBO
            .getNodeFlowByCurrentNode(repayBiz.getCurNodeCode()).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getRepayBizCode(),
            EBizLogType.REPAY_BIZ, req.getRepayBizCode(),
            repayBiz.getCurNodeCode(), node.getCode(), node.getValue(),
            req.getOperator());
        return code;
    }

    @Override
    @Transactional
    public void judgeFollow(XN630561Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.JUDGE_FOLLOW.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在诉讼跟进节点！");
        }

        // 判决时修改还款业务状态
        if (ECaseStatus.JUDGE.getCode().equals(req.getCaseStatus())) {
            repayBizBO.refreshJudgeFollow(repayBiz.getCode());
        }

        judgeBO.refreshJudgeFollow(req);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(nodeFlowBO
            .getNodeFlowByCurrentNode(repayBiz.getCurNodeCode()).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getCode(),
            EBizLogType.REPAY_BIZ, req.getCode(), repayBiz.getCurNodeCode(),
            node.getCode(), node.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void judgeResultInput(XN630562Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.JUDGE_RESULT_INPUT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在执行结果录入节点！");
        }

        repayBizBO.refreshJudgeResultInput(repayBiz.getCode());
        judgeBO.refreshJudgeResultInput(req);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(nodeFlowBO
            .getNodeFlowByCurrentNode(repayBiz.getCurNodeCode()).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getCode(),
            EBizLogType.REPAY_BIZ, req.getCode(), repayBiz.getCurNodeCode(),
            node.getCode(), node.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void financeSureReceipt(XN630563Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.FINANCE_SURE_RECEIPT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前业务不在财务确认收货节点！");
        }

        RepayBiz data = new RepayBiz();
        data.setCode(req.getCode());
        data.setJudgeReceiptDatetime(DateUtil.strToDate(
            req.getJudgeReceiptDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        data.setJudgeReceiptAmount(
            StringValidater.toLong(req.getJudgeReceiptAmount()));
        data.setJudgeReceiptBank(req.getJudgeReceiptBank());
        data.setJudgeReceiptBankcard(req.getJudgeReceiptBankcard());
        data.setJudgeBillPdf(req.getJudgeBillPdf());

        data.setJudgeNote(req.getJudgeNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        repayBizBO.refreshFinanceSureReceipt(data);

        Judge condition = new Judge();
        condition.setStatus(EBoolean.NO.getCode());
        condition.setRepayBizCode(req.getCode());
        Judge judge = judgeBO.selectJudge(condition);
        judgeBO.refreshFinanceSureReceipt(judge.getCode(), req.getOperator());

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(nodeFlowBO
            .getNodeFlowByCurrentNode(repayBiz.getCurNodeCode()).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getCode(),
            EBizLogType.REPAY_BIZ, req.getCode(), repayBiz.getCurNodeCode(),
            node.getCode(), node.getValue(), req.getOperator());
    }

    @Override
    public Paginable<Judge> queryJudgePage(int start, int limit,
            Judge condition) {
        Paginable<Judge> page = judgeBO.getPaginable(start, limit, condition);
        List<Judge> list = page.getList();
        for (Judge judge : list) {
            init(judge);
        }
        return page;
    }

    @Override
    public List<Judge> queryJudgeList(Judge condition) {
        List<Judge> list = judgeBO.queryJudgeList(condition);
        for (Judge judge : list) {
            init(judge);
        }
        return list;
    }

    @Override
    public Judge getJudge(String code) {
        Judge judge = judgeBO.getJudge(code);
        init(judge);
        return judge;
    }

    private void init(Judge judge) {
        judge.setUpdaterName(
            sysUserBO.getUser(judge.getUpdater()).getRealName());
    }
}
