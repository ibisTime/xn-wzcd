package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.req.XN632111ReqChild;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:51:03 
 * @history:
 */
@Service
public class CreditUserAOImpl implements ICreditUserAO {

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ICreditAO creditAO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public CreditUser getCreditUserReport(String code) {

        return creditUserBO.getCreditUser(code);

    }

    @Override
    public void inputBankCreditResult(XN632111Req req) {

        Credit credit = creditAO.getCredit(req.getCreditCode());

        if (credit == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "征信单不存在");
        }

        if (!ECreditNode.LRZXY.getCode().equals(credit.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是录入征信源结果节点，不能操作");
        }

        List<XN632111ReqChild> list = req.getBankCreditResultList();
        for (XN632111ReqChild child : list) {
            String code = child.getCode();
            if (StringUtils.isBlank(code)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "征信人员编号不能为空");
            }
            CreditUser creditUser = creditUserBO.getCreditUser(code);
            creditUser.setDkdyCount(StringValidater.toInteger(child
                .getDkdyCount()));
            creditUser.setDkdyAmount(StringValidater.toLong(child
                .getDkdyAmount()));
            creditUser.setDkdy2YearOverTimes(StringValidater.toInteger(child
                .getDkdy2yearOverTimes()));
            creditUser.setDkdyMaxOverAmount(StringValidater.toLong(child
                .getDkdyMaxOverAmount()));
            creditUser.setDkdyCurrentOverAmount(StringValidater.toLong(child
                .getDkdyCurrentOverAmount()));
            creditUser.setDkdy6MonthAvgAmount(StringValidater.toLong(child
                .getDkdy6monthAvgAmount()));

            creditUser.setHkxyUnsettleCount(StringValidater.toInteger(child
                .getHkxyUnsettleCount()));
            creditUser.setHkxyUnsettleAmount(StringValidater.toLong(child
                .getHkxyUnsettleAmount()));
            creditUser.setHkxy2YearOverTimes(StringValidater.toInteger(child
                .getHkxy2yearOverTimes()));
            creditUser.setHkxyMonthMaxOverAmount(StringValidater.toLong(child
                .getHkxyMonthMaxOverAmount()));
            creditUser.setHkxy6MonthAvgAmount(StringValidater.toLong(child
                .getHkxy6monthAvgAmount()));
            creditUser.setHkxyCurrentOverAmount(StringValidater.toLong(child
                .getHkxyCurrentOverAmount()));

            creditUser.setXykCount(StringValidater.toInteger(child
                .getXykCount()));
            creditUser.setXykCreditAmount(StringValidater.toLong(child
                .getXykCreditAmount()));
            creditUser.setXyk6MonthUseAmount(StringValidater.toLong(child
                .getXyk6monthUseAmount()));
            creditUser.setXyk2YearOverTimes(StringValidater.toInteger(child
                .getXyk2yearOverTimes()));
            creditUser.setXykMonthMaxOverAmount(StringValidater.toLong(child
                .getXykMonthMaxOverAmount()));
            creditUser.setXykCurrentOverAmount(StringValidater.toLong(child
                .getXykCurrentOverAmount()));

            creditUser.setOutGuaranteesCount(StringValidater.toInteger(child
                .getOutGuaranteesCount()));
            creditUser.setOutGuaranteesAmount(StringValidater.toLong(child
                .getOutGuaranteesAmount()));
            creditUser.setOutGuaranteesRemark(child.getOutGuaranteesRemark());

            creditUserBO.inputBankCreditResult(creditUser);
        }

        // 之前节点
        String preCurrentNode = credit.getCurNodeCode();
        credit.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
            credit.getCurNodeCode()).getNextNode());
        creditBO.refreshCreditNode(credit);

        // 日志记录
        ECreditNode currentNode = ECreditNode.getMap().get(
            credit.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(credit.getCode(),
            EBizLogType.CREDIT, credit.getCode(), preCurrentNode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());

    }
}
