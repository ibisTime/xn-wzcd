package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IJudgeAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630564Req;
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
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EExeResult;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayPlanNode;
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
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    @Transactional
    public String judgeApply(XN630560Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.JUDGE.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在司法诉讼节点！");
        }

        repayBizBO.refreshJudgeApply(req.getRepayBizCode());
        String code = judgeBO.saveJudge(req);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(nodeFlowBO
            .getNodeFlowByCurrentNode(repayBiz.getCurNodeCode()).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getRepayBizCode(),
            EBizLogType.REPAY_BIZ, req.getRepayBizCode(),
            repayBiz.getCurNodeCode(), node.getCode(), null, req.getOperator());
        return code;
    }

    @Override
    @Transactional
    public void judgeFinanceCheck(XN630564Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.JUDGE_FINANCE_CHECK.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在司法诉讼财务审核节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = null;
        // 审核通过，诉讼跟进，不通过，重新申请
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode)
                .getNextNode();
        } else {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode)
                .getBackNode();
        }

        repayBizBO.refreshFinanceCheck(req.getRepayBizCode(), nextNodeCode,
            req.getApproveNote(), req.getOperator());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nextNodeCode, req.getApproveNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void cashier(XN630565Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.CASHIER.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在出纳打款节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);

        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);
        judgeBO.cashier(req);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void acceptance(XN630566Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.CASE_ADMISSIBILITY.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在案件受理节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);

        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);
        judgeBO.acceptance(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void toHoldCourt(XN630567Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.SERVICE.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在送达节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);

        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);
        judgeBO.toHoldCourt(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void sentence(XN630568Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.SENTENCE.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在判决节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);

        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);
        judgeBO.sentence(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void takeEffect(XN630569Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.TAKE_EFFECT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在生效节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBiz.setIsImplementAgain(EBoolean.NO.getCode());
        repayBizBO.updateRepayBizImplement(repayBiz);

        judgeBO.takeEffect(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void applyImplement(XN630580Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.APPLY_IMPLEMENT.getCode()
            .equals(repayBiz.getCurNodeCode())
                && !ERepayBizNode.RESULT_INPUT_AGAIN.getCode()
                    .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在申请执行节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);

        judgeBO.applyImplement(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void implementAdmissibility(XN630581Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.IMPLEMENT_ADMISSIBILITY.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在执行案件的案件受理节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);

        judgeBO.implementAdmissibility(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void auction(XN630582Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.AUCTION.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在执行案件的拍卖节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);

        judgeBO.auction(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    public void notice(XN630583Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.NOTICE.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在执行案件的公告节点，不能操作！");
        }
        String curNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        repayBizBO.updateCurNodeCode(repayBiz);

        judgeBO.notice(req);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
            nodeFlow.getNextNode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void judgeResultInput(XN630562Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.JUDGE_RESULT_INPUT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在执行结果录入节点！");
        }
        // 当前节点
        String curNodeCode = repayBiz.getCurNodeCode();

        // 结果为执毕 或 和解，则用户已还欠款；结果为终结，则需要重新诉讼；
        if (EExeResult.FINISH_NORMAL.getCode().equals(req.getExeResult())
                || EExeResult.ABORT.getCode().equals(req.getExeResult())) {
            repayPlanBO.refreshRepayPlanTakeCarHandle(req.getRepayBizCode(),
                ERepayPlanNode.REPAY_YES);
            repayBizBO.refreshJudgePaid(req.getRepayBizCode());

            // 日志记录
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ,
                req.getRepayBizCode(), curNodeCode, null, req.getOperator());
        } else {
            repayBizBO.refreshJudgeAgain(req.getRepayBizCode());

            // 日志记录
            ERepayBizNode node = ERepayBizNode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
            sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getRepayBizCode(),
                EBizLogType.REPAY_BIZ, req.getRepayBizCode(),
                repayBiz.getCurNodeCode(), node.getCode(), null,
                req.getOperator());
        }

        judgeBO.refreshJudgeResultInput(req);

    }

    @Override
    public void resultInputAgain(String code, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.RESULT_INPUT_AGAIN.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在重新申请执行节点，不能操作！");
        }
        // 当前节点
        String curNodeCode = repayBiz.getCurNodeCode();

        repayBizBO.resultInputAgain(code);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(
            nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(code, EBizLogType.REPAY_BIZ, code,
            repayBiz.getCurNodeCode(), node.getCode(), null, operator);
    }

    @Override
    public void inputVerdict(XN630584Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.ADJUDICATION_DEADLINE.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在录入查封裁定到期时间节点，不能操作！");
        }
        // 当前节点
        String curNodeCode = repayBiz.getCurNodeCode();

        repayBizBO.inputVerdict(req.getRepayBizCode());

        judgeBO.inputVerdict(req);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(
            nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), node.getCode(), null, req.getOperator());
    }

    @Override
    public Paginable<Judge> queryJudgePage(int start, int limit,
            Judge condition) {
        Paginable<Judge> page = judgeBO.getPaginable(start, limit, condition);
        List<Judge> list = page.getList();
        for (Judge judge : list) {
            initJudge(judge);
        }
        return page;
    }

    @Override
    public List<Judge> queryJudgeList(Judge condition) {
        List<Judge> list = judgeBO.queryJudgeList(condition);
        for (Judge judge : list) {
            initJudge(judge);
        }
        return list;
    }

    @Override
    public Judge getJudge(String code) {
        Judge judge = judgeBO.getJudge(code);
        initJudge(judge);
        return judge;
    }

    private void initJudge(Judge judge) {
        SYSUser updater = sysUserBO.getUser(judge.getUpdater());
        if (null != updater) {
            judge.setUpdaterName(updater.getRealName());
        }
    }

}
