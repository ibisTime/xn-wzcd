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
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630560Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
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
            throw new BizException("xn0000", "当前还款业务不在司法诉讼节点！");
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
    public void judgeResultInput(XN630562Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.JUDGE_RESULT_INPUT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前业务不在执行结果录入节点！");
        }
        // 当前节点
        String curNodeCode = repayBiz.getCurNodeCode();

        judgeBO.refreshJudgeResultInput(req);
        // 结果为完毕，则用户已还欠款；结果为中止，则需要重新诉讼；结果为终结，则为坏账；
        if (EExeResult.FINISH_NORMAL.getCode().equals(req.getExeResult())) {// 还款计划设置为已还清

            repayPlanBO.refreshRepayPlanTakeCarHandle(req.getCode(),
                ERepayPlanNode.REPAY_YES);
            repayBizBO.refreshJudgePaid(req.getCode());

            // 日志记录
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ,
                req.getCode(), curNodeCode, null, req.getOperator());

        } else if (EExeResult.ABORT.getCode().equals(req.getExeResult())) {// 还款计划不操作

            repayBizBO.refreshJudgeAgain(req.getCode());

            // 日志记录
            ERepayBizNode node = ERepayBizNode.getMap().get(
                nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
            sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getCode(),
                EBizLogType.REPAY_BIZ, req.getCode(), repayBiz.getCurNodeCode(),
                node.getCode(), node.getValue(), req.getOperator());

        } else if (EExeResult.FINISH_BAD.getCode().equals(req.getExeResult())) {

            // 还款计划处理为坏账
            repayPlanBO.refreshRepayPlanTakeCarHandle(req.getCode(),
                ERepayPlanNode.BAD_DEBT);
            repayBizBO.refreshJudgeBad(req.getCode());

            // 更新预算单节点
            BudgetOrder condition = new BudgetOrder();
            condition.setRepayBizCode(repayBiz.getCode());
            List<BudgetOrder> budgetOrderList = budgetOrderBO
                .queryBudgetOrderList(condition);
            BudgetOrder budgetOrder = budgetOrderList.get(0);
            budgetOrder.setCurNodeCode(ERepayBizNode.JUDGE_BAD.getCode());
            budgetOrderBO.updateCurNodeCode(budgetOrder);

            User user = userBO.getUser(repayBiz.getUserId());
            userBO.refreshBlackSign(user, req.getOperator());

            // 日志记录
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ,
                req.getCode(), curNodeCode, null, req.getOperator());
        }

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

        SYSUser exeApplyUser = sysUserBO.getUser(judge.getExeApplyUser());
        if (null != exeApplyUser) {
            judge.setExeApplyUserName(exeApplyUser.getRealName());
        }
    }

}
